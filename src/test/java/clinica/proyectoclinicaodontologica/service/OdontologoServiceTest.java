package clinica.proyectoclinicaodontologica.service;

import clinica.proyectoclinicaodontologica.model.Odontologo;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@FixMethodOrder
@RunWith(SpringRunner.class)
@SpringBootTest
public class OdontologoServiceTest {

    //TEST PARA ODONTOLOGOSERVICE
    @Autowired
    private OdontologoService odontologoService;


    @BeforeClass
    public static void setUpClass() {
        Odontologo odontologo = new Odontologo();
        odontologo.setNombre("Juan");
        odontologo.setApellido("Perez");


    }

    @Test
    public void testBuscarTodos() {
        List<Odontologo> odontologos = odontologoService.buscarTodos();
        assertEquals(odontologos.size(), 2);
    }


    }



