package Listas2.pratica;

import java.util.Scanner;

class Temperatura {
    private double temperatura;

    public Temperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public void celciusToFahreinheit() {
        temperatura = temperatura * 9.0 / 5.0 + 32;
    }

    public void fahreinheitToCelcius() {
        temperatura = (temperatura - 32) * 5.0 / 9.0;
    }

    public String toString() {
        return String.format("temperatura: %.1f graus", temperatura);
    }
}

public class Questao03 {  //use modificador de acesso (public) apenas para a classe principal

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double temperatura = sc.nextDouble();

        Temperatura t1 = new Temperatura(temperatura);

        t1.celciusToFahreinheit();
        System.out.println(t1.toString() + " fahrenheit");
        t1.fahreinheitToCelcius();
        System.out.println(t1.toString() + " celsius");
    }
}