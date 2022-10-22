package br.com.futurodev.semana3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.util.TimeZone;

@SpringBootApplication
public class Semana3Application {

    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        SpringApplication.run(Semana3Application.class, args);
    }

}
