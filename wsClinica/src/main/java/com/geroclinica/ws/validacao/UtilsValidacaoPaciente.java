package com.geroclinica.ws.validacao;


import com.geroclinica.ws.dto.PacienteDTO;
import com.geroclinica.ws.models.Endereco;
import com.geroclinica.ws.models.Paciente;
import com.geroclinica.ws.models.Pessoa;
import com.geroclinica.ws.statics.Message;

public class UtilsValidacaoPaciente {
	public static Boolean validaCamposPaciente(Paciente paciente) throws Exception{

		if(paciente.getLaudo().isEmpty() || paciente.getLaudo() == null) {
			throw new Exception(Message.PARAMENTRO_OBRIGATORIO + "Laudo");
		}
		else if(paciente.getSituacao().isEmpty()) {
			throw new Exception(Message.PARAMENTRO_OBRIGATORIO + "Situação");
		}
		if (!UtilsValidacaoPessoa.validaCamposPessoa(paciente.getPessoa())) {
			throw new Exception();
		}
		else if(!UtilsValidacaoPessoa.validaCamposEndereco(paciente.getPessoa().getEndereco())) {
			throw new Exception();
		}
		return true;
	}


	public static Boolean validaCamposPacienteDTO(PacienteDTO paciente) throws Exception{
		if(paciente.getLaudo().isEmpty()) {
			throw new Exception(Message.PARAMENTRO_OBRIGATORIO + "Laudo");
		}
		else if(paciente.getSituacao().isEmpty()) {
			throw new Exception(Message.PARAMENTRO_OBRIGATORIO + "Situação");
		}
		else if (paciente.getNome().isEmpty()) {
			throw new Exception(Message.PARAMENTRO_OBRIGATORIO + "Nome");
		}
		else if(paciente.getCpf().isEmpty()) {
			throw new Exception(Message.PARAMENTRO_OBRIGATORIO + "CPF");
		}
		else if(paciente.getTelefone().isEmpty()) {
			throw new Exception(Message.PARAMENTRO_OBRIGATORIO + "Telefone");
		}
		else if(paciente.getDataNasc().isEmpty()) {
			throw new Exception(Message.PARAMENTRO_OBRIGATORIO + "DataNasc");
		}
		else if(paciente.getGenero().isEmpty()) {
			throw new Exception(Message.PARAMENTRO_OBRIGATORIO + "Genero");
		}
		else if(paciente.getConvenio().isEmpty()) {
			throw new Exception(Message.PARAMENTRO_OBRIGATORIO + "Conveio");
		}
		else if(paciente.getEndereco().getCep() == null) {
			throw new Exception(Message.PARAMENTRO_OBRIGATORIO + "Cep");
		}
		else if(paciente.getEndereco().getRua().isEmpty()) {
			throw new Exception(Message.PARAMENTRO_OBRIGATORIO + "Rua");
		}
		else if(paciente.getEndereco().getBairro().isEmpty()) {
			throw new Exception(Message.PARAMENTRO_OBRIGATORIO + "Cep");
		}
		else if(paciente.getEndereco().getCidade().isEmpty()) {
			throw new Exception(Message.PARAMENTRO_OBRIGATORIO + "Cidade");
		}

		return true;
	}

}
