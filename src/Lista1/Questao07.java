package Lista1;

import java.util.Scanner;

public class Questao07 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int quant = sc.nextInt();
        sc.nextLine();

        String[] siglas = new String[quant];
        String[] palavras = new String[quant];

        for (int i = 0; i < quant; i++) {
            String linha = sc.nextLine();
            String[] partes = linha.split(" ");
            siglas[i] = partes[0];
            palavras[i] = partes[1];
        }

        String frase = sc.nextLine();
        String[] palavrasDaFrase = frase.split(" ");

        for (int i = 0; i < palavrasDaFrase.length; i++) {
            boolean encontrou = false;
            for (int j = 0; j < siglas.length; j++) {
                if (palavrasDaFrase[i].toLowerCase().equals(siglas[j])) {
                    System.out.print(palavras[j] + " ");
                    encontrou = true;
                    break;
                }
            }
            if (!encontrou) {
                System.out.print(palavrasDaFrase[i] + " ");
            }
        }
    }
}
