package clinica.proyectoclinicaodontologica.dao;

import java.util.List;

public interface Idao<T> {

    public T guardar(T t);

    public List<T> buscarTodos();

     T buscar(int id);

public void eliminar(int id);

    public T actualizar(T t);
}
