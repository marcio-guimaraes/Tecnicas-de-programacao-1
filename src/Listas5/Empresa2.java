import java.util.Locale;
import java.util.Scanner;

interface Classificavel {
    boolean menorElemento(Classificavel obj);
}

class Classificador {

    public void ordena(Classificavel[] a) {
        Classificavel elem, menor;
        int pos;

        for (int i = 0; i < a.length - 1; i++) {
            elem = a[i];
            menor = a[i + 1];
            pos = i + 1;

            for (int j = i + 2; j < a.length; j++) {
                if (a[j].menorElemento(menor)) {
                    menor = a[j];
                    pos = j;
                }
            }

            if (menor.menorElemento(elem)) {
                a[i] = a[pos];
                a[pos] = elem;
            }
        }
    }
}

class Produto implements Classificavel {
    private int codigo;
    private String nome;
    private double preco;

    public Produto(int codigo, String nome, double preco) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
    }

    @Override
    public boolean menorElemento(Classificavel obj) {
        Produto compara = (Produto) obj;
        return this.codigo < compara.codigo;
    }

    @Override
    public String toString() {
        return codigo + " " + nome + " " + preco;
    }
}

class Cliente implements Classificavel {
    private String cpf;
    private String nome;
    private String endereco;

    public Cliente(String cpf, String nome, String endereco) {
        this.cpf = cpf;
        this.nome = nome;
        this.endereco = endereco;
    }

    @Override
    public boolean menorElemento(Classificavel obj) {
        Cliente compara = (Cliente) obj;
        // Ordenar por nome em ordem alfabética
        return this.nome.compareTo(compara.nome) < 0;
    }

    @Override
    public String toString() {
        return cpf + " " + nome + " " + endereco;
    }
}

class Servico implements Classificavel {
    private String tipoServico;
    private double preco;
    private String data;

    public Servico(String tipoServico, double preco, String data) {
        this.tipoServico = tipoServico;
        this.preco = preco;
        this.data = data;
    }

    @Override
    public boolean menorElemento(Classificavel obj) {
        Servico compara = (Servico) obj;
        return this.preco < compara.preco;
    }

    @Override
    public String toString() {
        return tipoServico + " " + preco + " " + data;
    }
}

public class Empresa2 {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner entrada = new Scanner(System.in);

        Classificador classifica = new Classificador();

        int numProduto = entrada.nextInt();
        int numCliente = entrada.nextInt();
        int numServico = entrada.nextInt();

        Produto[] produtos = new Produto[numProduto];
        for (int i = 0; i < numProduto; i++) {
            produtos[i] = new Produto(entrada.nextInt(), entrada.next(), entrada.nextDouble());
        }

        Cliente[] clientes = new Cliente[numCliente];
        for (int i = 0; i < numCliente; i++) {
            clientes[i] = new Cliente(entrada.next(), entrada.next(), entrada.next());
        }

        Servico[] servicos = new Servico[numServico];
        for (int i = 0; i < numServico; i++) {
            servicos[i] = new Servico(entrada.next(), entrada.nextDouble(), entrada.next());
        }

        classifica.ordena(produtos);
        classifica.ordena(clientes);
        classifica.ordena(servicos);

        for (Produto p : produtos) System.out.println(p);
        for (Cliente c : clientes) System.out.println(c);
        for (Servico s : servicos) System.out.println(s);
    }
}
