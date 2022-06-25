package clinica.proyectoclinicaodontologica.controller;


import clinica.proyectoclinicaodontologica.model.Turno;
import clinica.proyectoclinicaodontologica.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    @Autowired
private TurnoService turnoService;


@GetMapping (path = "/buscarTodos")
public List<Turno> buscarTodos() {
    return turnoService.buscarTodos();
}


@PostMapping("/guardar")
public ResponseEntity<Turno> guardarTurno(Turno turno) {
    return ResponseEntity.ok(turnoService.guardar(turno));
}

}
