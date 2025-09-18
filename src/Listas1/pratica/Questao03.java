package Listas1.pratica;

import java.util.Locale;
import java.util.Scanner;

public class Questao03 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int tipoLoteamento = sc.nextInt();
        int area = sc.nextInt();
        double iptu = 0;

        if ((tipoLoteamento != 1 && tipoLoteamento != 2) || area <= 0) {
            System.out.println("Entrada inválida!");
            return;
        } else if (tipoLoteamento == 1) {
            if (area < 200) {
                iptu = area;
            } else {
                iptu = area * 1.2;
            }
        } else {
            if (area < 200) {
                iptu = area * 1.1;
            } else {
                iptu = area * 1.3;
            }
        }
        System.out.printf("%.2f", iptu);
        sc.close();
    }
}