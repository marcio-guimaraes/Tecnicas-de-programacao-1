package Listas4;

import javax.management.StandardMBean;
import java.util.List;
import java.util.ArrayList;

class Engenheiro {

    private String nome, crea;

    public Engenheiro(String nome, String crea) {
        this.nome = nome;
        this.crea = crea;
    }

    public String getNome() {
        return nome;
    }
}

class Funcionario {

    private String cargo, nome;

    public Funcionario(String nome, String cargo) {
        this.cargo = cargo;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}

class Tarefa {

    private String descricao;
    private String data;
    private float qtDeHoras;

    Funcionario funcionario;

    public Tarefa(String descricao, String data, float qtDeHoras, Funcionario funcionario) {
        this.descricao = descricao;
        this.data = data;
        this.qtDeHoras = qtDeHoras;
        this.funcionario = funcionario;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setQtDeHoras(int qtDeHoras) {
        this.qtDeHoras = (float) qtDeHoras;
    }

    public String getData() {
        return data;
    }

    public float getQtDeHoras() {
        return qtDeHoras;
    }
}

class Projeto {

    private String nome, status, dataInicio, dataFim;

    private Engenheiro engenheiro;
    private List<Tarefa> tarefas = new ArrayList<>();

    public Projeto(String nome, String status, String dataInicio, String dataFim, Engenheiro engenheiro) {
        this.nome = nome;
        this.status = status;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.engenheiro = engenheiro;
    }

    public void adicionarTarefa(String descricao, String data, int horas, Funcionario funcionario) {
        Tarefa novaTarefa = new Tarefa(descricao, data, horas, funcionario);
        tarefas.add(novaTarefa);
    }

    public int calcularHorasTotal() {
        int total = 0;
        for (Tarefa t : tarefas) {
            total += (int)t.getQtDeHoras();
        }
        return total;
    }


    public List<Tarefa> getTarefasPorData(String data) {
        List<Tarefa> tarefaDaData = new ArrayList<>();
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getData().equals(data)) {
                tarefaDaData.add(tarefa);
            }
        }
        return tarefaDaData;
    }

    public List<Tarefa> getTarefasPorFuncionario(Funcionario funcionario) {
        List<Tarefa> tarefaDoFuncionario = new ArrayList<>();
        int j = 0;
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getFuncionario().equals(funcionario)) {
                tarefaDoFuncionario.add(tarefa);
            }
        }

        return tarefaDoFuncionario;
    }

    public void mostrarProjeto() {

        System.out.println("------ PROJETO ------");
        System.out.println("Nome: " + nome);
        System.out.println("Status: " + status);
        System.out.println("Início: " + dataInicio);

        if (status.equals("Finalizado")) {
            System.out.println("Término: " + dataFim);
        } else {
            System.out.println("Término: em aberto");
        }

        System.out.println("Engenheiro Responsável: " + engenheiro.getNome());
        System.out.println("Total de Tarefas: " + tarefas.toArray().length);
        System.out.println("Horas Totais: " + calcularHorasTotal());

    }

    public String getNome() {
        return nome;
    }
}

public class DesenvolvimentoDeProjetos {

    public static void main(String[] args) {

        //Engenheiros
        Engenheiro eng1 = new Engenheiro("Mariana Lopes", "DF001122");
        Engenheiro eng2 = new Engenheiro("Roberto Silva", "SP334455");
        Engenheiro eng3 = new Engenheiro("Fernanda Alves", "RJ556677");

        //Funcionários
        Funcionario func1 = new Funcionario("Lucas", "Desenvolvedor");
        Funcionario func2 = new Funcionario("Juliana", "Analista de Sistemas");
        Funcionario func3 = new Funcionario("Paulo", "Engenheiro de Software");
        Funcionario func4 = new Funcionario("Renata", "Testadora");

        //Lista geral de projetos
        List<Projeto> projetos = new ArrayList<>();

        //Projetos
        Projeto projeto1 = new Projeto("Sistema de Controle Acadêmico", "Em desenvolvimento", "01/05/2025", null, eng1);
        projeto1.adicionarTarefa("Modelagem de dados", "02/05/2025", 5, func2);
        projeto1.adicionarTarefa("Backend", "03/05/2025", 8, func1);
        projeto1.adicionarTarefa("Integração", "04/05/2025", 6, func2);
        projetos.add(projeto1);

        Projeto projeto2 = new Projeto("Aplicativo de Saúde", "Planejamento", "05/05/2025", null, eng2);
        projeto2.adicionarTarefa("Requisitos", "05/05/2025", 4, func3);
        projeto2.adicionarTarefa("Protótipo", "06/05/2025", 7, func4);
        projetos.add(projeto2);

        Projeto projeto3 = new Projeto("Plataforma de E-commerce", "Finalizado", "01/04/2025", "30/04/2025", eng1);
        projeto3.adicionarTarefa("API de produtos", "10/04/2025", 6, func1);
        projeto3.adicionarTarefa("Testes automatizados", "15/04/2025", 5, func4);
        projetos.add(projeto3);

        //Exibir todos os projetos
        for (Projeto projeto : projetos) {
            projeto.mostrarProjeto();
            System.out.println();
        }

        //Buscar tarefas de Juliana
        System.out.println("Tarefas de " + func2.getNome());
        for (Projeto projeto : projetos) {
            for (Tarefa tarefa : projeto.getTarefasPorFuncionario(func2)) {
                System.out.println("Projeto: " + projeto.getNome());
                System.out.println("Nome da Tarefa: " + tarefa.getDescricao() + ", Data: " + tarefa.getData());
                System.out.println();
            }
        }

        //Buscar tarefas por data
        String dataBusca = "06/05/2025";
        System.out.println("Tarefas na data " + dataBusca);
        for (Projeto projeto : projetos) {
            for (Tarefa tarefa : projeto.getTarefasPorData(dataBusca)) {
                System.out.println("Projeto: " + projeto.getNome());
                System.out.println("Nome da Tarefa: " + tarefa.getDescricao() + ", Funcionário: " + tarefa.getFuncionario().getNome());
                System.out.println();
            }
        }

    }

}



