package clinica.proyectoclinicaodontologica.service;



import clinica.proyectoclinicaodontologica.model.Turno;
import clinica.proyectoclinicaodontologica.repository.TurnoRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TurnoService {

    private TurnoRepository turnoRepository;

    public TurnoService(TurnoRepository turnoRepository) {
        this.turnoRepository = turnoRepository;
    }

    public Turno guardar(Turno t) {
        //fecha turno
        //t.setFecha(new Date());

        return turnoRepository.save(t);
    }

    public Turno buscar(Integer id) {
        return turnoRepository.findById(id).get();
    }

    public List<Turno> buscarTodos() {
        return turnoRepository.findAll();
    }

    public void eliminar(Integer id) {
        turnoRepository.deleteById(id);
    }

    public Turno actualizar(Turno t) {
        return turnoRepository.save(t);
    }
}


