package Listas2.pratica;

import java.util.Scanner;

class Retangulo {
    private int largura = 1;
    private int comprimento = 1;

    public int perimetro() {
        return 2 * (comprimento + largura);
    }

    public int area() {
        return comprimento * largura;
    }

    public int getLargura() {
        return largura;
    }

    public int getComprimento() {
        return comprimento;
    }

    public void setLargura(int largura) {
        if (largura > 0 && largura < 20) {
            this.largura = largura;
        }
    }

    public void setComprimento(int comprimento) {
        if (comprimento > 0 && comprimento < 20) {
            this.comprimento = comprimento;
        }
    }
}

public class Questao02 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Retangulo r1 = new Retangulo();
        int comprimento1 = sc.nextInt();
        int largura1 = sc.nextInt();
        r1.setComprimento(comprimento1);
        r1.setLargura(largura1);

        Retangulo r2 = new Retangulo();
        int comprimento2 = sc.nextInt();
        int largura2 = sc.nextInt();
        r2.setComprimento(comprimento2);
        r2.setLargura(largura2);

        sc.close();


        int comprimento, largura, perimetro, area;
        comprimento = r1.getComprimento();
        largura = r1.getLargura();
        perimetro = r1.perimetro();
        area = r1.area();

        System.out.printf("%d %d %d %d", comprimento, largura, perimetro, area);

        comprimento = r2.getComprimento();
        largura = r2.getLargura();
        perimetro = r2.perimetro();
        area = r2.area();

        System.out.printf("%d %d %d %d", comprimento, largura, perimetro, area);

    }
}