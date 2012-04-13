package controllers;

import java.util.List;

import business.cargo.CargoBO;

import models.cargos.Cargo;
import models.funcionarios.Funcionario;
import play.data.validation.Validation;
import play.modules.paginate.ValuePaginator;
import play.mvc.Controller;

public class Cargos extends Controller{

	public static void index(){
		//Lista os funcionários paginando
		List<Cargo> listaCargos= Cargo.findAll();
		ValuePaginator cargosPaginado = new ValuePaginator(listaCargos);
		cargosPaginado.setPageSize(15);
	    render(cargosPaginado);
	}
	
	public static void form(Long id) {
		if (id != null) {
			Cargo cargo= Cargo.findById(id);
			render(cargo);
		} else {
			render();
		}
	}
	
	public static void save(Long id, Cargo cargoVO) {
		Cargo cargo;		
		if(id == null){
			cargo = cargoVO;
			cargoVO = null;
		}else{
			cargo = Cargo.findById(id);
			if(cargo != null){
				cargo.descricao = cargoVO.descricao;
			}else{
				flash.error("Registro não encontrado");
			}
		}
		
		CargoBO c = new CargoBO();
		c.validaCampos(cargo);
		
		 if(validation.hasErrors()) {
			 String erros = "";
	         for(play.data.validation.Error error : validation.errors()) {
	             erros += error.message() + "<br/>";
	         }
			 flash.error(erros);
			 System.out.println(erros);
		 }
		
		//cargo.save();
		//flash.success("O registro cadastrado com sucesso!");
		//index();
	}
}
