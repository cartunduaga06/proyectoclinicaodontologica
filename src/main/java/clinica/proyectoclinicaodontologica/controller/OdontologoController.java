package clinica.proyectoclinicaodontologica.controller;


import clinica.proyectoclinicaodontologica.repository.impl.OdontologoDaoH2;
import clinica.proyectoclinicaodontologica.model.Odontologo;
import clinica.proyectoclinicaodontologica.service.OdontologoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping( path = "/odontologos")
public class OdontologoController {




    private OdontologoService odontologoService= new OdontologoService(new OdontologoDaoH2());



    @GetMapping(path = "/buscartodos")
    public List<Odontologo> buscarTodos() {
        return odontologoService.buscarTodos();
    }


    @GetMapping(path = "/buscarPorId/{id}")
    public Odontologo buscarPorId(@PathVariable int id) {
        return odontologoService.buscarPorId(id);
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



// voy a hacer otro controler distinto para guardar un odontologo y buscar todos los odontologos
/*
    @PostMapping (path = "/guardar")

    public Odontologo guardarOdontologo(@RequestBody Odontologo odontologo) {
        return odontologoService.guardar(odontologo);

    }

    @GetMapping (path = "/buscartodos")
    @ResponseBody
    public List<Odontologo> buscarTodos() {
        return odontologoService.buscarTodos();
    }

    @GetMapping (path = "/buscarporid/{id}")
    @ResponseBody
    public Odontologo buscarPorId(@PathVariable int id) {
        return odontologoService.buscarPorId(id);
    }
*/

}
