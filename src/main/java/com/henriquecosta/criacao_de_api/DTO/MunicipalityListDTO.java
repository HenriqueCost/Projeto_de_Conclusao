package com.henriquecosta.criacao_de_api.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MunicipalityListDTO {
    //Obtendo dados da api externa pelo client feign e armazenando-os no MunicipalityDTO
    List<MunicipalityDTO> value;
}
