package com.api.rest.demo.service.impl;

import com.api.rest.demo.exception.ResourceNotFoundException;
import com.api.rest.demo.model.Empleado;
import com.api.rest.demo.repository.EmpleadoRepository;
import com.api.rest.demo.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Override
    public Empleado saveEmpleado(Empleado empleado) {
        Optional<Empleado> empleadoGuardado = empleadoRepository.findByEmail(empleado.getEmail());
        if(empleadoGuardado.isPresent()){
            throw new ResourceNotFoundException("El empleado con ese email ya no existe: " + empleado.getEmail());
        }
        return empleadoRepository.save(empleado);
    }

    @Override
    public List<Empleado> getAllEmpleados() {
        return empleadoRepository.findAll();
    }

    @Override
    public Optional<Empleado> getEmpleadoById(long id) {
        return empleadoRepository.findById(id);
    }

    @Override
    public Empleado updateEmpleado(Empleado empleadoActualizado) {
        return empleadoRepository.save(empleadoActualizado);
    }

    @Override
    public void deleteEmpleado(long id) {
        empleadoRepository.deleteById(id);
    }
}
