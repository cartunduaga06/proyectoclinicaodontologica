package clinica.proyectoclinicaodontologica.controller;

import clinica.proyectoclinicaodontologica.model.Paciente;
import clinica.proyectoclinicaodontologica.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping(path = "/buscarTodos")
    public List<Paciente> buscarTodos() {
        return pacienteService.buscarTodos();
    }

    @GetMapping(path = "/buscarPorId/{id}")
    public Paciente buscarPorId(@PathVariable int id) {
        return pacienteService.buscar(id);
    }

    @PostMapping(path = "/guardar")
    public Paciente guardarPaciente(@RequestBody Paciente paciente) {
        return pacienteService.guardar(paciente);
    }

    @PutMapping(path = "/actualizar")
    public Paciente actualizarPaciente(@RequestBody Paciente paciente) {
        return pacienteService.actualizar(paciente);
    }

    @DeleteMapping(path = "/eliminar/{id}")
    public ResponseEntity<String> eliminar(@PathVariable int id) {
        ResponseEntity<String> response;
        pacienteService.eliminar(id);
        response = ResponseEntity.status(HttpStatus.OK).body("Eliminado");
        return response;
    }







}
