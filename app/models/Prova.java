package models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import play.db.jpa.Model;

@Entity(name = "bq_prova")
public class Prova extends Model {

	@Column(name = "data_prova")
	public Date data;

	@ManyToOne(fetch = FetchType.LAZY)
	public Curso curso;

	@Column(name = "id_semestre")
	public Semestre semestre;

	@Column(name = "id_periodo")
	public Periodo periodo;

	@Column(name = "nome_prova")
	public String nomeProva;

	@Column(name = "id_ciclo")
	public Ciclo ciclo;

}
