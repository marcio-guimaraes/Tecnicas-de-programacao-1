package Listas1.arquivos;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Questao01 {
    public static void main(String[] args) throws IOException {

        ArrayList<Integer> votos = new ArrayList<>();

        File arquivo = new File("votos.txt");
        Scanner leitor = new Scanner(arquivo);

        while (leitor.hasNextInt()) {
            votos.add(leitor.nextInt());
        }
        leitor.close();

        for (int i = 0; i < votos.size(); i++) {
            System.out.println("Time " + (i + 1) + ": " + votos.get(i) + " votos");
        }
    }
}
