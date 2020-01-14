package com.geroclinica.ws.services;

import com.geroclinica.ws.dto.ColaboradorDTO;
import com.geroclinica.ws.models.Colaborador;
import com.geroclinica.ws.models.Pessoa;
import com.geroclinica.ws.repository.ColaboradorRepository;
import com.geroclinica.ws.repository.PessoaRepository;
import com.geroclinica.ws.statics.Message;
import com.geroclinica.ws.validacao.UtilsValidacaoColaborador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ColaboradorService {

    @Autowired
    ColaboradorRepository cr;

    @Autowired
    PessoaRepository pessoaRepository;

    public Colaborador save(ColaboradorDTO colaborador) throws Exception {
        ColaboradorDTO dto = new ColaboradorDTO();
        if(UtilsValidacaoColaborador.validaCamposColaboradorDTO(colaborador)) {
            return cr.save(dto.montaColaborador(colaborador));
        }
        throw new Exception();
    }

    public List<ColaboradorDTO> findAllColaborador() throws Exception{
       List<Colaborador> colaborador = cr.findAll();

        isEmpty(colaborador);

        List<ColaboradorDTO> allcolaboradores = new ArrayList<>();

       for (Colaborador c: colaborador) {
           ColaboradorDTO dto = new ColaboradorDTO(c, c.getPessoa());
           allcolaboradores.add(dto);
       }
        return allcolaboradores;
    }

    public ColaboradorDTO findById(Long id) throws Exception {
        Colaborador colaborador = cr.getOne(id);
        isEmpty(colaborador);
        return new ColaboradorDTO(colaborador, colaborador.getPessoa());
    }

    public ColaboradorDTO findByCpf(String cpf) throws Exception{
        if(cpf.isEmpty()){
            throw new Exception(Message.CPF_NAO_PREENCHIDO);
        }
        Pessoa pessoa = pessoaRepository.findByCPF(cpf);
        isEmpty(pessoa);

        return getColaboradorDTO(pessoa);
    }

    private ColaboradorDTO getColaboradorDTO(Pessoa pessoa) {
        ColaboradorDTO dto = new ColaboradorDTO();
        for (Colaborador colaborador: pessoa.getColaborador()){
            dto = new ColaboradorDTO(colaborador, pessoa);
        }
        return dto;
    }

    public ColaboradorDTO findByNome(String nome) throws Exception{
        if(nome.isEmpty()){
            throw new Exception(Message.NOME_NAO_PREENCHIDO);
        }
        Pessoa pessoa = pessoaRepository.findByNome(nome);
        isEmpty(pessoa);
        return getColaboradorDTO(pessoa);
    }

    private void isEmpty(List<Colaborador> colaborador) throws Exception {
        if(colaborador.isEmpty()){
            throw new Exception(Message.RESULTADO_NAO_ENCONTRADO);
        }
    }

    private void isEmpty(Object object) throws Exception {
        if(object == null){
            throw new Exception(Message.RESULTADO_NAO_ENCONTRADO);
        }
    }

}
