package clinica.proyectoclinicaodontologica.service;


import clinica.proyectoclinicaodontologica.exceptions.ResourceNotFoundException;
import clinica.proyectoclinicaodontologica.model.Odontologo;
import clinica.proyectoclinicaodontologica.repository.OdontologoRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class OdontologoService {

    //atributo
    private OdontologoRepository odontologoRepository;


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
        return odontologo;
    }

    public List<Odontologo> buscarTodos() {
        return odontologoRepository.findAll();
    }

    public void eliminar(Integer id) throws ResourceNotFoundException {
        //odontologoRepository.deleteById(id);
        if(this.buscar(id) == null){
            throw new ResourceNotFoundException("Odontologo no existe con id " + id);
        } else
        {
            odontologoRepository.deleteById(id);
        }

    }

    public Odontologo actualizar(Odontologo o) {
        return odontologoRepository.save(o);
    }
}


