package com.henriquecosta.criacao_de_api.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@AllArgsConstructor
@RestController
@RequestMapping(value = "/dados")
public class MunicipalityController {

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
            Municipality municipality = new Municipality();
            municipality.setNomeProduto(municipalityDTO.getNomeProduto());
            municipality.setNomeRegiao(municipalityDTO.getNomeRegiao());
            municipality.setNomeUF(municipalityDTO.getNomeUF());
            municipality.setMesEmissao(municipalityDTO.getMesEmissao());
            municipality.setAnoEmissao(municipalityDTO.getAnoEmissao());
            municipality.setCdPrograma(municipalityDTO.getCdPrograma());
            municipality.setCdSubPrograma(municipalityDTO.getCdSubPrograma());
            municipality.setCdFonteRecurso(municipalityDTO.getCdFonteRecurso());
            municipality.setCdTipoSeguro(municipalityDTO.getCdTipoSeguro());
            municipality.setQtdCusteio(municipalityDTO.getQtdCusteio());
            municipality.setVlCusteio(municipalityDTO.getVlCusteio());
            municipality.setAtividade(municipalityDTO.getAtividade());
            municipality.setCdModalidade(municipalityDTO.getCdModalidade());
            municipality.setAreaCusteio(municipalityDTO.getAreaCusteio());

        }
        return pegarDados();
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
