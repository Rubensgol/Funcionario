package Model;

import java.util.Arrays;
import java.util.Date;

import Util.DataUtil;

public class Funcionario extends Usuario {
	private String nome;
	private String email;
	private double[] horas_trabalhadas;
	private double[] valor_hora;
	private Date data_nascimento;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double[] getHoras_trabalhadas() {
		return horas_trabalhadas;
	}
	public void setHoras_trabalhadas(double[] horas_trabalhadas) {
		this.horas_trabalhadas = horas_trabalhadas;
	}
	public double[] getValor_hora() {
		return valor_hora;
	}
	public void setValor_hora(double[] valor_hora) {
		this.valor_hora = valor_hora;
	}
	public Date getData_nascimento() {
		return data_nascimento;
	}
	public void setData_nascimento(Date data_nascimento) {
		this.data_nascimento = data_nascimento;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Funcionario [nome=");
		builder.append(nome);
		builder.append(", email=");
		builder.append(email);
		builder.append(", horas_trabalhadas=");
		builder.append(Arrays.toString(horas_trabalhadas));
		builder.append(", valor_hora=");
		builder.append(Arrays.toString(valor_hora));
		builder.append(", data_nascimento=");
		builder.append(DataUtil.DataForStringPadrao(data_nascimento));
		builder.append(", Usuario=");
		builder.append(getUsuario());
		builder.append(", Senha=");
		builder.append(getSenha());
		builder.append("]");
		return builder.toString();
	}
	
}
