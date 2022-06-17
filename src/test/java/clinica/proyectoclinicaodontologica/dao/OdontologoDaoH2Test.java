package clinica.proyectoclinicaodontologica.dao;


import clinica.proyectoclinicaodontologica.dao.impl.OdontologoDaoH2;
import clinica.proyectoclinicaodontologica.model.Odontologo;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class OdontologoDaoH2Test {

    private static Idao<Odontologo> odontologoDao = new OdontologoDaoH2();

    @BeforeClass
    public static void cargarOdontologos(){
        odontologoDao.guardar(new Odontologo(1234,"Hernan", "perez"));
    }

    @Test
    public  void guardarOdontologo(){
        Odontologo odontologo = odontologoDao.guardar(new Odontologo(12345,"esteban", "villa"));

        Assert.assertEquals(odontologo.getNombre(), "esteban");
    }

    /*
    @Test
    public void  consultaOdontologosTest(){
        List<Odontologo> odontologos = odontologoDao.buscarTodos();
        Assert.assertTrue(odontologos.size()>0);
    }
    */
}
