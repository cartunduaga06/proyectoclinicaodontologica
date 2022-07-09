package clinica.proyectoclinicaodontologica.service;

import clinica.proyectoclinicaodontologica.model.Domicilio;
import clinica.proyectoclinicaodontologica.model.Odontologo;
import clinica.proyectoclinicaodontologica.model.Paciente;
import clinica.proyectoclinicaodontologica.model.Turno;
import org.apache.log4j.Logger;
import org.junit.Assert;
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
public class TurnoServiceTest {

    @Autowired
    private  TurnoService turnoService;

    @Autowired
    private OdontologoService odontologoService;

    @Autowired
    private PacienteService pacienteService;

    //logger para imprimir en consola
    private static Logger logger = Logger.getLogger(TurnoServiceTest.class.getName());


   public void cargardatos(){

       // se registra paciente y odontologo
       Domicilio domicilio = new Domicilio( "123", "123", "123", "123");
       Paciente paciente = pacienteService.guardar(new Paciente("Carlos","arti","123456789",new Date(), domicilio));
            Odontologo odontologo = odontologoService.guardar(new Odontologo(1234, "Perez", "Perez"));
            // se registra turno
           Turno turno = new Turno();
                turno.setId(1);
                turno.setPaciente(paciente);
                turno.setOdontologo(odontologo);
                turno.setFecha(new Date());
                turnoService.guardar(turno);
                logger.info("Se registro turno" + turno.toString());
   }

   @Test
    public void testBuscarTodos(){
         cargardatos();
         List<Turno> turnos = turnoService.buscarTodos();
            Assert.assertTrue(turnos.size()!= 0);
         Assert.assertTrue(turnos.size()>0);
            logger.info("Se encontraron " + turnos.size() + " turnos");
    }

    @Test
    public void testBuscarPorId(){
       // nuevo turno
        Domicilio domicilio = new Domicilio( "123", "123", "123", "123");
        Paciente paciente = pacienteService.guardar(new Paciente("Carlos","arti","123456789",new Date(), domicilio));
        Odontologo odontologo = odontologoService.guardar(new Odontologo(1234, "Ari", "acuña"));
        // se registra turno
        Turno turno = new Turno();



        turno.setPaciente(paciente);
        turno.setOdontologo(odontologo);
        turno.setFecha(new Date());
        turnoService.guardar(turno);





         Assert.assertEquals(turno.getPaciente().getNombre(), "Carlos");
            Assert.assertEquals(turno.getOdontologo().getNombre(), "Ari");
            logger.info("Se busco el  turno" + turno.toString());

    }

    @Test
    public void testActualizarTurno() {

        // nuevos datos
        Domicilio domicilio = new Domicilio( "123", "123", "123", "123");
        Paciente paciente = pacienteService.guardar(new Paciente("Carlos","arti","123456789",new Date(), domicilio));
        Odontologo odontologo = odontologoService.guardar(new Odontologo(1234, "Ari", "acuña"));
        // se registra turno
        Turno turno = new Turno();

        turno.setPaciente(paciente);
        turno.setOdontologo(odontologo);
        turno.setFecha(new Date());
        turnoService.guardar(turno);

        // nuevo odontologo
        Odontologo odontologo2 = odontologoService.guardar(new Odontologo(1234, "Perez", "Perez"));
        // se actualiza turno
        turno.setOdontologo(odontologo2);
        turnoService.actualizar(turno);

        // se busca turno actualizado
        Turno turno2 = turnoService.buscar(turno.getId());
        Assert.assertEquals(turno2.getOdontologo().getNombre(), "Perez");
        logger.info("Se actualizo turno" + turno2.toString());


    }





}
