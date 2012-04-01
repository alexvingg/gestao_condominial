package controllers;

import java.util.List;

import models.Semestre;
import play.mvc.Controller;

public class Semestres extends Controller{
	public static void index(){		
		List<Semestre> semestres = Semestre.findAll();
		render(semestres);
	}
}
