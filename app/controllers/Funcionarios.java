package controllers;

import java.util.List;

import business.funcionario.FuncionarioBO;

import models.funcionarios.Funcionario;
import play.mvc.Controller;

public class Funcionarios extends Controller{
	public static void index(){
		List<Funcionario> listaFuncionarios = Funcionario.findAll();
		render(listaFuncionarios);		
	}
}
