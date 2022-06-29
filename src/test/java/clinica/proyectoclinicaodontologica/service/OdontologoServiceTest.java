package clinica.proyectoclinicaodontologica.service;

import clinica.proyectoclinicaodontologica.model.Odontologo;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

        assertEquals(1, odontologoService.buscarTodos().size());
    }


}
