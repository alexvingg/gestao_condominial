package business.funcionario;

import models.funcionarios.Funcionario;

public class FuncionarioBO {
	
	public static Boolean isNomeNulo(Funcionario funcionario){
		if(funcionario.getNome().isEmpty() || funcionario.getNome() == null || funcionario.getNome().equals("")){
			return true;
		}
		return false;	
	}
}
