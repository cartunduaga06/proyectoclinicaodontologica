package clinica.proyectoclinicaodontologica.service;



import clinica.proyectoclinicaodontologica.repository.Idao;
import clinica.proyectoclinicaodontologica.model.Domicilio;

import java.util.List;

public class DomicilioService {
    private Idao<Domicilio> domicilioDao;

    public DomicilioService(Idao<Domicilio> domicilioDao) {
        this.domicilioDao = domicilioDao;
    }
    public Domicilio guardar(Domicilio d){
        domicilioDao.guardar(d);
        return d;
    }
    public Domicilio buscar(Integer id){
        return domicilioDao.buscar(id);
    }
    public List<Domicilio> buscarTodos(){
        return domicilioDao.buscarTodos();
    }
    public void eliminar(Integer id){
        domicilioDao.eliminar(id);
    }

}
