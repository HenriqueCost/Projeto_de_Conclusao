package com.henriquecosta.criacao_de_api.repositories;

import com.henriquecosta.criacao_de_api.entities.Municipality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Repository
public interface MunicipalityRepository extends JpaRepository<Municipality, Long> {
    @Query("SELECT obj.anoEmissao as anoEmissao, obj.nomeProduto as nomeProduto, obj.nomeUF as nomeUF, " +
            "SUM(obj.vlCusteio) as vlCusteio FROM Municipality obj WHERE obj.anoEmissao = :anoEmissao " +
            "AND obj.nomeProduto IN ('SOJA', 'FEIJÃO', 'TRIGO', 'MILHO', 'CANA DE AÇUCAR') GROUP BY " +
            "obj.anoEmissao, obj.nomeProduto, obj.nomeUF")
    List<Municipality> procurarPorAno(@RequestBody String anoEmissao);
}
