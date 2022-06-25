package clinica.proyectoclinicaodontologica.controller;


import clinica.proyectoclinicaodontologica.model.Odontologo;
import clinica.proyectoclinicaodontologica.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping( path = "/odontologos")
public class OdontologoController {



    @Autowired
    private OdontologoService odontologoService;


    @GetMapping(path = "/buscartodos")
    public List<Odontologo> buscarTodos() {
        return odontologoService.buscarTodos();
    }


    @GetMapping(path = "/buscarPorId/{id}")
    public Odontologo buscarPorId(@PathVariable int id) {
        return odontologoService.buscar(id);
    }




    @PostMapping(path = "/guardar")
    public Odontologo guardarOdontologo(@RequestBody Odontologo odontologo) {
        return odontologoService.guardar(odontologo);
    }

    @PutMapping(path = "/actualizar")
    public Odontologo actualizarOdontologo(@RequestBody Odontologo odontologo) {
        return odontologoService.actualizar(odontologo);
    }


    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminar(@PathVariable int id){
        ResponseEntity<String> response;
        odontologoService.eliminar(id);

        response = ResponseEntity.status(HttpStatus.OK).body("Eliminado");
        return response;
    }





}
