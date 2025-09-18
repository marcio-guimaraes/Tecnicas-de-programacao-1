package Listas1.pratica;

import java.util.Locale;
import java.util.Scanner;

public class Questao01 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        double A = sc.nextDouble();
        sc.nextLine();
        char sexo = sc.next().charAt(0);

        double peso_ideal = 0;

        if (A <= 0 || (sexo != 'm' && sexo != 'f')) {
            System.out.println("Entrada inválida!");
        } else {
            if (sexo == 'f') {
                peso_ideal = (62.1 * A) - 44.7;
            } else if (sexo == 'm') {
                peso_ideal = (72.7 * A) - 58;
            }

            System.out.printf("%.1f kg", peso_ideal);
        }
    }
}
