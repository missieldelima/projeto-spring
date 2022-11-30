package com.api.projetocontrol.repositories;

import com.api.projetocontrol.models.ProjetoSpotModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProjetoSpotRepository extends JpaRepository<ProjetoSpotModel, UUID> {

    boolean existsByemail(String email);
    boolean existsByProjetoSpotNumber(String projetoSpotnome);
    boolean existsByPontodeRetiradaAndassunto(String PontodeRetirada, String Assunto);
}
