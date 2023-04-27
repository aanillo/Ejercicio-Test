package com.api.rest.demo.service;

import static org.mockito.BDDMockito.given;

import com.api.rest.demo.model.Empleado;
import com.api.rest.demo.repository.EmpleadoRepository;
import com.api.rest.demo.service.impl.EmpleadoServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class EmpleadoServiceTest {

    @Mock
    private EmpleadoRepository empleadoRepository;

    @InjectMocks
    private EmpleadoServiceImpl empleadoService;

    private Empleado empleado;

    @Test
    void testGuardarEmpleado(){
        given(empleadoRepository.findByEmail(empleado.getEmail()))
                .willReturn(Optional.empty());
        given(empleadoRepository.save(empleado)).willReturn(empleado);

        Empleado empleadoGuardado = empleadoService.saveEmpleado(empleado);

        assertThat(empleadoGuardado).isNotNull();
    }
}
