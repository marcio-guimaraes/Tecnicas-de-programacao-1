package Listas1.pratica;

import java.util.Scanner;

public class Questao05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        String[] produtos = new String[n];
        int[] quantidade = new int[n];
        //falta colocar a parte dos produtos que foi vendida
        int[] quantidadeVendidos = new int[n];

        for (int i = 0; i < n; i++) {
            produtos[i] = sc.next();
            quantidade[i] = sc.nextInt();
            sc.nextLine();
        }

        String produtoDesejado = null;
        int quantidadeDesejada = 0;

        while (true) {
            produtoDesejado = sc.next();
            if ("fim".equals(produtoDesejado)) {
                for (int i = 0; i < n; i++) {
                    System.out.printf("%s %d\n", produtos[i], quantidade[i]);
                }
                return;
            }

            boolean encontrouProduto = false;
            for (int i = 0; i < n; i++) {
                encontrouProduto = produtoDesejado.equals(produtos[i]);
                if (encontrouProduto) {
                    quantidadeDesejada = sc.nextInt();
                    System.out.println(produtoDesejado + " " + quantidadeDesejada);
                    quantidade[i] -= quantidadeDesejada;
                    break;
                }
            }

            if (!encontrouProduto) {
                System.out.println(produtoDesejado + " produto não encontrado");
            }
        }
    }
}