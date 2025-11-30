#include <iostream>
#include <string>
#include <stdexcept>

class Funcionario {
    std::string nomeFuncionario;
    int qtdeProducao;
    int horasTrabalhadas;

public:
    Funcionario(std::string nomeFuncionario, int qtdeProducao, int horasTrabalhadas) {
        this->nomeFuncionario = nomeFuncionario;
        this->qtdeProducao = qtdeProducao;
        this->horasTrabalhadas = horasTrabalhadas;
    }

    int calcularProdutividade() {
        if (horasTrabalhadas == 0) {
            throw std::runtime_error("ArithmeticException");
        }
        return qtdeProducao / horasTrabalhadas;
    }
};

int main() {
    try {
        std::string nome;
        std::getline(std::cin, nome);

        int producao, horas;
        
        if (!(std::cin >> producao)) throw std::exception();
        if (!(std::cin >> horas)) throw std::exception();

        Funcionario funcionario(nome, producao, horas);
        int produtividade = funcionario.calcularProdutividade();

        std::cout << "Produtividade: " << produtividade << " peças por hora" << std::endl;

    } catch (const std::runtime_error& e) {
        std::cout << "Erro: horas trabalhadas não podem ser zero." << std::endl;
    } catch (const std::exception& e) {
        std::cout << "Erro inesperado" << std::endl;
    }

    return 0;
}