import java.sql.SQLOutput;
import java.util.Scanner;

//Classes
class Funcionario{
    private String nome;
    private String dataDeNascimento;
    private float salario;

    public Funcionario(){}
    public Funcionario(String nome, String dataDeNascimento, float salario){
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
        this.salario = salario;
    }

    // Getters
    public String getNome() {return nome;}
    public String getDataDeNascimento() {return dataDeNascimento;}
    public float getSalario() {return salario;}

    //Setters
    public void setNome(String nome) {this.nome = nome;}
    public void setDataDeNascimento(String dataDeNascimento) {this.dataDeNascimento = dataDeNascimento;}
    public void setSalario(float salario) {this.salario = salario;}
}

class Chefe extends Funcionario{
    private String departamento;

    public Chefe(){}
    public Chefe(String nome, String dataDeNascimento, float salario, String departamento){
        super(nome, dataDeNascimento, salario);
        this.departamento = departamento;
    }

    // Get Set
    public String getDepartamento() {return departamento;}
    public void setDepartamento(String departamento) {this.departamento = departamento;}
}

class Vendedor extends Funcionario{
    private float comissaoVenda;
    private int quantidadeVendas;

    public Vendedor(){}
    public Vendedor(String nome, String dataDeNascimento, float salario, float comissaoVenda, int quantidadeVendas){
        super(nome, dataDeNascimento, salario);
        this.comissaoVenda = comissaoVenda;
        this.quantidadeVendas = quantidadeVendas;
    }

    // Getters Setters
    public float getComissaoVenda() {return comissaoVenda;}
    public void setComissaoVenda(float comissaoVenda) {this.comissaoVenda = comissaoVenda;}
    public int getQuantidadeVendas() {return quantidadeVendas;}
    public void setQuantidadeVendas(int quantidadeVendas) {this.quantidadeVendas = quantidadeVendas;}
}

class Operario extends Funcionario{
    private float valorProducao;
    private int quantidadeProduzida;

    public Operario() {super();}
    public Operario(String nome, String dataDeNascimento, float salario, float valorProducao, int quantidadeProduzida) {
        super(nome, dataDeNascimento, salario);
        this.valorProducao = valorProducao;
        this.quantidadeProduzida = quantidadeProduzida;
    }

    // Getters Setters
    public float getValorProducao() {return valorProducao;}
    public void setValorProducao(float valorProducao) {this.valorProducao = valorProducao;}
    public int getQuantidadeProduzida() {return quantidadeProduzida;}
    public void setQuantidadeProduzida(int quantidadeProduzida) {this.quantidadeProduzida = quantidadeProduzida;}
}

class Horista extends Funcionario{
    private float valorHora;
    private int totalHora;

    public Horista() {super();}
    public Horista(String nome, String dataDeNascimento, float salario, float valorHora, int totalHora) {
        super(nome, dataDeNascimento, salario);
        this.valorHora = valorHora;
        this.totalHora = totalHora;
    }

    // Getters e Setters
    public float getValorHora() { return valorHora; }
    public void setValorHora(float valorHora) { this.valorHora = valorHora; }
    public int getTotalHora() { return totalHora; }
    public void setTotalHora(int totalHora) { this.totalHora = totalHora; }

}

class FolhaPagamento{
    public void mostrarPagamentos(String nome, String cidade, String mes, Funcionario[] funcionarios){

        System.out.println("Nome da Empresa: " + nome);
        System.out.println("Endereço: " + cidade);
        System.out.println("Mês: " + mes);

        for (Funcionario fun: funcionarios){
            System.out.println();
            System.out.println("Nome: " + fun.getNome());
            System.out.println("Data de Nascimento: " + fun.getDataDeNascimento());

            if (fun instanceof Chefe) {
                Chefe c = (Chefe) fun;
                System.out.println("Salário: R$" + c.getSalario());
                System.out.println("Departamento: " + c.getDepartamento());
                System.out.println("Cargo: chefe");
            }
            else if (fun instanceof Vendedor) {
                Vendedor v = (Vendedor) fun;
                System.out.println("Salário: R$" + (fun.getSalario() + v.getComissaoVenda() * v.getQuantidadeVendas()));
                System.out.println("Cargo: vendedor");
                System.out.println("Comissão por Venda: R$" + v.getComissaoVenda());
                System.out.println("Número de vendas: " + v.getQuantidadeVendas());
            }
            else if (fun instanceof Operario) {
                Operario o = (Operario) fun;
                System.out.println("Salário: R$" + (o.getQuantidadeProduzida() * o.getValorProducao()));
                System.out.println("Cargo: Operário");
                System.out.println("Valor por Produção: R$" + o.getValorProducao());
                System.out.println("Quantidade produzida: " + o.getQuantidadeProduzida());
            }
            else if (fun instanceof Horista) {
                Horista h = (Horista) fun;
                System.out.println("Salário: R$" + (h.getTotalHora() * h.getValorHora()));
                System.out.println("Cargo: horista");
                System.out.println("Valor por Hora: R$" + h.getValorHora());
                System.out.println("Total de horas: " + h.getTotalHora());
            }
        }
    }
}

//Classe principal
public class Empresa {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        Funcionario[] funcionarios = new Funcionario[4];

        String nome = entrada.next();
        String cidade = entrada.next();
        String mes = entrada.next();

        funcionarios[0] = new Chefe(entrada.next(), entrada.next(), entrada.nextFloat(), entrada.next());
        funcionarios[1] = new Vendedor(entrada.next(), entrada.next(), entrada.nextFloat(), entrada.nextFloat(), entrada.nextInt());
        funcionarios[2] = new Operario(entrada.next(), entrada.next(), entrada.nextFloat(), entrada.nextFloat(), entrada.nextInt());
        funcionarios[3] = new Horista(entrada.next(), entrada.next(), entrada.nextFloat(), entrada.nextFloat(), entrada.nextInt());

        FolhaPagamento folha = new FolhaPagamento();
        folha.mostrarPagamentos(nome, cidade, mes, funcionarios);

    }

}