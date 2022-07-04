package com.henriquecosta.criacao_de_api.Controllers;

import com.henriquecosta.criacao_de_api.ClientFeign.MunicipalityFeign;
import com.henriquecosta.criacao_de_api.DTO.MunicipalityDTO;
import com.henriquecosta.criacao_de_api.DTO.MunicipalityListDTO;
import com.henriquecosta.criacao_de_api.entities.Conversor;
import com.henriquecosta.criacao_de_api.entities.Municipality;
import com.henriquecosta.criacao_de_api.servicies.MunicipalityService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
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

    private ModelMapper modelMapper;

    private Conversor conversor;

    @GetMapping
    public MunicipalityListDTO pegarTodosDados(){
        MunicipalityListDTO listDto = feign.pegarTodosDados();

        for(MunicipalityDTO dto : listDto.getValue()){
            Municipality municipality = Conversor.getList(dto);
            service.pegarTodosDados(municipality);
        }
        return listDto;
    }

   /*

    @GetMapping
    public List<Municipality> pegarDados(){
        return inteface.pegarTodosDados().stream().map(MunicipalityDTO -> modelMapper
                        .map(MunicipalityDTO, Municipality.class))
                .collect(Collectors.toList());
    }

   // @GetMapping("/{id}")
    //public ResponseEntity<Municipality> pegarDadoPorId(@PathVariable(name = "id") Long id){
      //  Municipality municipality = inteface.pegarId(id);

        //Municipality municipalityResponse = modelMapper.map(municipality, Municipality.class);
        //return ResponseEntity.ok().body(municipalityResponse);
   // }


    /*@Autowired
    private MunicipalityFeign municipalityFeign;


    /*@Autowired
    private ModelMapper modelMapper;*/

   /* @GetMapping
    public MunicipalityListDTO pegarDados(){
        MunicipalityListDTO municipalityListDTO = municipalityFeign.pegarTodosDados();
        for(MunicipalityDTO municipalityDTO : municipalityListDTO.getValue()){
            Municipality municipality =
    }

    /*@GetMapping
    public ResponseEntity<List<Municipality>> acharTudo() {
        List<Municipality> result = repository.findAll();
        return ResponseEntity.ok(result);
    }

   /* @GetMapping(value = "/{id}")
    public MunicipalityListDTO acharPorId(@PathVariable Long id) {
        MunicipalityListDTO result = repository.findById(id).get();
        return result;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MunicipalityListDTO salvar(@RequestBody MunicipalityListDTO municipality) {
        MunicipalityListDTO result = repository.save(municipality);
        return result;
    }

    @PutMapping
    public MunicipalityListDTO atualizarPorId(@RequestBody MunicipalityListDTO municipality){
        MunicipalityListDTO result = repository.save(municipality);
        return result;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public MunicipalityListDTO removerPorId(@PathVariable Long id){
        MunicipalityListDTO result = repository.findById(id).get();
        repository.deleteById(id);
        return result;
    }

    /*@GetMapping
    public ResponseEntity<Page<Municipality>> acharTudo(Pageable pageable){
        Page<Municipality> result = repository.findAll(pageable);
        return ResponseEntity.ok(result);
    }*/

}
