package Listas3.pratica;

import java.util.Scanner;

class ValidarSenha {
    String senha;

    public ValidarSenha(String senha) {
        this.senha = senha;
    }

    public void verificarMaiusculas() throws IllegalArgumentException {
        for (int i = 0; i < this.senha.length(); i++) {
            if (Character.isUpperCase(this.senha.charAt(i))) {
                return;
            }
        }
        throw new IllegalArgumentException("Erro: a senha deve conter pelo menos uma letra maiúscula");
    }
}

public class Questao02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String entrada = sc.nextLine();
            try {
                ValidarSenha senha1 = new ValidarSenha(entrada);
                senha1.verificarMaiusculas();
                System.out.println("Senha válida");
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        sc.close();
    }
}