package com.henriquecosta.criacao_de_api.repositories;

import com.henriquecosta.criacao_de_api.entities.Municipality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MunicipalityRepository extends JpaRepository<Municipality, Long> {
}
