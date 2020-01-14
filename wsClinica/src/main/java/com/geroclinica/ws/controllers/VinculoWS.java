package com.geroclinica.ws.controllers;

import com.geroclinica.ws.dto.VinculoColaboradorPacienteDTO;
import com.geroclinica.ws.models.VinculoColaboradorPaciente;
import com.geroclinica.ws.repository.PessoaRepository;
import com.geroclinica.ws.repository.VinculoColaboradorPacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(
        path = "/vinculo",
        produces = {MediaType.APPLICATION_JSON_VALUE})
public class VinculoWS {

    @Autowired
    VinculoColaboradorPacienteRepository vinculoRepository;

    @Autowired
    PessoaRepository pessoaRepository;

   @GetMapping
    public ResponseEntity findAllVinculo() {
       Iterable<VinculoColaboradorPaciente> vinculo = vinculoRepository.findAll();
       return ResponseEntity.ok(getVinculoColaboradorPacienteDTO(vinculo));
    }

    @GetMapping(value = "/id")
    public ResponseEntity findById(@RequestParam(value = "id") Long id){
        Optional<VinculoColaboradorPaciente> vinculo = vinculoRepository.findById(id);
        return ResponseEntity.ok(new VinculoColaboradorPacienteDTO(vinculo.get().getId(), vinculo.get().getPaciente(), vinculo.get().getColaborador()));
    }

    @GetMapping(value = "/idColaborador")
    public ResponseEntity findByIdColaborador(@RequestParam(value = "idColaborador") Long idColaborador){
        Iterable<VinculoColaboradorPaciente> vinculo = vinculoRepository.findByIdColaborador(idColaborador);
        return ResponseEntity.ok(getVinculoColaboradorPacienteDTO(vinculo));
    }

    private Iterable<VinculoColaboradorPacienteDTO> getVinculoColaboradorPacienteDTO(Iterable<VinculoColaboradorPaciente> vinculo) {
        List<VinculoColaboradorPacienteDTO> allVinculo = new ArrayList<>();
        for (VinculoColaboradorPaciente v: vinculo) {
            allVinculo.add(new VinculoColaboradorPacienteDTO(v.getId(), v.getPaciente(), v.getColaborador()));
        }
        return allVinculo;
    }
}
