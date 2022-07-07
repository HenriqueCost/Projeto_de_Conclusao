package com.henriquecosta.criacao_de_api.Controllers;

import com.henriquecosta.criacao_de_api.ClientFeign.MunicipalityFeign;
import com.henriquecosta.criacao_de_api.DTO.MunicipalityDTO;
import com.henriquecosta.criacao_de_api.DTO.MunicipalityListDTO;
import com.henriquecosta.criacao_de_api.entities.Conversor;
import com.henriquecosta.criacao_de_api.entities.Municipality;
import com.henriquecosta.criacao_de_api.servicies.MunicipalityService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@AllArgsConstructor
@RestController
@RequestMapping(value = "/dados")
public class MunicipalityController {

    @Autowired
    private MunicipalityService service;

    private MunicipalityFeign feign;

    //Pega os Dados contidos em MunicipalityDTO e passa os para Municipality
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public MunicipalityListDTO pegarTodosDados(){
        MunicipalityListDTO listDto = feign.pegarTodosDados();

        for(MunicipalityDTO dto : listDto.getValue()){
            Municipality municipality = Conversor.getList(dto);
            service.pegarTodosDados(municipality);
        }
        return listDto;
    }

    @GetMapping(value = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public Municipality pegarDadosPorId(@PathVariable Long id){
        Municipality PegarId = service.pegarDadosPorId(id);
        return PegarId;
    }

    @GetMapping(value ="/pagina")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Page<Municipality>> pegarPorPagina(Pageable pageable){
        Page<Municipality> pagina =  service.encontrarPorPagina(pageable);
        return ResponseEntity.ok(pagina);
    }

    @GetMapping(value = "/ano")
    @ResponseStatus(HttpStatus.OK)
    public Page<Municipality> encontrarPorAno(@RequestParam String anoEmissao, Pageable pageable){
        Municipality ano = (Municipality) service.encontrarPorAno(anoEmissao, pageable);
        return (Page<Municipality>) ano;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Municipality criarDados(@RequestBody Municipality municipality){
        Municipality dadoNovo = service.criarDados(municipality);
        return dadoNovo;
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Municipality atualizarDados(@RequestBody Municipality municipality){
        Municipality dadoAtualizado = service.atualizarDados(municipality);
        return dadoAtualizado;
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> deletarDados(@PathVariable Long id){
        service.deletarDados(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //Método para o teste de PostMapping na classe ControllerTest
    public Municipality criarDados() {
        return criarDados(Municipality.builder().build());
    }

    //Método para o teste de PutMapping na classe ControllerTest
    public Municipality atualizarDados() {
        return atualizarDados(Municipality.builder().build());
    }
}
