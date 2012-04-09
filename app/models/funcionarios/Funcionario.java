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
	
	private String nome;
	private Long cpf;	
	private Long num_carteira_trabalho;
	private String telefone_fixo;
	private String telefone_celular;
	private String email;
	
	@Temporal(TemporalType.DATE)
	private Date data_nascimento;
	
	private String endereco;
	private String bairro;
	private String cep;
	private String cidade;
	private String estado;
	
	@ManyToOne
	private Cargo cargo;
	
	@Temporal(TemporalType.DATE)
	private Date data_admissao;
	private Integer carga_horaria;
	private BigDecimal salario;
	
	
	public Long getCpf() {
		return cpf;
	}
	
	public String getCpfFormatado(){
		return UtilidadesConversao.formataCpf(this.getCpf());
	}
	
	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCodigoFuncionario(){
		return StringUtil.padLeft(String.valueOf(this.id), 10, '0');
	}

	public Long getNum_carteira_trabalho() {
		return num_carteira_trabalho;
	}

	public void setNum_carteira_trabalho(Long num_carteira_trabalho) {
		this.num_carteira_trabalho = num_carteira_trabalho;
	}

	public String getTelefone_fixo() {
		return telefone_fixo;
	}

	public void setTelefone_fixo(String telefone_fixo) {
		this.telefone_fixo = telefone_fixo;
	}

	public String getTelefone_celular() {
		return telefone_celular;
	}

	public void setTelefone_celular(String telefone_celular) {
		this.telefone_celular = telefone_celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(Date data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Date getData_admissao() {
		return data_admissao;
	}

	public void setData_admissao(Date data_admissao) {
		this.data_admissao = data_admissao;
	}

	public Integer getCarga_horaria() {
		return carga_horaria;
	}

	public void setCarga_horaria(Integer carga_horaria) {
		this.carga_horaria = carga_horaria;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}
	
	
	
	
}
