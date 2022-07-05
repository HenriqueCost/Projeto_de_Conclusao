package com.henriquecosta.criacao_de_api.Controllers;

import com.henriquecosta.criacao_de_api.ClientFeign.MunicipalityFeign;
import com.henriquecosta.criacao_de_api.DTO.MunicipalityDTO;
import com.henriquecosta.criacao_de_api.DTO.MunicipalityListDTO;
import com.henriquecosta.criacao_de_api.entities.Conversor;
import com.henriquecosta.criacao_de_api.entities.Municipality;
import com.henriquecosta.criacao_de_api.servicies.MunicipalityService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@AllArgsConstructor
@RestController
@RequestMapping(value = "/dados")
public class MunicipalityController {

    @Autowired
    private MunicipalityService service;

    private MunicipalityFeign feign;

    @GetMapping
    public MunicipalityListDTO pegarTodosDados(){
        MunicipalityListDTO listDto = feign.pegarTodosDados();

        for(MunicipalityDTO dto : listDto.getValue()){
            Municipality municipality = Conversor.getList(dto);
            service.pegarTodosDados(municipality);
        }
        return listDto;
    }

}
