package clinica.proyectoclinicaodontologica.service;

import clinica.proyectoclinicaodontologica.exceptions.ResourceNotFoundException;
import clinica.proyectoclinicaodontologica.model.Odontologo;
import org.junit.Assert;
import org.junit.BeforeClass;

import org.junit.FixMethodOrder;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest

public class OdontologoServiceTest {

    //TEST PARA ODONTOLOGOSERVICE
    @Autowired
    private OdontologoService odontologoService;



    public void setUpClass() {
       Odontologo odontologo =  odontologoService.guardar(new Odontologo(1234, "Perez", "Perez"));
         Odontologo odontologo2 =  odontologoService.guardar(new Odontologo(1235, "Perez", "Perez"));

    }

    @Test
    public void testBuscarTodos() {
        List<Odontologo> odontologos = odontologoService.buscarTodos();
        Assert.assertTrue(odontologos.size()> 0);
    }

    @Test
    public void testBuscarPorId() {
        Odontologo odontologo =  odontologoService.guardar(new Odontologo(555, "maria", "Perez"));

        Odontologo odontologo2 = odontologoService.buscar(odontologo.getId());
        assertEquals(odontologo2.getNombre(), odontologo.getNombre());

    }

    @Test
    public void testGuardarOdontologo() {
        Odontologo odontologo = odontologoService.guardar(new Odontologo(1236, "Perez", "Perez"));
        assertEquals(odontologo.getNombre(), "Perez");
    }

    @Test
    public void testActualizarOdontologo() {
        Odontologo odontologo = odontologoService.guardar(new Odontologo(1236, "Perez", "Perez"));
        odontologo.setNombre("Perez");
        odontologoService.actualizar(odontologo);
        assertEquals(odontologo.getNombre(), "Perez");
    }

    @Test
    public void testEliminarOdontologo() throws ResourceNotFoundException {
        Odontologo odontologo = odontologoService.guardar(new Odontologo(1236, "Perez", "Perez"));
        odontologoService.eliminar(odontologo.getId());
        Odontologo odontologo2 = odontologoService.buscar(odontologo.getId());
        assertEquals(odontologo2, null);
    }
}



