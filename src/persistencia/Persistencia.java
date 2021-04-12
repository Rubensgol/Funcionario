package persistencia;

import java.util.List;

import model.Funcionario;

public class Persistencia {

private Gravacao gravacao;
	
	public Persistencia(Gravacao gravacao) {
		this.gravacao = gravacao;
	}
	
	public boolean gravar(List<Funcionario> funcionarios) {
		return gravacao.gravar(funcionarios);
		
	}
	public List<Funcionario> ler(){
		return gravacao.ler();
	}
}
