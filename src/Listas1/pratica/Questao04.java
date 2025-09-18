package Listas1.pratica;

import java.util.Scanner;

public class Questao04 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        double valorArrecadado = 0;
        int quantMulher = 0, quantHomem = 0;

        while (true) {
            int entrada = sc.next().charAt(0);

            switch (entrada) {
                case 'h':
                    quantHomem++;
                    valorArrecadado += 12.50;
                    break;

                case 'm':
                    quantMulher++;
                    valorArrecadado += 7.40;
                    break;

                case 'q':
                    System.out.printf("%d %d\n%.2f %.2f %.2f", quantHomem, quantMulher, quantHomem * 12.5, quantMulher * 7.4, valorArrecadado);
                    return;
            }
        }
    }
}