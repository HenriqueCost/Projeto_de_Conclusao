package com.henriquecosta.criacao_de_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableFeignClients
@EnableJpaRepositories
@SpringBootApplication
@EntityScan(basePackages = {"com.henriquecosta.criacao_de_api.entities"})
public class ProjetoDeConclusaoApplication {

    public static void main(String[] args) {

        SpringApplication.run(ProjetoDeConclusaoApplication.class, args);
    }

}
