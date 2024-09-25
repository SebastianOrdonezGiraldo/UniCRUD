package com.example.UniCRUD.service;

import com.example.UniCRUD.entity.Carrera;
import com.example.UniCRUD.repository.CarreraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarreraService {

    @Autowired
    private CarreraRepository carreraRepository;

    public List<Carrera> obtenerTodas() {
        return carreraRepository.findAll();
    }

    public Optional<Carrera> obtenerPorId(Long id) {
        return carreraRepository.findById(id);
    }

    public Carrera crearCarrera(Carrera carrera) {
        return carreraRepository.save(carrera);
    }

    public Carrera actualizarCarrera(Long id, Carrera carrera) {
        if (carreraRepository.existsById(id)) {
            carrera.setIdcarrera(id);
            return carreraRepository.save(carrera);
        }
        return null;
    }

    public void borrarCarrera(Long id) {
        carreraRepository.deleteById(id);
    }
}
