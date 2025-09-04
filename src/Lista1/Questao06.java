package Lista1;

import java.util.Scanner;

public class Questao06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        String[] palavras = new String[n];

        for (int i = 0; i < n; i++) {
            palavras[i] = sc.nextLine();
        }

        String palavraProcurada = sc.nextLine();

        for (int i = 0; i < n; i++) {
            if (palavraProcurada.equals(palavras[i])) {
                System.out.println("palavra correta");
                return;
            } else if (palavraProcurada.length() == palavras[i].length() && (palavraProcurada.charAt(0) == palavras[i].charAt(0) || palavraProcurada.charAt(0) == palavras[i].charAt(1))) {
                for (int j = 0; j < palavraProcurada.length() - 1; j++) {
                    StringBuilder sb = new StringBuilder(palavraProcurada);
                    char c1 = palavraProcurada.charAt(j);
                    char c2 = palavraProcurada.charAt(j + 1);
                    sb.setCharAt(j, c2);
                    sb.setCharAt(j + 1, c1);

                    if (sb.toString().equals(palavras[i])) {
                        System.out.println("palavra incorreta");
                        System.out.println(palavras[i] + "?");
                        return;
                    }
                }
            }

        }
        System.out.println("palavra incorreta");
        System.out.println("nenhuma sugestão");
        sc.close();
    }
}