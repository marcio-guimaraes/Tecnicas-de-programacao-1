package Listas4;

import java.util.ArrayList;
import java.util.List;

class Cliente {
    private String cpf;
    private String nome;

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
    public String getCpf() {
        return cpf;
    }

    public Cliente(String cpf, String nome){
        this.cpf = cpf;
        this.nome = nome;
    }
}

class Motorista {

    private String nome;
    private String cnh;

    public String getNome(){
        return nome;
    }
    public String getCnh() {
        return cnh;
    }

    public Motorista(String nome, String cnh){
        this.nome = nome;
        this.cnh = cnh;
    }
}

class Veiculo {

    private String modelo;
    private String placa;

    public String getModelo() {
        return modelo;
    }
    public String getPlaca() {
        return placa;
    }

    public Veiculo(String modelo, String placa){
        this.modelo = modelo;
        this.placa = placa;
    }

    @Override
    public String toString() {
        return "Modelo: " + this.modelo + ", Placa: " + this.placa;
    }
}

enum TipoChamado {
    CORRIDA(3.59),
    VIAGEM(6.51);

    private final double tipo;

    TipoChamado(double tipo){
        this.tipo = tipo;
    }

    public double getTipo() {
        return tipo;
    }
}

class Chamado {

    private static int contadorChamados = 100;
    private int codigoChamado;
    private String data;
    private String origem;
    private String destino;
    private String horaPartida;
    private String horaChegada;
    private double kmInicial;
    private double kmFinal;
    private double valorTotal;
    private boolean finalizou;
    private double distancia;

    private Cliente cliente;
    private Motorista motorista;
    private Veiculo veiculo;
    private TipoChamado tipo;

    public Chamado(TipoChamado tipo, String data, String origem, String destino, String horaPartida, double kmInicial, Veiculo veiculo, Motorista motorista, Cliente cliente) {
        this.codigoChamado = contadorChamados++;
        this.tipo = tipo;
        this.data = data;
        this.origem = origem;
        this.destino = destino;
        this.horaPartida = horaPartida;
        this.kmInicial = kmInicial;
        this.veiculo = veiculo;
        this.motorista = motorista;
        this.cliente = cliente;
        this.valorTotal = 0;
        this.finalizou = false;
    }

    public Chamado(TipoChamado tipo, String data, String origem, String destino, String horaPartida, String horaChegada, double kmInicial, double kmFinal, Veiculo veiculo, Motorista motorista, Cliente cliente) {
        this.codigoChamado = contadorChamados++;
        this.tipo = tipo;
        this.data = data;
        this.origem = origem;
        this.destino = destino;
        this.horaPartida = horaPartida;
        this.kmInicial = kmInicial;
        this.veiculo = veiculo;
        this.motorista = motorista;
        this.cliente = cliente;
        this.valorTotal = 0;
        this.finalizou = false;
        finalizarChamado(horaChegada, kmFinal);
    }


    public void finalizarChamado(String horaChegada, double kmFinal){
        this.horaChegada = horaChegada;
        this.kmFinal = kmFinal;
        this.finalizou = true;
        this.valorTotal = calcularValorTotal();
        this.distancia = calcularDistancia();
    }

    private boolean isFinalizado(){
        return this.finalizou;
    }

    private double calcularDistancia(){
        return kmFinal - kmInicial;
    }

    public void setMotorista(Motorista motorista){
        this.motorista = motorista;
    }

    private double calcularValorTotal(){
        return calcularDistancia() * this.tipo.getTipo();
    }

    public void mostrarChamado() {
        System.out.println("Chamado: " + this.codigoChamado);
        System.out.println("Data: " + this.data);
        System.out.println("Tipo: " + this.tipo);
        System.out.println("Cliente: " + this.cliente.getNome() + " (CPF: " + this.cliente.getCpf() + ")");
        System.out.println("Motorista: " + this.motorista.getNome() + " (CNH: " + this.motorista.getCnh() + ")");
        System.out.println("Veículo: " + this.veiculo.getModelo() + " (Placa: " + this.veiculo.getPlaca() + ")");
        System.out.println("Origem: " + this.origem);
        System.out.println("Destino: " + this.destino);
        System.out.println("Partida: " + this.horaPartida);

        if (isFinalizado()) {
            System.out.println("Chegada: " + this.horaChegada);
            System.out.println(String.format("Distância: %.1f km", distancia));
            System.out.println(String.format("Valor total: R$ %.2f", valorTotal));
        } else {
            System.out.println("Chegada: Aguardando finalização...");
        }
    }
}

public class SistemaTaxi {

    public static void main(String[] args) {

        Cliente cliente1 = new Cliente("12345678901", "João");
        Cliente cliente2 = new Cliente("98765432100", "Maria");
        Cliente cliente3 = new Cliente("55544433322", "Carlos");

        Motorista motorista1 = new Motorista("Carlos Silva", "1234567890");
        Motorista motorista2 = new Motorista("José Souza", "0987654321");
        Motorista motorista3 = new Motorista("Ana Costa", "1122334455");

        Veiculo veiculo1 = new Veiculo("Fiat Uno", "ABC1D23");
        Veiculo veiculo2 = new Veiculo("Volkswagen Gol", "XYZ9A87");
        Veiculo veiculo3 = new Veiculo("Chevrolet Onix", "LMN5P32");

        cliente1.setNome("João da Silva Santos");

        System.out.println("Motorista 2: " + motorista2.getNome() + "\n");

        System.out.println("Veículo 3: " + veiculo3 + "\n");

        List<Chamado> chamados = new ArrayList<>();

        Chamado chamado1 = new Chamado(TipoChamado.CORRIDA, "01/05/2025", "Setor Comercial Sul", "Asa Norte", "14:00", "14:30", 1234, 1241, veiculo3, motorista3, cliente3);
        chamados.add(chamado1);

        Chamado chamado2 = new Chamado(TipoChamado.CORRIDA, "01/05/2025", "Asa Norte", "Praça dos Três Poderes", "15:00", "15:20", 1242, 1251, veiculo3, motorista3, cliente1);
        chamados.add(chamado2);

        Chamado chamado3 = new Chamado(TipoChamado.VIAGEM, "01/05/2025", "Asa Sul", "Formosa", "15:30", "17:00", 2000, 2075, veiculo1, motorista1, cliente2);
        chamados.add(chamado3);

        Chamado chamado4 = new Chamado(TipoChamado.CORRIDA, "05/05/2025", "Taguatinga", "Shopping Conjunto Nacional", "13:00", 3050, veiculo1, motorista1, cliente2);
        chamados.add(chamado4);

        Chamado chamado5 = new Chamado(TipoChamado.CORRIDA, "05/05/2025", "Estádio Mané Garrincha", "Shopping ParkShopping", "12:00", 1000, veiculo2, motorista1, cliente1);
        chamados.add(chamado5);

        chamado5.setMotorista(motorista3);

        Chamado chamado6 = new Chamado(TipoChamado.VIAGEM, "05/05/2025", "Cruzeiro", "Planaltina", "11:00", 1270, veiculo3, motorista2, cliente3);
        chamados.add(chamado6);

        chamado6.finalizarChamado("12:10", 1315);

        for (Chamado chamado : chamados) {
            chamado.mostrarChamado();
            System.out.println();
        }
    }
}