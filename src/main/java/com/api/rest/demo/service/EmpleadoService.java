package com.api.rest.demo.service;

import com.api.rest.demo.model.Empleado;

import java.util.List;
import java.util.Optional;

public interface EmpleadoService {
    Empleado saveEmpleado(Empleado empleado);
    List<Empleado> getAllEmpleados();
    Optional<Empleado> getEmpleadoById(long id);
    Empleado updateEmpleado(Empleado empleadoActualizado);
    void deleteEmpleado(long id);
}
