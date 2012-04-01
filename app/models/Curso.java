package models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity(name = "bq_curso")
public class Curso extends Model {
	
	@Column(name = "nome_curso")
	public String nome;
	
	@Column(name = "curso_semestre")
	public String semestre;
	
	@Column(name = "tipo_graduacao")
	public String tipo;
	
	@Column(name = "tipo_ciclo")
	public String ciclo;

}
