package com.example.UniCRUD.controller;

import com.example.UniCRUD.entity.Facultad;
import com.example.UniCRUD.service.FacultadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/facultades")
public class FacultadController {

    @Autowired
    private FacultadService facultadService;

    @GetMapping
    public List<Facultad> listarFacultades() {
        return facultadService.obtenerTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Facultad> obtenerFacultadPorId(@PathVariable Long id) {
        Optional<Facultad> facultad = facultadService.obtenerPorId(id);
        return facultad.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Facultad crearFacultad(@RequestBody Facultad facultad) {
        return facultadService.crearFacultad(facultad);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Facultad> actualizarFacultad(@PathVariable Long id, @RequestBody Facultad facultad) {
        Facultad actualizada = facultadService.actualizarFacultad(id, facultad);
        return actualizada != null ? ResponseEntity.ok(actualizada) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrarFacultad(@PathVariable Long id) {
        facultadService.borrarFacultad(id);
        return ResponseEntity.noContent().build();
    }
}
