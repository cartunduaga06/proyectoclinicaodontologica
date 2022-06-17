package clinica.proyectoclinicaodontologica.service;


import clinica.proyectoclinicaodontologica.dao.Idao;
import clinica.proyectoclinicaodontologica.model.Turno;

import java.util.List;

public class TurnoService {

    private Idao<Turno> turnorepository;

    public TurnoService(Idao<Turno> turnodao) {
        this.turnorepository = turnodao;
    }

    public Turno guardar(Turno turno) {
        return turnorepository.guardar(turno);
    }

    public List<Turno> buscarTodos() {
        return turnorepository.buscarTodos();
    }

    public Turno buscarPorId(int id) {
        return turnorepository.buscar(id);
    }



}
