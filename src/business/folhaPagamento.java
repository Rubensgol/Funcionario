package business;

import Interface.Ifuncionario;
import model.Funcionario;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import util.DataUtil;

public class folhaPagamento implements Ifuncionario {

    protected Funcionario funcionario;

    public folhaPagamento() {
        funcionario = new Funcionario();
    }

    private String mostra_Vetor(double[] vetor) {
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
        double[] salario = vetor;
        DecimalFormat df = new DecimalFormat("###.##");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < salario.length; i++) {
            builder.append("Salario " + i + ": R$");
            builder.append(df.format(salario[i]));
            builder.append("\n");
        }
        return builder.toString();
    }

    @Override
    public double[] salario_mes() {

        double[] salario_mes = new double[funcionario.getHoras_trabalhadas().length];
        for (int i = 0; i < salario_mes.length; i++) {
            salario_mes[i] = funcionario.getHoras_trabalhadas()[i] * funcionario.getValor_hora()[i];
        }
        return salario_mes;
    }

    @Override
    public double total_salario() {
        double[] total_salario = salario_mes();
        double d = 0;
        for (int i = 0; i < total_salario.length; i++) {
            d += total_salario[i];

        }
        return d;
    }

    @Override
    public double media_salario() {
        double media_salario = total_salario() / funcionario.getHoras_trabalhadas().length;
        return media_salario;
    }

    @Override
    public double[] maiores_salarios(int n) {
        double[] salarios = salario_mes();
        double[] maiores_salarios = new double[n];
        Arrays.sort(salarios);
        for (int i = 0; i < n; i++) {
            maiores_salarios[i] = salarios[(salarios.length - 1) - i];
        }
        return maiores_salarios;
    }

    @Override
    public double[] menores_salario(int n) {
        double[] salarios = salario_mes();
        double[] menores_salarios = new double[n];
        Arrays.sort(salarios);
        for (int i = 0; i < n; i++) {
            menores_salarios[i] = salarios[i];
        }
        return menores_salarios;
    }

    @Override
    public int meses_trabalhados() {

        return funcionario.getHoras_trabalhadas().length;
    }

    @Override
    public String anos_meses_trabalhados() {
        String anos_meses;
        int meses = meses_trabalhados();
        if (meses > 12) {
            int anos = meses / 12;
            meses = meses - (anos * 12);
            anos_meses = "Anos e Meses Trabalhados: " + anos + " ano(s) e " + meses + " meses";
        } else
            anos_meses = "Meses Trabalhados: " + meses + " meses";

        return anos_meses;
    }

    public int calcula_anos_faltando_Aposentadoria_idade() {
        int ano_nascimento = DataUtil.AnoEmInteiro(funcionario.getData_nascimento());
        int ano_atual = LocalDateTime.now().getYear();
        int idade = ano_atual - ano_nascimento;
        if (funcionario.getSexo().equals("homem")) {
            int anos_faltanto_aposentadoria_idade = 65 - idade;
            return anos_faltanto_aposentadoria_idade;

        } else {
            int anos_faltanto_aposentadoria_idade = 62 - idade;
            return anos_faltanto_aposentadoria_idade;
        }
    }

    public int calcula_anos_faltando_aposentadoria_contribuicao() {
        int anos_trabalhados = meses_trabalhados() / 12;
        return 35 - anos_trabalhados;
    }

    public int ano_aposentadoria_idade() {
        int idade = calcula_anos_faltando_Aposentadoria_idade();
        int ano = LocalDateTime.now().getYear();
        return ano + idade;
    }

    public int ano_aposentadoria_contribuicao() {
        int contribuicao = calcula_anos_faltando_aposentadoria_contribuicao();
        int ano = LocalDateTime.now().getYear();
        return ano + contribuicao;
    }

    @Override
    public int ano_aposentadoria() {
        int idade = calcula_anos_faltando_Aposentadoria_idade();
        int contribuicao = calcula_anos_faltando_aposentadoria_contribuicao();
        int ano = LocalDateTime.now().getYear();
        if (idade > contribuicao) {
            return ano + idade;
        } else
            return ano + contribuicao;

    }

    private int idade() {
        int ano = LocalDateTime.now().getYear();
        return ano - DataUtil.AnoEmInteiro(funcionario.getData_nascimento());

    }

    @Override
    public int idade_aposentadoria() {
        int ano_nascimento = DataUtil.AnoEmInteiro(funcionario.getData_nascimento());
        return ano_aposentadoria() - ano_nascimento;
    }
}
