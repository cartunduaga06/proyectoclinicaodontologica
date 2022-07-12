package clinica.proyectoclinicaodontologica.service;
import clinica.proyectoclinicaodontologica.exceptions.ResourceNotFoundException;
import clinica.proyectoclinicaodontologica.model.Odontologo;
import clinica.proyectoclinicaodontologica.model.Paciente;
import clinica.proyectoclinicaodontologica.repository.PacienteRepository;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {


    private PacienteRepository pacienteRepository;

    //logger
    private static final Logger logger = Logger.getLogger(PacienteService.class);

    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public Paciente guardar(Paciente p) {
        p.setFechaIngreso(new Date());
        return pacienteRepository.save(p);
    }

    public  Paciente buscar(Integer id) {
        Paciente paciente = null;
        Optional<Paciente> optionalPaciente = pacienteRepository.findById(id);
        if (optionalPaciente.isPresent()) {
            paciente = optionalPaciente.get();
        }
        logger.info("Paciente encontrado: " + paciente);
        return paciente;
    }

    public List<Paciente> buscarTodos() {
        return pacienteRepository.findAll();
    }

    public void eliminar(Integer id) throws ResourceNotFoundException {

        if(this.buscar(id) == null){
            logger.error("Paciente no existe con id " + id);
            throw new ResourceNotFoundException("paciente no existe con id " + id);
        } else
        {
            logger.info("Paciente eliminado: " + id);
            pacienteRepository.deleteById(id);
        }

    }


    public Paciente actualizar(Paciente p) {
        return pacienteRepository.save(p);
    }
}
