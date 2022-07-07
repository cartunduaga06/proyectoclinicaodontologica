package clinica.proyectoclinicaodontologica.service;

import clinica.proyectoclinicaodontologica.model.Usuario;
import clinica.proyectoclinicaodontologica.model.UsuarioRol;
import clinica.proyectoclinicaodontologica.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.boot.ApplicationRunner;

@Component
public class DataLoader implements ApplicationRunner {

    private UsuarioRepository usuarioRepository;

    public DataLoader(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
    @Override
    public void run(ApplicationArguments args) throws Exception {

        //Encriptar las contraseñas
        BCryptPasswordEncoder passwordEncoder1= new BCryptPasswordEncoder();
        String password1 = passwordEncoder1.encode("123");
        BCryptPasswordEncoder passwordEncoder2= new BCryptPasswordEncoder();
        String password2 = passwordEncoder2.encode("password2");
        //Crear 2 instancias de usuario
        Usuario usuario1 = new Usuario("Admin", "admin", "admin@digital.com",password1, "admin",UsuarioRol.ADMIN);
        Usuario usuario2 = new Usuario("User", "user","user@digital.com", password2,"user",  UsuarioRol.USER);
        this.usuarioRepository.save(usuario1);
        this.usuarioRepository.save(usuario2);

    }

}



