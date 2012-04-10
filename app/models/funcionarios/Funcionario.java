package models.funcionarios;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import models.cargos.Cargo;


import play.db.jpa.Model;
import util.conversores.StringUtil;
import util.conversores.UtilidadesConversao;

@Entity(name="tb_funcionarios")
public class Funcionario extends Model{
	
	public String nome;
	public Long cpf;	
	public Long num_carteira_trabalho;
	public String telefone_fixo;
	public String telefone_celular;
	public String email;
	
	@Temporal(TemporalType.DATE)
	public Date data_nascimento;
	
	public String endereco;
	public String bairro;
	public String cep;
	public String cidade;
	public String estado;
	
	@ManyToOne
	public Cargo cargo;
	
	@Temporal(TemporalType.DATE)
	public Date data_admissao;
	public Integer carga_horaria;
	public BigDecimal salario;

	public String getCpfFormatado(){
		return UtilidadesConversao.formataCpf(cpf);
	}
	
	public String getCodigoFuncionario(){
		return StringUtil.padLeft(String.valueOf(id), 10, '0');
	}
	
}
