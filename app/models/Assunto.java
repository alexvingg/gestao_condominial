package models;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity(name="bq_assunto")
public class Assunto extends Model{
	public String nomeAssunto;
}
