package com.henriquecosta.criacao_de_api.DTO;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MunicipalityListDTO {
    //Obtendo dados da api externa pelo client feign e armazenando-os no MunicipalityDTO
    List<MunicipalityDTO> value;
}
