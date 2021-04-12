package main;

import java.text.ParseException;
import java.util.Random;

import Util.DataUtil;
import model.Funcionario;
import model.ListaFuncionario;
import persistencia.Gravacao;
import persistencia.GravarJSON;
import persistencia.GravarXML;
import persistencia.Persistencia;

public class main {

	public static void main(String[] args) {
		
		Random r = new Random();
		Funcionario funcionario = new Funcionario();
		try {
			funcionario.setData_nascimento(DataUtil.StringParaData("10/12/2010"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		funcionario.setEmail("rubenssilva905@gmail.com");
		funcionario.setNome("rubens");
		funcionario.setSenha("aralis16");
		funcionario.setSexo("homem");
		funcionario.setUsuario("rubens");
		double[] hora_trabalhada = new double[15];
		for (int i = 0; i < hora_trabalhada.length; i++) {
			hora_trabalhada[i] = r.nextDouble()*10*16;
		}
		funcionario.setHoras_trabalhadas(hora_trabalhada);
		double[] valor_hora = new double[15];
		for (int i = 0; i < valor_hora.length; i++) {
			valor_hora[i]=r.nextDouble()*10*75;
		}
		funcionario.setValor_hora(valor_hora);
		System.out.println(funcionario.toString());
		
		ListaFuncionario lf = new ListaFuncionario();
		Gravacao gra = new GravarXML();
		Persistencia p = new Persistencia(gra);
		
		lf.setFuncionarios(gra.ler());
		
		
		
		System.out.println(lf.getFuncionarios().toString());

	}

}
