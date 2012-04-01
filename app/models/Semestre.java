package models;

import javax.persistence.Entity;

import play.data.validation.Max;
import play.data.validation.Min;
import play.data.validation.Range;
import play.db.jpa.Model;

@Entity(name = "bq_semestre")
public class Semestre extends Model {
	
	public String ano;
	public Integer semestre;
	
	public Semestre(String ano, Integer semestre){
		this.ano= ano;
		this.semestre = semestre;
	}
	
	public Semestre(){
		
	}
}
