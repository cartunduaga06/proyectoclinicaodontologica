package clinica.proyectoclinicaodontologica.service;



import clinica.proyectoclinicaodontologica.repository.DomicilioRepository;
import clinica.proyectoclinicaodontologica.model.Domicilio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DomicilioService {


    @Autowired
    private DomicilioRepository domicilioRepository;



    public DomicilioService(DomicilioRepository domicilioRepository) {
        this.domicilioRepository = domicilioRepository;
    }
    public Domicilio guardar(Domicilio d){

        return domicilioRepository.save(d);
    }
    public Domicilio buscar(Integer id){
        return domicilioRepository.findById(id).get();
    }
    public List<Domicilio> buscarTodos(){
        return domicilioRepository.findAll();
    }
    public void eliminar(Integer id){
        domicilioRepository.deleteById(id);
    }

}
