package Listas2.pratica;

import java.util.Scanner;

class Circulo {

    private int x, y, raio;
    public static final double PI = 3.14159;

    public Circulo(int x, int y, int raio) {
        this.x = x;
        this.y = y;
        this.raio = raio;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getRaio() {
        return raio;
    }

    public void setRaio(int raio) {
        this.raio = raio;
    }

    public double circunferencia() {
        return 2 * PI * raio;
    }
}

public class Questao05 {  //use modificador de acesso (public) apenas para a classe principal

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Circulo[] vetor1 = new Circulo[3];
        for (int i = 0; i < 3; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int raio = sc.nextInt();
            vetor1[i] = new Circulo(x, y, raio);
        }

        Circulo[] vetor2 = vetor1;

        Circulo[] vetor3 = new Circulo[3];
        for (int i = 0; i < 3; i++) {
            vetor3[i] = new Circulo(
                    vetor1[i].getX(),
                    vetor1[i].getY(),
                    vetor1[i].getRaio()
            );
        }

        for (int i = 0; i < 3; i++) {
            int raio = sc.nextInt();
            vetor1[i].setRaio(raio);
        }

        System.out.println("vetor1:");
        for (Circulo circulo : vetor1) {
            System.out.printf("%d %d %d\n", circulo.getX(), circulo.getY(), circulo.getRaio());
        }

        System.out.println("vetor2:");
        for (Circulo circulo : vetor2) {
            System.out.printf("%d %d %d\n", circulo.getX(), circulo.getY(), circulo.getRaio());
        }

        System.out.println("vetor3:");
        for (Circulo circulo : vetor3) {
            System.out.printf("%d %d %d\n", circulo.getX(), circulo.getY(), circulo.getRaio());
        }
    }
}
