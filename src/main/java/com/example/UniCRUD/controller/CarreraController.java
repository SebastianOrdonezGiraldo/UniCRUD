package com.example.UniCRUD.controller;

import com.example.UniCRUD.entity.Carrera;
import com.example.UniCRUD.service.CarreraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/carreras")
public class CarreraController {

    @Autowired
    private CarreraService carreraService;

    @GetMapping
    public List<Carrera> listarCarreras() {
        return carreraService.obtenerTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carrera> obtenerCarreraPorId(@PathVariable Long id) {
        Optional<Carrera> carrera = carreraService.obtenerPorId(id);
        return carrera.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Carrera crearCarrera(@RequestBody Carrera carrera) {
        return carreraService.crearCarrera(carrera);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Carrera> actualizarCarrera(@PathVariable Long id, @RequestBody Carrera carrera) {
        Carrera actualizada = carreraService.actualizarCarrera(id, carrera);
        return actualizada != null ? ResponseEntity.ok(actualizada) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrarCarrera(@PathVariable Long id) {
        carreraService.borrarCarrera(id);
        return ResponseEntity.noContent().build();
    }
}

