package clinica.proyectoclinicaodontologica.repository;

import clinica.proyectoclinicaodontologica.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional // para que no haya errores de concurrencia
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    public  Optional<Usuario> findByEmail(String email);
}
