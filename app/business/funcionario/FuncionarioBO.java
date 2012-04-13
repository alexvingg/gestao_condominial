package business.funcionario;

import play.data.validation.*;
import models.funcionarios.Funcionario;
import models.cargos.Cargo;
import models.funcionarios.Funcionario;
import play.modules.paginate.ModelPaginator;
import play.modules.paginate.ValuePaginator;
import play.mvc.Controller;

public class FuncionarioBO {
	
	protected static Validation validation = null;
	
	public static Boolean isNomeNulo(Funcionario funcionario){
		/*validation.required(funcionario.nome);
		if(validation.hasErrors()) {
			return false;	
		}*/
		return true;
	}
}
