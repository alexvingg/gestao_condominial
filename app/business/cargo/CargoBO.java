package business.cargo;

import play.data.validation.Validation;
import models.cargos.Cargo;
import models.funcionarios.Funcionario;

public class CargoBO {
	
	protected static Validation validation = null;
	
	public static Validation validaCampos(Cargo cargo){
		validation = validation.current();
		validation.required(cargo.descricao).message("O campo descrição é necessário !");
		return validation;
	}
	
}
