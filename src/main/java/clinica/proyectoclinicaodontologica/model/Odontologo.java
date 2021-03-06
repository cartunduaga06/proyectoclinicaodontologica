package clinica.proyectoclinicaodontologica.model;

import javax.persistence.*;

@Entity
@Table(name = "odontologo")

public class Odontologo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "odontologo_secuencia")

    private int id;
    private int NumeroMatricula;
    private String Nombre;
    private String Apellido;

    public Odontologo(int id, int numeroMatricula, String nombre, String apellido) {
        this.id = id;
        NumeroMatricula = numeroMatricula;
        Nombre = nombre;
        this.Apellido = apellido;
    }

    public Odontologo(int numeroMatricula, String nombre, String apellido) {
        NumeroMatricula = numeroMatricula;
        Nombre = nombre;
        Apellido = apellido;
    }

    public Odontologo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumeroMatricula() {
        return NumeroMatricula;
    }

    public void setNumeroMatricula(int numeroMatricula) {
        NumeroMatricula = numeroMatricula;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        this.Apellido = apellido;
    }

    @Override
    public String toString() {
        return "model.Odontologo{" +
                "id=" + id +
                ", NumeroMatricula=" + NumeroMatricula +
                ", Nombre='" + Nombre + '\'' +
                ", APellido='" + Apellido + '\'' +
                '}';
    }
}
