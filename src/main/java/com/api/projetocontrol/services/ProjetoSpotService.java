package com.api.projetocontrol.services;

import com.api.projetocontrol.models.ProjetoSpotModel;
import com.api.projetocontrol.models.UUID;
import com.api.projetocontrol.repositories.ProjetoSpotRepository;
import org.apache.el.stream.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProjetoSpotService {

    final ProjetoSpotRepository projetoSpotRepository;

    public ProjetoSpotService(ProjetoSpotRepository projetoSpotRepository) {
        this.projetoSpotRepository = projetoSpotRepository;
    }

    @Transactional
    public ProjetoSpotModel save(ProjetoSpotModel projetoSpotModel) {
        return projetoSpotRepository.save(projetoSpotModel);
    }

    public boolean existsByemail(String licensePlateCar) {
        return projetoSpotRepository.existsByemail(licensePlateCar);
    }

    public boolean existsByProjetoSpotnome(String projetoSpotnome) {
        return projetoSpotRepository.existsByProjetoSpotNumber(projetoSpotnome);
    }

    public boolean existsByPontodeRetiradaAndassunto(String PontodeRetirada, String assunto) {
        return projetoSpotRepository.existsByPontodeRetiradaAndassunto(PontodeRetirada, assunto);
    }

    public Page<ProjetoSpotModel> findAll(Pageable pageable) {
        return projetoSpotRepository.findAll(pageable);
    }

    public Optional<ProjetoSpotModel> findById(UUID id) {
        return projetoSpotRepository.findById(id);
    }

    @Transactional
    public void delete(ProjetoSpotModel projetoSpotModel) {
        projetoSpotRepository.delete(projetoSpotModel);
    }
}
