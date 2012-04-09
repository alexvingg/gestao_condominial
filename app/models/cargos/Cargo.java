package models.cargos;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity(name="tb_cargos")
public class Cargo extends Model{
	
	private String descricao;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
