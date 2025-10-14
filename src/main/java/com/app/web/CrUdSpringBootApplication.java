package com.app.web;

import com.app.web.entidad.Estudiante;
import com.app.web.repositorio.EstudianteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrUdSpringBootApplication implements CommandLineRunner {

	public static void main(String[] args) {
        SpringApplication.run(CrUdSpringBootApplication.class, args);
	}

    @Autowired
    private EstudianteRepositorio repositorio;

    @Override
    public void run(String... args) throws Exception{
      /*  Estudiante estudiante1 = new Estudiante("Victor","Reyes", "victor24@gmail.com");
        repositorio.save(estudiante1);

        Estudiante estudiante2 = new Estudiante("Hugo","Fuentes", "hugo25@gmail.com");
        repositorio.save(estudiante2);
        */
    }

}

