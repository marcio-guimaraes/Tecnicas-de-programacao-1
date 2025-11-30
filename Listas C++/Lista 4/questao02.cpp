#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

class Engenheiro {
private:
    std::string nome;
    std::string crea;

public:
    Engenheiro(std::string nome, std::string crea) : nome(nome), crea(crea) {}

    std::string getNome() const {
        return nome;
    }
};

class Funcionario {
private:
    std::string cargo;
    std::string nome;

public:
    Funcionario(std::string nome, std::string cargo) : cargo(cargo), nome(nome) {}

    std::string getNome() const {
        return nome;
    }
};

class Tarefa {
private:
    std::string descricao;
    std::string data;
    float qtDeHoras;
    Funcionario* funcionario;

public:
    Tarefa(std::string descricao, std::string data, float qtDeHoras, Funcionario* funcionario)
        : descricao(descricao), data(data), qtDeHoras(qtDeHoras), funcionario(funcionario) {}

    Funcionario* getFuncionario() const {
        return funcionario;
    }

    std::string getDescricao() const {
        return descricao;
    }

    void setQtDeHoras(int qtDeHoras) {
        this->qtDeHoras = (float)qtDeHoras;
    }

    std::string getData() const {
        return data;
    }

    float getQtDeHoras() const {
        return qtDeHoras;
    }
};

class Projeto {
private:
    std::string nome;
    std::string status;
    std::string dataInicio;
    std::string dataFim;
    Engenheiro* engenheiro;
    std::vector<Tarefa> tarefas;

public:
    Projeto(std::string nome, std::string status, std::string dataInicio, std::string dataFim, Engenheiro* engenheiro)
        : nome(nome), status(status), dataInicio(dataInicio), dataFim(dataFim), engenheiro(engenheiro) {}

    void adicionarTarefa(std::string descricao, std::string data, int horas, Funcionario* funcionario) {
        tarefas.emplace_back(descricao, data, (float)horas, funcionario);
    }

    int calcularHorasTotal() const {
        int total = 0;
        for (const auto& t : tarefas) {
            total += (int)t.getQtDeHoras();
        }
        return total;
    }

    std::vector<Tarefa> getTarefasPorData(std::string data) const {
        std::vector<Tarefa> tarefaDaData;
        for (const auto& tarefa : tarefas) {
            if (tarefa.getData() == data) {
                tarefaDaData.push_back(tarefa);
            }
        }
        return tarefaDaData;
    }

    std::vector<Tarefa> getTarefasPorFuncionario(Funcionario* funcionario) const {
        std::vector<Tarefa> tarefaDoFuncionario;
        for (const auto& tarefa : tarefas) {
            if (tarefa.getFuncionario() == funcionario) {
                tarefaDoFuncionario.push_back(tarefa);
            }
        }
        return tarefaDoFuncionario;
    }

    void mostrarProjeto() const {
        std::cout << "------ PROJETO ------" << std::endl;
        std::cout << "Nome: " << nome << std::endl;
        std::cout << "Status: " << status << std::endl;
        std::cout << "Início: " << dataInicio << std::endl;

        if (status == "Finalizado") {
            std::cout << "Término: " << dataFim << std::endl;
        } else {
            std::cout << "Término: em aberto" << std::endl;
        }

        std::cout << "Engenheiro Responsável: " << engenheiro->getNome() << std::endl;
        std::cout << "Total de Tarefas: " << tarefas.size() << std::endl;
        std::cout << "Horas Totais: " << calcularHorasTotal() << std::endl;
    }

    std::string getNome() const {
        return nome;
    }
};

int main() {
    
    Engenheiro eng1("Mariana Lopes", "DF001122");
    Engenheiro eng2("Roberto Silva", "SP334455");
    Engenheiro eng3("Fernanda Alves", "RJ556677");

    Funcionario func1("Lucas", "Desenvolvedor");
    Funcionario func2("Juliana", "Analista de Sistemas");
    Funcionario func3("Paulo", "Engenheiro de Software");
    Funcionario func4("Renata", "Testadora");

    std::vector<Projeto> projetos;

    projetos.emplace_back("Sistema de Controle Acadêmico", "Em desenvolvimento", "01/05/2025", "", &eng1);
    projetos.back().adicionarTarefa("Modelagem de dados", "02/05/2025", 5, &func2);
    projetos.back().adicionarTarefa("Backend", "03/05/2025", 8, &func1);
    projetos.back().adicionarTarefa("Integração", "04/05/2025", 6, &func2);

    projetos.emplace_back("Aplicativo de Saúde", "Planejamento", "05/05/2025", "", &eng2);
    projetos.back().adicionarTarefa("Requisitos", "05/05/2025", 4, &func3);
    projetos.back().adicionarTarefa("Protótipo", "06/05/2025", 7, &func4);

    projetos.emplace_back("Plataforma de E-commerce", "Finalizado", "01/04/2025", "30/04/2025", &eng1);
    projetos.back().adicionarTarefa("API de produtos", "10/04/2025", 6, &func1);
    projetos.back().adicionarTarefa("Testes automatizados", "15/04/2025", 5, &func4);

    for (const auto& projeto : projetos) {
        projeto.mostrarProjeto();
        std::cout << std::endl;
    }

    std::cout << "Tarefas de " << func2.getNome() << std::endl;
    for (const auto& projeto : projetos) {
        for (const auto& tarefa : projeto.getTarefasPorFuncionario(&func2)) {
            std::cout << "Projeto: " << projeto.getNome() << std::endl;
            std::cout << "Nome da Tarefa: " << tarefa.getDescricao() << ", Data: " << tarefa.getData() << std::endl;
            std::cout << std::endl;
        }
    }

    std::string dataBusca = "06/05/2025";
    std::cout << "Tarefas na data " << dataBusca << std::endl;
    for (const auto& projeto : projetos) {
        for (const auto& tarefa : projeto.getTarefasPorData(dataBusca)) {
            std::cout << "Projeto: " << projeto.getNome() << std::endl;
            std::cout << "Nome da Tarefa: " << tarefa.getDescricao() << ", Funcionário: " << tarefa.getFuncionario()->getNome() << std::endl;
            std::cout << std::endl;
        }
    }

    return 0;
}