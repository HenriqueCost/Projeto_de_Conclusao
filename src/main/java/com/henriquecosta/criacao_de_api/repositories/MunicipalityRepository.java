package com.henriquecosta.criacao_de_api.repositories;

import com.henriquecosta.criacao_de_api.entities.Municipality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MunicipalityRepository extends JpaRepository<Municipality, Long> {
    /*@Query("SELECT obj.anoEmissao as ano, obj.nomeProduto as prod, obj.nomeUF as UF, SUM(obj.vlCusteio)" +
            " as custeio FROM Municipality obj WHERE obj.anoEmissao = :ano AND obj.nomeProduto " +
            "IN ('SOJA', 'FEIJÃO', 'TRIGO', 'MILHO', 'CANA DE AÇUCAR')" + "GROUP BY obj.anoEmissao, " +
            "obj.nomeProduto, obj.nomeUF")
    List<Municipality> procurarPorAno(String anoEmissao);*/
}
