package controllers;

import java.util.List;

import business.funcionario.FuncionarioBO;

import models.funcionarios.Funcionario;
import play.modules.paginate.ModelPaginator;
import play.modules.paginate.ValuePaginator;
import play.mvc.Controller;

public class Funcionarios extends Controller{
	public static void index(){
		List<Funcionario> listaFuncionarios = Funcionario.findAll();
		ValuePaginator paginator = new ValuePaginator(listaFuncionarios);
		paginator.setPageSize(10);
	    render(paginator);
	}
	
	public static void simular(){
		Funcionario fun = (Funcionario) Funcionario.findById(new Long(1));
		flash.success("O registro " + fun.getCpfFormatado() + " apagado com sucesso!");
		index();
	}
	
	public static void demo(){
		List<Funcionario> listaFuncionarios = Funcionario.findAll();
		render(listaFuncionarios);
	}
}
