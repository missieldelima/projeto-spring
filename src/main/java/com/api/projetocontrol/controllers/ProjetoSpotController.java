package com.api.projetocontrol.controllers;

import com.api.projetocontrol.dtos.ProjetoSpotDto;
import com.api.projetocontrol.models.ProjetoSpotModel;
import com.api.projetocontrol.services.ProjetoSpotService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/projeto-spot")
public class ProjetoSpotController {

    final ProjetoSpotService projetoSpotService;

    public ProjetoSpotController(ProjetoSpotService projetoSpotService) {
        this.projetoSpotService = projetoSpotService;
    }

    @PostMapping
    public ResponseEntity<Object> saveProjetoSpot(@RequestBody @Valid ProjetoSpotDto projetoSpotDto){
        if(projetoSpotService.existsByemail(projetoSpotDto.getemail())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: email is already in use!");
        }
        if(projetoSpotService.existsByProjetoSpotnome(projetoSpotDto.getProjetoSpotnome())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Projeto Spot is already in use!");
        }
        if(projetoSpotService.existsByPontodeRetiradaAndassunto(projetoSpotDto.getPontodeRetirada(), projetoSpotDto.getassunto())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Projeto Spot already registered for this PontodeRetirada/assunto!");
        }
        var projetoSpotModel = new ProjetoSpotModel();
        BeanUtils.copyProperties(projetoSpotDto, projetoSpotModel);
        projetoSpotModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(projetoSpotService.save(projetoSpotModel));
    }

    @GetMapping
    public ResponseEntity<Page<ProjetoSpotModel>> getAllProjetoSpots(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(projetoSpotService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneProjetoSpot(@PathVariable(value = "id") UUID id){
        Optional<ProjetoSpotModel> projetoSpotModelOptional = projetoSpotService.findById(id);
        if (!projetoSpotModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Projeto Spot not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(projetoSpotModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProjetoSpot(@PathVariable(value = "id") UUID id){
        Optional<ProjetoSpotModel> projetoSpotModelOptional = projetoSpotService.findById(id);
        if (!projetoSpotModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Projeto Spot not found.");
        }
        projetoSpotService.delete(projetoSpotModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Projeto Spot deleted successfully.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateProjetoSpot(@PathVariable(value = "id") UUID id,
                                                    @RequestBody @Valid ProjetoSpotDto projetoSpotDto){
        Optional<ProjetoSpotModel> projetoSpotModelOptional = projetoSpotService.findById(id);
        if (!projetoSpotModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Projeto Spot not found.");
        }
        var projetoSpotModel = new ProjetoSpotModel();
        BeanUtils.copyProperties(projetoSpotDto, projetoSpotModel);
        projetoSpotModel.setId(projetoSpotModelOptional.get().getId());
        projetoSpotModel.setRegistrationDate(projetoSpotModelOptional.get().getRegistrationDate());
        return ResponseEntity.status(HttpStatus.OK).body(projetoSpotService.save(projetoSpotModel));
    }



}
