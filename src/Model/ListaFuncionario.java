package model;

import java.util.ArrayList;
import java.util.List;

public class ListaFuncionario {
	protected List<Funcionario> funcionarios;
	public ListaFuncionario() {
		funcionarios = new ArrayList<Funcionario>();
	}
	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}
	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
	
	public boolean adicionarFuncionario(Funcionario funcionario) {
		for (Funcionario funcionarioa : funcionarios) {
			if(funcionarioa.getEmail().equals(funcionario.getEmail()))
				return false;
		}
		return funcionarios.add(funcionario);
	}
	
	public Funcionario buscaFuncionario(Funcionario funcionario) {
		for (Funcionario funcionarioa : funcionarios) {
			if(funcionarioa.getEmail().equals(funcionario.getEmail()))
				return funcionarioa;
		}
		return null;
	}
	public boolean excluiFuncionario(Funcionario funcionario) {
		for (Funcionario funcionarioa : funcionarios) {
			if(funcionarioa.getEmail().equals(funcionario.getEmail()))
				
				return funcionarios.remove(funcionarioa);;
		}
		return false;
	}
}
