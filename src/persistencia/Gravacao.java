package persistencia;

import java.util.List;

import model.Funcionario;

public interface Gravacao {
	
	public boolean gravar(List<Funcionario> funcionarios);
	public List<Funcionario> ler();
}
