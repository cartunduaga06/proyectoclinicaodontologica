package clinica.proyectoclinicaodontologica.service;
import clinica.proyectoclinicaodontologica.model.Paciente;
import clinica.proyectoclinicaodontologica.repository.PacienteRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PacienteService {


    private PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public Paciente guardar(Paciente p) {
        p.setFechaIngreso(new Date());
        return pacienteRepository.save(p);
    }

    public  Paciente buscar(Integer id) {
        return pacienteRepository.findById(id).get();
    }

    public List<Paciente> buscarTodos() {
        return pacienteRepository.findAll();
    }

    public void eliminar(Integer id) {
        pacienteRepository.deleteById(id);
    }


    public Paciente actualizar(Paciente p) {
        return pacienteRepository.save(p);
    }
}
