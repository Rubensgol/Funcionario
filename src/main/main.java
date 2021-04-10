package main;

import java.text.ParseException;
import java.util.Random;

import Model.Funcionario;
import Util.DataUtil;

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
		funcionario.setUsuario("rubens");
		double[] hora_trabalhada = new double[15];
		for (int i = 0; i < hora_trabalhada.length; i++) {
			hora_trabalhada[i] = r.nextDouble()*10*16;
		}
		funcionario.setHoras_trabalhadas(hora_trabalhada);
		double[] valor_hora = new double[15];
		for (int i = 0; i < valor_hora.length; i++) {
			valor_hora[i]=r.nextDouble()*10*150;
		}
		funcionario.setValor_hora(valor_hora);
		System.out.println(funcionario.toString());
		

	}

}
