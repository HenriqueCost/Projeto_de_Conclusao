package repositories;

import com.henriquecosta.criacao_de_api.entities.Municipality;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MunicipalityRepository extends JpaRepository<Municipality, Long> {
}
