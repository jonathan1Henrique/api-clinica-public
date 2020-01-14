package com.geroclinica.ws.dto;

import com.geroclinica.ws.models.Paciente;
import com.geroclinica.ws.models.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PacienteDTO {

	private Long id;
	private Long idPessoa;
	private String nome;
	private String cpf;
	private String telefone;
	private String dataNasc;
	private String genero;
	private String laudo;
	private String situacao;
	private String convenio;
	private EnderecoDTO endereco;

	public PacienteDTO(Paciente paciente, Pessoa pessoa){
		this.id = paciente.getId();
		this.idPessoa = pessoa.getId();
		this.nome = pessoa.getNome();
		this.cpf = pessoa.getCpf();
		this.telefone = pessoa.getTelefone();
		this.dataNasc = pessoa.getDataNasc();
		this.genero = pessoa.getGenero();
		this.convenio = paciente.getConvenio();
		this.laudo = paciente.getLaudo();
		this.situacao = paciente.getSituacao();
		this.endereco = new EnderecoDTO(pessoa.getEndereco());
	}

	public Paciente montaPaciente(PacienteDTO dto){
		Paciente p = new Paciente();
		p.setConvenio(dto.getConvenio());
		p.setId(dto.getId());
		p.setLaudo(dto.getLaudo());
		p.setSituacao(dto.getSituacao());
		p.getPessoa().setId(dto.getIdPessoa());
		p.getPessoa().setCpf(dto.getCpf());
		p.getPessoa().setNome(dto.getNome());
		p.getPessoa().setTelefone(dto.getTelefone());
		p.getPessoa().setDataNasc(dto.getDataNasc());
		p.getPessoa().setGenero(dto.getGenero());

		return p;
	}

}
