package clinica.proyectoclinicaodontologica.service;




import clinica.proyectoclinicaodontologica.dao.Idao;
import clinica.proyectoclinicaodontologica.model.Paciente;

import java.util.Date;
import java.util.List;

public class PacienteService {

    private Idao<Paciente> pacienteIDao;

    public PacienteService(Idao<Paciente> pacienteIDao) {
        this.pacienteIDao = pacienteIDao;
    }

    public Paciente guardar(Paciente p) {
        p.setFechaIngreso(new Date());
        return pacienteIDao.guardar(p);
    }

    public Paciente buscar(Integer id) {
        return pacienteIDao.buscar(id);
    }

    public List<Paciente> buscarTodos() {
        return pacienteIDao.buscarTodos();
    }

    public void eliminar(Integer id) {
        pacienteIDao.eliminar(id);
    }

    public Paciente actualizar(Paciente p) {
        return pacienteIDao.actualizar(p);
    }
}
