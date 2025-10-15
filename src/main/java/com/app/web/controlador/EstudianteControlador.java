package com.app.web.controlador;

import com.app.web.entidad.Estudiante;
import com.app.web.servicio.EstudianteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EstudianteControlador {

    @Autowired
    private EstudianteServicio servicio;

    @GetMapping({"/estudiantes","/"})
    public ResponseEntity<List<Estudiante>> listarEstudiantes(){
        return new ResponseEntity<>(servicio.listarTodosLosEstudiantes(),HttpStatus.OK);//nos retorna el archivo estudiantes
    }

    @PostMapping("/estudiantes")
    public ResponseEntity<Estudiante> guardarEstudiante(@RequestBody Estudiante estudiante){ /*que son los parametros del metodo*/
        Estudiante nuevoEstudiante = servicio.guardarEstudiante(estudiante);
        //estudiante.setId(null);
        return  new ResponseEntity<>(nuevoEstudiante, HttpStatus.CREATED);  /*que esta pasando en el return*/

    }

    @PostMapping("/estudiante/{id}")
    public  ResponseEntity<Estudiante> actualizarEstudiante(@PathVariable Long id, @RequestBody Estudiante estudiante){
        Estudiante estudianteExistente = servicio.obtenerEstudiantePorId(id);
        //estudianteExistente.setId(id);
        estudianteExistente.setNombre(estudiante.getNombre());
        estudianteExistente.setApellido(estudiante.getApellido());
        estudianteExistente.setEmail(estudiante.getEmail());

        Estudiante estudianteActualizado = servicio.actualizarEstudiante(estudianteExistente);
        return new ResponseEntity<>(estudianteActualizado,HttpStatus.OK);
    }

    @GetMapping("/estudiante/{id}")
    public ResponseEntity<Void> eliminarEstudiante(@PathVariable Long id){
        servicio.eliminarEstudiante(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
