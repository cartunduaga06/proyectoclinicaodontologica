package clinica.proyectoclinicaodontologica.service;


import clinica.proyectoclinicaodontologica.exceptions.ResourceNotFoundException;
import clinica.proyectoclinicaodontologica.model.Odontologo;
import clinica.proyectoclinicaodontologica.repository.OdontologoRepository;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class OdontologoService {

    //atributo
    private OdontologoRepository odontologoRepository;

    //LOGGER
    private static final Logger logger = Logger.getLogger(OdontologoService.class);


    //constructor

    public OdontologoService(OdontologoRepository odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
    }

    //Operaciones
    public Odontologo guardar(Odontologo o) {
        return odontologoRepository.save(o);
    }

    public Odontologo buscar(Integer id) {
        Odontologo odontologo = null;
        Optional<Odontologo> optionalOdontologo = odontologoRepository.findById(id);
        if (optionalOdontologo.isPresent()) {
            odontologo = optionalOdontologo.get();
        }
        logger.info("Odontologo encontrado: " + odontologo);
        return odontologo;
    }

    public List<Odontologo> buscarTodos() {
        return odontologoRepository.findAll();
    }

    public void eliminar(Integer id) throws ResourceNotFoundException {
        //odontologoRepository.deleteById(id);
        if(this.buscar(id) == null){
            logger.error("Odontologo no existe con id " + id);
            throw new ResourceNotFoundException( "Odontologo no existe con id " + id );

        } else
        {
            logger.info("Odontologo eliminado: " + id);
            odontologoRepository.deleteById(id);
        }

    }

    public Odontologo actualizar(Odontologo o) {
        return odontologoRepository.save(o);
    }
}


