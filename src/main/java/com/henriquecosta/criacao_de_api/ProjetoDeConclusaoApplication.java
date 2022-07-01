package com.henriquecosta.criacao_de_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ProjetoDeConclusaoApplication {

    public static void main(String[] args) {

        SpringApplication.run(ProjetoDeConclusaoApplication.class, args);
    }

}
