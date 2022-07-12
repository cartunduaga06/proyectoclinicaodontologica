package clinica.proyectoclinicaodontologica.service;



import clinica.proyectoclinicaodontologica.exceptions.BadRequestException;
import clinica.proyectoclinicaodontologica.exceptions.ResourceNotFoundException;
import clinica.proyectoclinicaodontologica.model.Turno;
import clinica.proyectoclinicaodontologica.repository.TurnoRepository;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TurnoService {

    private TurnoRepository turnoRepository;

    //logger
    private static final Logger logger = Logger.getLogger(TurnoService.class);

    public TurnoService(TurnoRepository turnoRepository) {
        this.turnoRepository = turnoRepository;
    }

    public Turno guardar(Turno t) {
        //fecha turno
        //t.setFecha(new Date());

        return turnoRepository.save(t);
    }

    public Turno buscar(Integer id) {
        Turno turno = null;
        Optional<Turno> optionalTurno = turnoRepository.findById(id);
        if (optionalTurno.isPresent()) {
            turno = optionalTurno.get();


        }

        logger.info("Turno encontrado: " + turno);
        return turno;
    }

    public List<Turno> buscarTodos() {
        return turnoRepository.findAll();
    }

    public void eliminar(Integer id)  throws BadRequestException {
        if (this.buscar(id) == null) {
            logger.error("Turno no existe con id " + id);
            throw new BadRequestException("turno no existe con id " + id);
        } else {
            logger.info("Turno eliminado: " + id);
            turnoRepository.deleteById(id);
        }
    }

    public Turno actualizar(Turno t) {
        return turnoRepository.save(t);
    }
}


