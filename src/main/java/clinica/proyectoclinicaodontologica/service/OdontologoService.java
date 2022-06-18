package clinica.proyectoclinicaodontologica.service;

import clinica.proyectoclinicaodontologica.repository.Idao;
import clinica.proyectoclinicaodontologica.model.Odontologo;


import java.util.List;

public class OdontologoService {

    //atributo
    private Idao<Odontologo> odontologodao;


    //constructor
    public OdontologoService(Idao<Odontologo> odontologodao) {
        this.odontologodao = odontologodao;
    }

    //Operaciones

    public Odontologo guardar (Odontologo odontologo) {
        return odontologodao.guardar(odontologo);
    }



    public List<Odontologo> buscarTodos() {
        return odontologodao.buscarTodos();
    }


    public Odontologo buscarPorId(int id) {
        return odontologodao.buscar(id);
    }

    public Odontologo actualizar(Odontologo odontologo) {
        return odontologodao.actualizar(odontologo);
    }

    public void eliminar(int id) {
        odontologodao.eliminar(id);
    }
}
