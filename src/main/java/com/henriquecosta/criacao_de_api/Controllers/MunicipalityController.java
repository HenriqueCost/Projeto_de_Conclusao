package com.henriquecosta.criacao_de_api.Controllers;

import com.henriquecosta.criacao_de_api.ClientFeign.MunicipalityFeign;
import com.henriquecosta.criacao_de_api.DTO.MunicipalityDTO;
import com.henriquecosta.criacao_de_api.DTO.MunicipalityListDTO;
import com.henriquecosta.criacao_de_api.entities.Conversor;
import com.henriquecosta.criacao_de_api.entities.Municipality;
import com.henriquecosta.criacao_de_api.servicies.MunicipalityService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@AllArgsConstructor
@RestController
@RequestMapping(value = "/dados")
public class MunicipalityController {

    @Autowired
    private MunicipalityService service;

    private MunicipalityFeign feign;

    //Pega os Dados contidos em MunicipalityDTO e os passa para Municipality
    @GetMapping
    public MunicipalityListDTO pegarTodosDados(){
        MunicipalityListDTO listDto = feign.pegarTodosDados();

        for(MunicipalityDTO dto : listDto.getValue()){
            Municipality municipality = Conversor.getList(dto);
            service.pegarTodosDados(municipality);
        }
        return listDto;
    }

    @GetMapping(value = "{id}")
    public Municipality pegarDadosPorId(@PathVariable Long id){
        Municipality PegarId = service.pegarDadosPorId(id);
        return PegarId;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Municipality criarDados(@RequestBody Municipality municipality){
        Municipality dadoNovo = service.criarDados(municipality);
        return dadoNovo;
    }

    @PutMapping
    public Municipality atualizarDados(@RequestBody Municipality municipality){
        Municipality dadoAtualizado = service.atualizarDados(municipality);
        return dadoAtualizado;
    }

    @DeleteMapping(value = "{id}")
    public Municipality deletarDados(@PathVariable Long id){
        Municipality dadoDeletado = service.deletarDados(id);
        return dadoDeletado;
    }

}
