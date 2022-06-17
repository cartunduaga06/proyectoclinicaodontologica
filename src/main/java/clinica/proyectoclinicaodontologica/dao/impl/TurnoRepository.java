package clinica.proyectoclinicaodontologica.dao.impl;


import clinica.proyectoclinicaodontologica.dao.Idao;
import clinica.proyectoclinicaodontologica.model.Turno;

import java.util.ArrayList;
import java.util.List;

public class TurnoRepository implements Idao<Turno> {

    private List<Turno> turnos = new ArrayList<>();


    @Override
    public Turno guardar(Turno turno) {
        turnos.add(turno);
        return turno;
    }

    @Override
    public List<Turno> buscarTodos() {
        return null;
    }

    @Override
    public Turno buscar(int id) {
       for (Turno turno : turnos) {
           if (turno.getId() == id) {
               return turno;
           }
       }
        return null;
    }

    @Override
    public void eliminar(int id) {

    }

    @Override
    public Turno actualizar(Turno turno) {
        return null;
    }

}



