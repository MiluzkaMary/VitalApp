package com.saludvital.services.impl;

import com.saludvital.model.Doctor;
import com.saludvital.repositories.DoctorRepository;
import com.saludvital.services.interfaces.DoctorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServicioImpl implements DoctorServicio {

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public Doctor crearDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public Doctor obtenerDoctorPorId(int id) {
        return doctorRepository.findById(id).orElse(null);
    }

    @Override
    public List<Doctor> listarDoctores() {
        return doctorRepository.findAll();
    }

    @Override
    public Doctor actualizarDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public void eliminarDoctor(int id) {
        doctorRepository.deleteById(id);
    }
}