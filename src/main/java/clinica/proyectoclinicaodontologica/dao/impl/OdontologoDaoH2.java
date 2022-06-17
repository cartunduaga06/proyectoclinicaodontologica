package clinica.proyectoclinicaodontologica.dao.impl;

import clinica.proyectoclinicaodontologica.dao.Idao;
import clinica.proyectoclinicaodontologica.model.Odontologo;

import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Class.forName;


public class OdontologoDaoH2 implements Idao<Odontologo> {

    private static final Logger logger = Logger.getLogger(OdontologoDaoH2.class);
    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:~/db_new1";
    private final static String DB_USER ="sa";
    private final static String DB_PASSWORD = "sa";
    private static final String SQL_CREATE = "create table IF NOT EXISTS odontologos (id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, matricula BIGINT, nombre varchar(255),apellido varchar (255));";
    private static final String SQL_CONSULTA = "select * from odontologos";
    public OdontologoDaoH2(){

    }

    @Override
    public Odontologo guardar(Odontologo odontologo) {



        Connection connection = null;
        PreparedStatement preparedStatement = null;



        try {
            logger.info("levantando el driver  y conexiones para guardar");
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            Statement statement = connection.createStatement();
            statement.execute(SQL_CREATE);

            logger.info("creando sentencia");
            preparedStatement = connection.prepareStatement("INSERT INTO odontologos(matricula, nombre, apellido) VALUES(?,?,?)");
            //preparedStatement.setInt(1,odontologo.getId());
            preparedStatement.setInt(1,odontologo.getNumeroMatricula());
            preparedStatement.setString(2, odontologo.getNombre());
            preparedStatement.setString(3, odontologo.getApellido());


            logger.info("ejecutando la sentencia SQL");
            preparedStatement.executeUpdate();


        } catch (Exception e ) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        logger.info("añadiendo a "+odontologo);
        return odontologo;
    }



    @Override
    public List<Odontologo> buscarTodos() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        List<Odontologo> odontologos = new ArrayList<>();

        try {
            logger.info("levantando el driver  y conexiones para consultar");
            forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);


            logger.info("creando sentencia de consulta");
            preparedStatement = connection.prepareStatement(SQL_CONSULTA);

            logger.info("ejecutando sentencia de consulta");
            ResultSet result = preparedStatement.executeQuery();

            logger.info("obteniendo resultados");
            while (result.next()){
                int id = result.getInt("id");
                int matricula = result.getInt("matricula");
                String nombre = result.getString("nombre");
                String apellidos = result.getString("apellido");
                odontologos.add(new Odontologo(id, matricula, nombre, apellidos));
            }



        } catch (SQLException | ClassNotFoundException e ) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        logger.info(odontologos);
        return odontologos;
    }

    @Override
    public Odontologo buscar(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Odontologo odontologo = null;

        try {
            logger.info("levantando el driver  y conexiones para consultar");
            forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            logger.info("buscando por id");
            preparedStatement = connection.prepareStatement("SELECT * FROM odontologos WHERE id = ?");
            preparedStatement.setInt(1, id);

            logger.info("ejecutando sentencia de consulta");
            ResultSet result = preparedStatement.executeQuery();

            logger.info("obteniendo resultados");
            if (result.next()) {
                int matricula = result.getInt("matricula");
                String nombre = result.getString("nombre");
                String apellido = result.getString("apellido");
                odontologo = new Odontologo(id, matricula, nombre, apellido);
            }



        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return odontologo;
    }

    @Override
    public void eliminar(Integer id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            logger.info("levantando el driver  y conexiones para eliminar");
            forName(DB_JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Odontologo actualizar(Odontologo odontologo) {
        return null;
    }
}
