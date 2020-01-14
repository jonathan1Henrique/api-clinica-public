package com.geroclinica.ws.services;

import com.geroclinica.ws.dto.PacienteDTO;
import com.geroclinica.ws.models.Paciente;
import com.geroclinica.ws.models.Pessoa;
import com.geroclinica.ws.repository.PacienteRepository;
import com.geroclinica.ws.repository.PessoaRepository;
import com.geroclinica.ws.statics.Message;
import com.geroclinica.ws.validacao.UtilsValidacaoPaciente;
import com.geroclinica.ws.validacao.ValidaCpf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    PacienteRepository pr;

    @Autowired
    PessoaRepository pessoaRepository;

    public List<PacienteDTO> findAllPaciente() throws Exception{
        List<PacienteDTO> allPacientes = new ArrayList<>();
            Iterable<Paciente> pacientes = pr.findAll();
            if(pacientes == null){
                throw new Exception(Message.IS_VAZIO);
            }
            for (Paciente p : pacientes) {
                Optional<Pessoa> pessoa = pessoaRepository.findById(p.getPessoa().getId());
                PacienteDTO pacienteDTO = new PacienteDTO(p, pessoa.get());
                allPacientes.add(pacienteDTO);
            }
            return allPacientes;
    }

    public PacienteDTO findById(Long id) throws Exception{
        if(id == null || id == 0){
            throw new Exception(Message.ID_OBRIGATORIO);
        }

        Optional<Paciente> paciente = pr.findById(id);

        if(!paciente.isPresent()){
            throw new Exception(Message.PACIENTE_NAO_ENCONTRADO_PACIENTE);
        }
        return new PacienteDTO(paciente.get(), pessoaRepository.getOne(paciente.get().getPessoa().getId()));
    }

    public Paciente save(PacienteDTO paciente) throws Exception{
        PacienteDTO dto = new PacienteDTO();
        if(UtilsValidacaoPaciente.validaCamposPacienteDTO(paciente)) {
            return pr.save(dto.montaPaciente(paciente));
        }
            throw new Exception();
    }

    public PacienteDTO findByCPF(String cpf) throws Exception{
        if(cpf.isEmpty()){
            throw new Exception(Message.CPF_NAO_PREENCHIDO);
        }
        if(!ValidaCpf.isCPF(cpf)){
            throw new Exception(Message.CPF_NAO_VALIDO);
        }
        Pessoa pessoa = pessoaRepository.findByCPF(cpf);
        PacienteDTO dto = new PacienteDTO();
        for (Paciente paciente: pessoa.getPaciente()){
            dto = new PacienteDTO(paciente, pessoa);
        }
        return dto;
    }

    public PacienteDTO findByNome(String nome) throws Exception{
        if(nome.isEmpty()){
            throw new Exception(Message.NOME_NAO_PREENCHIDO);
        }
        Pessoa pessoa = pessoaRepository.findByNome(nome);
        if(pessoa == null){
            throw new Exception(Message.NOME_PACIENTE_NAO_ENCONTRADO);
        }
        PacienteDTO dto = new PacienteDTO();
        for (Paciente paciente: pessoa.getPaciente()){
            dto = new PacienteDTO(paciente, pessoa);
        }
        return dto;
    }
}
