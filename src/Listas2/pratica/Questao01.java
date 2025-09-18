package Listas2.pratica;

import java.util.Scanner;

class Emergencia {

    String nome, telefone, local, dataHora, natureza, tipo, status, feitoNoCel, coordenadas;

    public void chamarEmergencia(Scanner sc) {
        nome = sc.nextLine();
        telefone = sc.nextLine();
        local = sc.nextLine();
        dataHora = sc.nextLine();
        natureza = sc.nextLine();
        tipo = sc.nextLine();
        status = sc.nextLine();
        feitoNoCel = sc.nextLine();

        if (feitoNoCel.equalsIgnoreCase("sim")) {
            feitoNoCel = "Sim";
            coordenadas = sc.nextLine();
        } else {
            feitoNoCel = "Não";
            coordenadas = null;
        }
    }


    public void mostrarEmergencias(int quant) {
        if (quant != 1) {
            System.out.println();
        }
        System.out.println("Emergência #" + quant);
        System.out.println();
        System.out.println("--- Informações da Emergência ---");
        System.out.println();
        System.out.println("Nome do Chamador: " + nome);
        System.out.println("Telefone: " + telefone);
        System.out.println("Local da Emergência: " + local);
        System.out.println("Data/Hora do Relato: " + dataHora);
        System.out.println("Natureza da Emergência: " + natureza);
        System.out.println("Tipo de Resposta: " + tipo);
        System.out.println("Status da Resposta: " + status);
        System.out.println("Chamada via celular: " + feitoNoCel);
        if (feitoNoCel.equalsIgnoreCase("sim")) {
            System.out.println("Coordenadas GPS: " + coordenadas);
        }

    }
}

public class Questao01 {

    public static void main(String[] args) {


        //Emergencia emergencia = new Emergencia();

        Scanner sc = new Scanner(System.in);
        int quant = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= quant; i++) {
            Emergencia emergencia = new Emergencia();
            emergencia.chamarEmergencia(sc);
            emergencia.mostrarEmergencias(i);
        }
        sc.close();
    }
}