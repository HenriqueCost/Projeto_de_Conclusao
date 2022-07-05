package com.henriquecosta.criacao_de_api.repositories;

import com.henriquecosta.criacao_de_api.entities.Municipality;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MunicipalityRepository extends JpaRepository<Municipality, Long> {
    @Query("SELECT obj FROM Municipality obj")
    Page<Municipality> procurarPorAno(String anoEmissao, Pageable pageable);
}
