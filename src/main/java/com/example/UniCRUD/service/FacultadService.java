package com.example.UniCRUD.service;

import com.example.UniCRUD.entity.Facultad;
import com.example.UniCRUD.repository.FacultadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacultadService {

    @Autowired
    private FacultadRepository facultadRepository;

    public List<Facultad> obtenerTodas() {
        return facultadRepository.findAll();
    }

    public Optional<Facultad> obtenerPorId(Long id) {
        return facultadRepository.findById(id);
    }

    public Facultad crearFacultad(Facultad facultad) {
        return facultadRepository.save(facultad);
    }

    public Facultad actualizarFacultad(Long id, Facultad facultad) {
        if (facultadRepository.existsById(id)) {
            facultad.setIdfacultad(id);
            return facultadRepository.save(facultad);
        }
        return null;
    }

    public void borrarFacultad(Long id) {
        facultadRepository.deleteById(id);
    }
}

