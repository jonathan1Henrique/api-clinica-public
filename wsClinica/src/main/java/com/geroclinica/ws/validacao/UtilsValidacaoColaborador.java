package com.geroclinica.ws.validacao;


import com.geroclinica.ws.dto.ColaboradorDTO;
import com.geroclinica.ws.dto.PacienteDTO;
import com.geroclinica.ws.models.Colaborador;
import com.geroclinica.ws.models.Endereco;
import com.geroclinica.ws.models.Paciente;
import com.geroclinica.ws.models.Pessoa;
import com.geroclinica.ws.statics.Message;

public class UtilsValidacaoColaborador {
	
	public static Boolean validaCamposPaciente(Colaborador colaborador) throws Exception{

		if(colaborador.getSituacao().isEmpty()) {
			throw new Exception(Message.PARAMENTRO_OBRIGATORIO + "Situação");
		}
		if (!UtilsValidacaoPessoa.validaCamposPessoa(colaborador.getPessoa())) {
			throw new Exception();
		}
		else if(!UtilsValidacaoPessoa.validaCamposEndereco(colaborador.getPessoa().getEndereco())) {
			throw new Exception();
		}
		return true;
	}

	public static Boolean validaCamposColaboradorDTO(ColaboradorDTO colaborador) throws Exception{
		if(colaborador.getSituacao().isEmpty()) {
			throw new Exception(Message.PARAMENTRO_OBRIGATORIO + "Situação");
		}
		else if (colaborador.getNome().isEmpty()) {
			throw new Exception(Message.PARAMENTRO_OBRIGATORIO + "Nome");
		}
		else if(colaborador.getCpf().isEmpty()) {
			throw new Exception(Message.PARAMENTRO_OBRIGATORIO + "CPF");
		}
		else if(colaborador.getTelefone().isEmpty()) {
			throw new Exception(Message.PARAMENTRO_OBRIGATORIO + "Telefone");
		}
		else if(colaborador.getDataNasc().isEmpty()) {
			throw new Exception(Message.PARAMENTRO_OBRIGATORIO + "DataNasc");
		}
		else if(colaborador.getGenero().isEmpty()) {
			throw new Exception(Message.PARAMENTRO_OBRIGATORIO + "Genero");
		}
		else if(colaborador.getEndereco().getCep() == null) {
			throw new Exception(Message.PARAMENTRO_OBRIGATORIO + "Cep");
		}
		else if(colaborador.getEndereco().getRua().isEmpty()) {
			throw new Exception(Message.PARAMENTRO_OBRIGATORIO + "Rua");
		}
		else if(colaborador.getEndereco().getBairro().isEmpty()) {
			throw new Exception(Message.PARAMENTRO_OBRIGATORIO + "Cep");
		}
		else if(colaborador.getEndereco().getCidade().isEmpty()) {
			throw new Exception(Message.PARAMENTRO_OBRIGATORIO + "Cidade");
		}

		return true;
	}

}
