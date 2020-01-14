package com.geroclinica.ws.statics;


import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;

import javax.validation.Valid;
import java.util.Locale;

@Getter
@Setter
public class Message {

    public static final String IS_VAZIO = " Objeto não pode ser vazio";
    public static final String CPF_NAO_PREENCHIDO = "CPF obrigatório para a pesquisa";
    public static final String CPF_NAO_CADASTRADO = " CPF não cadastrado";
    public static final String CPF_NAO_VALIDO = "CPF não é valido";
    public static final String CPF_DUPLICADO = "CPF duplicado no bando de dados";
    public static final String PACIENTE_NAO_ENCONTRADO_PACIENTE = " Não existe paciente com o CPF Informado";
    public static final String COLABORADOR_NAO_ENCONTRADO_PACIENTE = " Não existe colaborador com o CNPJ Informado";
    public static final String NOME_NAO_PREENCHIDO = " Nome obrigatório para a pesquisa";
    public static final String NOME_PACIENTE_NAO_ENCONTRADO = " Paciente não encontrado com esse nome";
    public static final String NOME_NAO_PERTENCE_PACIENTE = " Nome não pertence a um paciente";
    public static final String ID_OBRIGATORIO = " ID Obrigatório";
    public static final String ID_NAO_PERTENCE_A_PACIENTE = "Paciente não encontrado com esse ID";
    public static final String PARAMENTRO_OBRIGATORIO = "Obrigatório a passagem do parametro ";
    public static final String RESULTADO_NAO_ENCONTRADO = "Resultado não encontrado";


}
