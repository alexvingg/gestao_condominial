package controllers;

import java.util.List;

import business.funcionario.FuncionarioBO;

import models.cargos.Cargo;
import models.funcionarios.Funcionario;
import play.modules.paginate.ModelPaginator;
import play.modules.paginate.ValuePaginator;
import play.mvc.Controller;

public class Funcionarios extends Controller{
	
	public static void index(){
		//Lista os funcionários paginando
		List<Funcionario> listaFuncionarios = Funcionario.findAll();
		ValuePaginator paginator = new ValuePaginator(listaFuncionarios);
		paginator.setPageSize(15);
		
		//Lista os cargos para serem exibidos no select do modal
		List<Cargo> cargos = Cargo.findAll();
	    render(paginator, cargos);
	}
}
