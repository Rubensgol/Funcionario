package model;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;

import Interface.Ifuncionario;
import Util.DataUtil;

public class Funcionario extends Usuario implements Ifuncionario {
	private String nome;
	private String email;
	private double[] horas_trabalhadas;
	private double[] valor_hora;
	private Date data_nascimento;
	private String sexo;
	private String cargo;
			
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
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
		DecimalFormat df = new DecimalFormat("###.##");
		StringBuilder builder = new StringBuilder();
		builder.append(mostra_salario(salario_mes()));
		builder.append("Funcionario [nome=");
		builder.append(nome);
		builder.append(", email=");
		builder.append(email);
		builder.append("\n");
		builder.append(cargo);
		builder.append("\n");
		builder.append("horas_trabalhadas=");
		builder.append(mostra_Vetor(horas_trabalhadas));
		builder.append("\n");
		builder.append("valor_hora=");
		builder.append(mostra_Vetor(valor_hora));
		builder.append("\n");
		builder.append("Media Salarios:");
		builder.append(df.format(media_salario()));
		builder.append("\n");
		builder.append("Maiores salarios:");
		builder.append(mostra_Vetor(maiores_salarios(2)));
		builder.append("\n");
		builder.append("Menores salarios");
		builder.append(mostra_Vetor(menores_salario(2)));
		builder.append("\n");
		builder.append("Meses Trabalhados: ");
		builder.append(meses_trabalhados());
		builder.append("\n");
		builder.append("Anos trabalhados: ");
		builder.append(meses_trabalhados()/12);
		builder.append("\n");
		builder.append(anos_meses_trabalhados());
		builder.append("\n");
		builder.append("Ano da aposentadoria por contribuição: ");
		builder.append(ano_aposentadoria_contribuicao());
		builder.append("\n");
		builder.append("Ano da aposentadoria por idade: ");
		builder.append(ano_aposentadoria_idade());
		builder.append("\n");
		builder.append("Anos da aposentadoria: ");
		builder.append(ano_aposentadoria());
		builder.append("\n");
		builder.append("Idade da aposentadoria: ");
		builder.append(idade_aposentadoria());
		builder.append("\n");
		builder.append("Idade atual: ");
		builder.append(idade());
		builder.append("\n");
		builder.append("data_nascimento=");
		builder.append(DataUtil.DataForStringPadrao(data_nascimento));
		builder.append(", Usuario=");
		builder.append(getUsuario());
		builder.append(", Senha=");
		builder.append(getSenha());
		builder.append("]");
		return builder.toString();
	}
	
	private String mostra_Vetor(double[] vetor)
	{
		DecimalFormat df = new DecimalFormat("###.##");
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < vetor.length; i++) {
			builder.append("[");
			builder.append(df.format(vetor[i]));
			builder.append("]");
		}
		return builder.toString();
	}	
	private String mostra_salario(double[] vetor) {
		double[] salario=vetor;
		DecimalFormat df = new DecimalFormat("###.##");
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < salario.length; i++) {
			builder.append("Salario "+i+": R$");
			builder.append(df.format(salario[i]));
			builder.append("\n");
		}
		return builder.toString();
	}

	@Override
	public double[] salario_mes() {
		
		double[] salario_mes=new double[horas_trabalhadas.length];
		for (int i = 0; i < salario_mes.length; i++) {
			salario_mes[i]=horas_trabalhadas[i]*valor_hora[i];
		}
		return salario_mes;
	}
	@Override
	public double total_salario() {
		double[] total_salario=salario_mes();
		double d=0;
		for (int i = 0; i < total_salario.length; i++) {
			 d += total_salario[i];
			
		}
		return d;
	}
	@Override
	public double media_salario() {
		double media_salario=total_salario()/horas_trabalhadas.length;
		return media_salario;
	}
	@Override
	public double[] maiores_salarios(int n) {
		double[] salarios = salario_mes();
		double[] maiores_salarios = new double[n];
		Arrays.sort(salarios);
		for(int i=0; i<n; i++) {
			maiores_salarios[i]=salarios[(salarios.length-1)-i];
		}
		return maiores_salarios;
	}
	@Override
	public double[] menores_salario(int n) {
		double[] salarios = salario_mes();
		double[] menores_salarios = new double[n];
		Arrays.sort(salarios);
		for(int i=0; i<n; i++) {
			menores_salarios[i]=salarios[i];
		}
		return menores_salarios;
	}
	@Override
	public int meses_trabalhados() {
		
		return horas_trabalhadas.length;
	}
	@Override
	public String anos_meses_trabalhados() {
		String anos_meses;
		int meses = meses_trabalhados();
		if (meses>12) {
			int anos = meses/12;
			meses = meses-(anos*12);
			anos_meses="Anos e Meses Trabalhados: "+anos+" ano(s) e "+meses + " meses";
		}
		else
			anos_meses="Meses Trabalhados: "+ meses + " meses";
			
		return anos_meses;
	}
	

	public int calcula_anos_faltando_Aposentadoria_idade() {
		int ano_nascimento=DataUtil.AnoEmInteiro(data_nascimento);
		int ano_atual = LocalDateTime.now().getYear();
		int idade = ano_atual-ano_nascimento;
		if(sexo.equals("homem")){
			int anos_faltanto_aposentadoria_idade=65-idade;		
			return anos_faltanto_aposentadoria_idade;
			
		}else {
			int anos_faltanto_aposentadoria_idade=62-idade;		
			return anos_faltanto_aposentadoria_idade;
		}
	}
	public int calcula_anos_faltando_aposentadoria_contribuicao() {
		int anos_trabalhados = meses_trabalhados()/12;
		return 35-anos_trabalhados;
	}
	
	public int ano_aposentadoria_idade() {
		int idade= calcula_anos_faltando_Aposentadoria_idade();
		int ano=LocalDateTime.now().getYear();
		return ano+idade;
	}
	public int ano_aposentadoria_contribuicao() {
		int contribuicao = calcula_anos_faltando_aposentadoria_contribuicao();
		int ano=LocalDateTime.now().getYear();
		return ano+contribuicao;
	}
	@Override
	public int ano_aposentadoria() {
		int idade= calcula_anos_faltando_Aposentadoria_idade();
		int contribuicao = calcula_anos_faltando_aposentadoria_contribuicao();
		int ano=LocalDateTime.now().getYear();
		if(idade>contribuicao) {
			return ano+idade;
		}else
			return ano+contribuicao;
		
	}
	private int idade()
	{
		int ano=LocalDateTime.now().getYear();
		return ano-DataUtil.AnoEmInteiro(data_nascimento);
		
	}
	@Override
	public int idade_aposentadoria() {
		int ano_nascimento=DataUtil.AnoEmInteiro(data_nascimento);
		return ano_aposentadoria()-ano_nascimento;
	}
	
}
