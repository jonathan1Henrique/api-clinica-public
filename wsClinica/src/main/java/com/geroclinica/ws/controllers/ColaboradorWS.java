package com.geroclinica.ws.controllers;

import com.geroclinica.ws.dto.ColaboradorDTO;
import com.geroclinica.ws.models.Colaborador;
import com.geroclinica.ws.models.Pessoa;
import com.geroclinica.ws.repository.PessoaRepository;
import com.geroclinica.ws.services.ColaboradorService;
import com.geroclinica.ws.statics.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(
        path = "/colaboradores",
        produces = {MediaType.APPLICATION_JSON_VALUE})
public class ColaboradorWS {

    @Autowired
    ColaboradorService service;

    @Autowired
    PessoaRepository pessoaRepository;

    @PostMapping
    public ResponseEntity adicionar(@RequestBody ColaboradorDTO colaborador){
        try {
            return ResponseEntity.ok(service.save(colaborador));
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

   @GetMapping
    public ResponseEntity findAllColaborador() {
       try {
           return ResponseEntity.ok(service.findAllColaborador());
       }catch (Exception e) {
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
            return ResponseEntity.ok(service.findByCpf(cpf));
        } catch (Exception e) {
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
