package com.henriquecosta.criacao_de_api.Mapper;

public class TransicaoDadosDTOparaServicies {

   /* @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private MunicipalityFeign municipalityFeign;

    //Convertendo os dados da API de JSON para Java e passando-os para a classe Municipality
    @Autowired
    private Municipality convertendoDados(MunicipalityDTO municipalityDTO) {
        return modelMapper.map(municipalityDTO, Municipality.class);
    }

    @GetMapping
    public MunicipalityListDTO pegarDados() {
        MunicipalityListDTO municipalityListDTO = municipalityFeign.pegarTodosDados();
        for (MunicipalityDTO municipalityDTO : municipalityListDTO.getValue()) {
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

    }*/
}
