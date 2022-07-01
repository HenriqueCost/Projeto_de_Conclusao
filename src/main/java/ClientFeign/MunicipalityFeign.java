package ClientFeign;

import com.henriquecosta.criacao_de_api.DTO.MunicipalityListDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "sevicos", url = "https://olinda.bcb.gov.br/olinda/servico/SICOR/versao/v2/odata/ComercRegiaoUFProduto")
public interface MunicipalityFeign {

    @RequestMapping(method = RequestMethod.GET, value = "")
    MunicipalityListDTO getAllPosts();
}
