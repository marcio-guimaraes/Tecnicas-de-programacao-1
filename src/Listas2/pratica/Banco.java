package Listas2.pratica;

import java.util.Scanner;

class Conta {

    private int numConta, senha;
    private String nome;
    private double saldo;

    public Conta(int numConta, int senha, String nome, double saldo) {
        this.numConta = numConta;
        this.senha = senha;
        this.nome = nome;
        this.saldo = saldo;
    }

    public int getNumConta() {
        return numConta;
    }

    public String getNome() {
        return nome;
    }

    public double getSaldo(int senha) {
        if (senha == this.senha) {
            return saldo;
        }
        return -1;
    }

    public boolean sacar(double valorSaque, int senha) {
        if (senha == this.senha && valorSaque > 0 && valorSaque <= this.saldo) {
            this.saldo -= valorSaque;
            return true;
        }
        return false;
    }

    public boolean depositar(double valorDeposito, int senha) {
        if (senha == this.senha && valorDeposito > 0) {
            this.saldo += valorDeposito;
            return true;
        }
        return false;
    }

    public boolean tranferir(double valor, int senha, Conta conta2) {
        if (senha == this.senha && valor > 0 && valor <= this.saldo) {
            this.saldo -= valor;
            conta2.saldo += valor;
            return true;
        }
        return false;
    }
}

public class Banco {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int numConta = sc.nextInt();
        int senhaConta = sc.nextInt();
        String nomeCliente = sc.next();
        double saldoInicial = sc.nextDouble();
        Conta c1 = new Conta(numConta, senhaConta, nomeCliente, saldoInicial);

        numConta = sc.nextInt();
        senhaConta = sc.nextInt();
        nomeCliente = sc.next();
        saldoInicial = sc.nextDouble();
        Conta c2 = new Conta(numConta, senhaConta, nomeCliente, saldoInicial);

        int opcao;
        while (true) {
            opcao = sc.nextInt();

            if (opcao == 5) {
                break;
            }

            switch (opcao) {
                case 1: {
                    int senha = sc.nextInt();
                    double saldo = c1.getSaldo(senha);
                    if (saldo == -1) {
                        System.out.println("senha incorreta");
                    } else {
                        System.out.printf("%.2f\n", saldo);
                    }
                    break;
                }
                case 2: {
                    double valorSaque = sc.nextDouble();
                    int senha = sc.nextInt();

                    if (c1.sacar(valorSaque, senha)) {
                        System.out.println("saque realizado");
                    } else {
                        System.out.println("saque não realizado");
                    }
                    break;
                }
                case 3: {
                    double valorDeposito = sc.nextDouble();
                    int senha = sc.nextInt();

                    if (c1.depositar(valorDeposito, senha)) {
                        System.out.println("deposito realizado");
                    } else {
                        System.out.println("deposito nao realizado");
                    }
                    break;
                }
                case 4: {
                    String nome = sc.next();
                    if (nome.equals(c2.getNome())) {
                        double valorTransferencia = sc.nextDouble();
                        int senha = sc.nextInt();

                        if (c1.tranferir(valorTransferencia, senha, c2)) {
                            System.out.println("transferencia realizada");
                        } else {
                            System.out.println("transferencia nao realizada");
                        }
                    } else {
                        System.out.println("nenhum usuário encontrado");
                    }
                    break;
                }
            }
        }
        sc.close();
    }
}