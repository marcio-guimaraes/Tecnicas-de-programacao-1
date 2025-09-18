package Listas1.pratica;

import java.util.Locale;
import java.util.Scanner;

public class Questao02 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        double consumo = sc.nextDouble();
        double tarifa_total = 0, tarifa_basica = 5;

        if (consumo <= 500) {
            tarifa_total = tarifa_basica + consumo * 0.02;
        }
        else if (consumo <= 1000) {
            tarifa_total = tarifa_basica + 50 + (consumo - 500) * 0.05;
        }
        else if (consumo > 1000) {
            tarifa_total = tarifa_basica + 350 + (consumo - 1000) * 0.1;
        }
        System.out.printf("%.2f %.2f %.2f", (tarifa_total - tarifa_basica), tarifa_basica, tarifa_total);

        sc.close();
    }

}