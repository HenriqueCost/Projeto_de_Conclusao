package com.henriquecosta.criacao_de_api.DTO;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class MunicipalityListDTO {
    List<MunicipalityDTO> value;
}
