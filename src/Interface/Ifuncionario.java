package Interface;

public interface Ifuncionario {
	
	public double salario_mes();
	public double total_salario();
	public double media_salario();
	public double[] maiores_salarios(int n);
	public double[] menores_salario(int n);
	public int meses_trabalhados();
	public String anos_meses_trabalhados();
	public int ano_aposentadoria();
	public int idade_aposentadoria();
}
