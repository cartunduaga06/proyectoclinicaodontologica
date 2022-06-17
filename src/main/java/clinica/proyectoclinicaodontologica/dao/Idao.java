package clinica.proyectoclinicaodontologica.dao;

import java.util.List;

public interface Idao<T> {

    public T guardar(T t);

    public List<T> buscarTodos();

    T buscarPorId(int id);
}
