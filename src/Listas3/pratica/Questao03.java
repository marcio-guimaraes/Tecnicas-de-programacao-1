package Listas3.pratica;

import java.util.Scanner;

class DepositoInvalidoException extends RuntimeException {
    public DepositoInvalidoException(String mensagemErro) {
        super(mensagemErro);
    }
}

class Conta {
    private int agencia;
    private int numero;
    private double saldo;
    private static final double LIMITE_DEPOSITO = 10000;

    public Conta(int agencia, int numero) {
        this.agencia = agencia;
        this.numero = numero;
        this.saldo = 0.0;
    }

    public double getSaldo() {
        return saldo;
    }

    public static double getLimiteDeposito() {
        return LIMITE_DEPOSITO;
    }

    public void depositaPersonalizado(double valor) {
        if (valor <= 0) {
            throw new DepositoInvalidoException("Valor inválido para depósito");
        } else if (valor > 10000) {
            throw new DepositoInvalidoException("Valor acima do limite permitido de 10000.00");
        } else {
            this.saldo = valor;
        }
    }
}

public class Questao03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int agencia = sc.nextInt();
        int numero = sc.nextInt();
        double valorDeposito = 0;

        Conta cont1 = new Conta(agencia, numero);
        try {
            valorDeposito = sc.nextDouble();
            cont1.depositaPersonalizado(valorDeposito);
            System.out.println("Depósito realizado com sucesso.");
        } catch (DepositoInvalidoException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            double saldo = cont1.getSaldo();
            if (valorDeposito <= 0 || valorDeposito > 10000) {
                System.out.printf("Valor %.2f incorreto. Saldo atual: %.2f\n", valorDeposito, saldo);
            } else {
                System.out.printf("Valor %.2f depositado na conta. Novo saldo: %.2f\n", valorDeposito, saldo);
            }
        }
    }
}
