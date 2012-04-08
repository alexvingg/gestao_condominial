package models.funcionarios;

import javax.persistence.Entity;


import play.db.jpa.Model;
import util.conversores.StringUtil;
import util.conversores.UtilidadesConversao;

@Entity(name="tb_funcionarios")
public class Funcionario extends Model{
	
	private Long cpf;	
	private String nome;
	
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
	
	
}
