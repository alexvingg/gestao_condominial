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
	
	public static void form(Long id) {
		List<Cargo> cargos = Cargo.findAll();
		if (id != null) {
			Funcionario funcionario = Funcionario.findById(id);
			render(funcionario, cargos);
		} else {
			render();
		}
	}

	public static void save(Long id, Funcionario funcionarioVO) {

		Funcionario funcionario;

		if (id == null) {
			funcionario = funcionarioVO;
			funcionarioVO = null;
		} else {
			funcionario = Funcionario.findById(id);
			if (funcionario != null) {
				//status.status = funcionarioVO.status;
				//status.gravidade = funcionarioVO.gravidade;
			} else {
				flash.error("Registro não encontrado!");
				index();
			}
		}

		funcionario.save();
		flash.success("O registro cadastrado com sucesso!");
		index();
	}

	public static void delete(Long id) {
		if (id != null) {
			Funcionario funcionario = Funcionario.findById(id);
			String tempValue = funcionario.getCodigoFuncionario();
			funcionario.delete();
			flash.success("O registro " + tempValue + " apagado com sucesso!");
			tempValue = null;
			index();
		}
	}
}
