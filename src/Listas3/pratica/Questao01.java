package Listas3.pratica;

import java.util.Scanner;

class Funcionario {

    String nomeFuncionario;
    int qtdeProducao;
    int horasTrabalhadas;

    public Funcionario(String nomeFuncionario, int qtdeProducao, int horasTrabalhadas) {
        this.nomeFuncionario = nomeFuncionario;
        this.qtdeProducao = qtdeProducao;
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public int calcularProdutividade() throws ArithmeticException {
        return qtdeProducao / horasTrabalhadas;
    }
}

public class Questao01 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        try {
            String nome = entrada.nextLine();
            int producao = entrada.nextInt();
            int horas = entrada.nextInt();

            Funcionario funcionario = new Funcionario(nome, producao, horas);
            int produtividade = funcionario.calcularProdutividade();

            System.out.printf("Produtividade: %d peças por hora%n", produtividade);

        } catch (ArithmeticException e) {
            System.out.println("Erro: horas trabalhadas não podem ser zero");

        } catch (Exception e) {
            System.out.println("Erro inesperado");

        } finally {
            entrada.close();
        }
    }
}