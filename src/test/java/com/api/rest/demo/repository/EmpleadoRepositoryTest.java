package com.api.rest.demo.repository;

import static org.assertj.core.api.Assertions.assertThat;
import com.api.rest.demo.model.Empleado;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
public class EmpleadoRepositoryTest {

    @Autowired
    private EmpleadoRepository empleadoRepository;
    private Empleado empleado;

    @Test
    void testGuardarEmpleado(){
        Empleado empleado1 = Empleado.builder()
                .nombre("Pepe")
                .apellido("López")
                .email("p12@gmail.com")
                .build();

        Empleado empleadoGuardado = empleadoRepository.save(empleado1);

        assertThat(empleadoGuardado).isNotNull();
        assertThat(empleadoGuardado.getId()).isGreaterThan(0);
    }

    @Test
    void testObtenerEmpleadoPorId(){
        empleadoRepository.save(empleado);

        Empleado empleadoBD = empleadoRepository.findById(empleado.getId()).get();
        assertThat(empleadoBD).isNotNull();
    }


    @Test
    void testEliminarEmpleado(){
        empleadoRepository.save(empleado);

        empleadoRepository.deleteById(empleado.getId());
        Optional<Empleado> empleadoOptional = empleadoRepository.findById(empleado.getId());
    }
}
