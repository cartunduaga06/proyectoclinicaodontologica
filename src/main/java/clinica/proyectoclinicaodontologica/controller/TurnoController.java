package clinica.proyectoclinicaodontologica.controller;



import clinica.proyectoclinicaodontologica.exceptions.ResourceNotFoundException;
import clinica.proyectoclinicaodontologica.model.Turno;
import clinica.proyectoclinicaodontologica.service.OdontologoService;
import clinica.proyectoclinicaodontologica.service.PacienteService;
import clinica.proyectoclinicaodontologica.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    @Autowired
private TurnoService turnoService;
    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private OdontologoService odontologoService;



@GetMapping (path = "/buscarTodos")
public List<Turno> buscarTodos() {
    return turnoService.buscarTodos();
}




    @PostMapping(path = "/guardar")
    public ResponseEntity<Turno> registrarTurno(@RequestBody Turno turno) throws HttpClientErrorException {
        ResponseEntity<Turno> response;
        if (pacienteService.buscar(turno.getPaciente().getId()) != null && odontologoService.buscar  (turno.getOdontologo().getId()) != null)
            response = ResponseEntity.ok(turnoService.guardar(turno));

        else
            response = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        return response;
    }


    @PutMapping(path = "/actualizar")
    public ResponseEntity<Turno> actualizarTurno(@RequestBody Turno turno) {
        ResponseEntity<Turno> response;
        response = ResponseEntity.ok(turnoService.actualizar(turno));
        return response;
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id) throws ResourceNotFoundException {
        ResponseEntity<String> response = null;
        turnoService.eliminar(id);
        response = ResponseEntity.status(HttpStatus.OK).body("Eliminado");
        return response;
    }



}
