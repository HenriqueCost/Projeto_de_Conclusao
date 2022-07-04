package com.henriquecosta.criacao_de_api.Controllers;

import com.henriquecosta.criacao_de_api.DTO.MunicipalityListDTO;
import com.henriquecosta.criacao_de_api.entities.Conversor;
import com.henriquecosta.criacao_de_api.entities.Municipality;
import com.henriquecosta.criacao_de_api.repositories.MunicipalityRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping(value = "/dados")
public class MunicipalityController {

    @Autowired
    private MunicipalityRepository repository;

    private Conversor conversor;

    @GetMapping
    public List<MunicipalityListDTO> list(){
        conversor.get();
        return repository.findAll();
    }

    /* @Autowired
    private MunicipalityRepository repository;


    @Autowired
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
