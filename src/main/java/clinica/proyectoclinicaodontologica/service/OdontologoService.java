package clinica.proyectoclinicaodontologica.service;


import clinica.proyectoclinicaodontologica.model.Odontologo;
import clinica.proyectoclinicaodontologica.repository.OdontologoRepository;
import org.springframework.stereotype.Service;


import java.util.List;

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
        return odontologoRepository.findById(id).get();
    }

    public List<Odontologo> buscarTodos() {
        return odontologoRepository.findAll();
    }

    public void eliminar(Integer id) {
        odontologoRepository.deleteById(id);
    }

    public Odontologo actualizar(Odontologo o) {
        return odontologoRepository.save(o);
    }
}


