package models.cargos;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity(name = "tb_cargos")
public class Cargo extends Model {

	public String descricao;

}
