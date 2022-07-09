package clinica.proyectoclinicaodontologica.service;


import clinica.proyectoclinicaodontologica.exceptions.ResourceNotFoundException;
import clinica.proyectoclinicaodontologica.model.Domicilio;
import clinica.proyectoclinicaodontologica.model.Paciente;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class PacienteServiceTest {

    //TEST PARA PACIENTESERVICE
    @Autowired
    private  PacienteService pacienteService;
    @Autowired
    private DomicilioService domicilioService;


    //@BeforeClass
    public  void cargarDataSet() {
        Domicilio domicilio = domicilioService.guardar(new Domicilio("Av Santa fe", "444", "CABA", "Buenos Aires"));
        Paciente p = pacienteService.guardar(new Paciente("Santiago", "Paz", "88888888", new Date(), domicilio));
        Domicilio domicilio1 = domicilioService.guardar(new Domicilio("Av Avellaneda", "333", "CABA", "Buenos Aires"));
        Paciente p1 = pacienteService.guardar(new Paciente("Micaela", "Perez", "99999999", new Date(), domicilio));
    }

    @Test
    public void agregarYBuscarPacienteTest(){
        Domicilio domicilio = domicilioService.guardar(new Domicilio("Calle", "123", "Temperley", "Buenos Aires"));
        Paciente p = pacienteService.guardar(new Paciente("Tomas", "Pereyra", "12345678", new Date(), domicilio));

        Assert.assertNotNull(pacienteService.buscar(p.getId()));
    }


    @Test
    public void eliminarPacienteTest() throws ResourceNotFoundException {
        Domicilio domicilio = domicilioService.guardar(new Domicilio("Calle", "123", "Temperley", "Buenos Aires"));
        Paciente p = pacienteService.guardar(new Paciente("Tomas", "Pereyra", "12345678", new Date(), domicilio));
        pacienteService.eliminar(p.getId());
        Assert.assertTrue(pacienteService.buscar(3) == null);

    }

    @Test
    public void traerTodos() {
        List<Paciente> pacientes = pacienteService.buscarTodos();
        Assert.assertTrue(!pacientes.isEmpty());
        Assert.assertTrue(pacientes.size() > 0);
        System.out.println(pacientes);

    }

}
