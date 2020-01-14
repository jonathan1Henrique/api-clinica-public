package com.geroclinica.ws.controllers;

import com.geroclinica.ws.dto.PacienteDTO;
import com.geroclinica.ws.repository.PessoaRepository;
import com.geroclinica.ws.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(
        path = "/pacientes",
        produces = {MediaType.APPLICATION_JSON_VALUE})
public class PacienteWS {

    @Autowired
    PacienteService service;

    @Autowired
    PessoaRepository pessoaRepository;

    @PostMapping
    public ResponseEntity adicionar(@RequestBody PacienteDTO paciente){
        try {
            return ResponseEntity.ok(service.save(paciente));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

   @GetMapping
    public ResponseEntity findAllPaciente(){
       try {
            return ResponseEntity.ok(service.findAllPaciente());
       } catch (Exception e) {
           e.printStackTrace();
           return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
       }
   }

    @GetMapping(value = "/id")
    public ResponseEntity findById(@RequestParam(value = "id") Long id){
        try {
            return ResponseEntity.ok(service.findById(id));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/cpf")
    public ResponseEntity findByCpf(@RequestParam(value = "cpf") String cpf){
        try {
            return ResponseEntity.ok(service.findByCPF(cpf));
        }catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/nome")
    public ResponseEntity findByNome(@RequestParam(value = "nome") String nome){
        try {
            return ResponseEntity.ok(service.findByNome(nome));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
