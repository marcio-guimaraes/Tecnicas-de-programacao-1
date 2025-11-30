#include <iostream>
#include <string>
#include <stdexcept>
#include <iomanip>
#include <locale>

class DepositoInvalidoException : public std::runtime_error {
public:
    DepositoInvalidoException(const std::string& mensagemErro) : std::runtime_error(mensagemErro) {}
};

class Conta {
private:
    int agencia;
    int numero;
    double saldo;
    static constexpr double LIMITE_DEPOSITO = 10000.0;

public:
    Conta(int agencia, int numero) {
        this->agencia = agencia;
        this->numero = numero;
        this->saldo = 0.0;
    }

    double getSaldo() const {
        return saldo;
    }

    static double getLimiteDeposito() {
        return LIMITE_DEPOSITO;
    }

    void depositaPersonalizado(double valor) {
        if (valor <= 0) {
            throw DepositoInvalidoException("Valor inválido para depósito");
        } else if (valor > LIMITE_DEPOSITO) {
            throw DepositoInvalidoException("Valor acima do limite permitido de 10000.00");
        } else {
            this->saldo = valor;
        }
    }
};

int main() {
    std::cout.imbue(std::locale("C"));

    int agencia, numero;
    std::cin >> agencia >> numero;

    double valorDeposito = 0;
    Conta cont1(agencia, numero);

    try {
        std::cin >> valorDeposito;
        cont1.depositaPersonalizado(valorDeposito);
        std::cout << "Depósito realizado com sucesso." << std::endl;
    } catch (const DepositoInvalidoException& e) {
        std::cout << "Erro: " << e.what() << std::endl;
    }

    double saldo = cont1.getSaldo();
    
    std::cout << std::fixed << std::setprecision(2);

    if (valorDeposito <= 0 || valorDeposito > 10000) {
        std::cout << "Valor " << valorDeposito << " incorreto. Saldo atual: " << saldo << std::endl;
    } else {
        std::cout << "Valor " << valorDeposito << " depositado na conta. Novo saldo: " << saldo << std::endl;
    }

    return 0;
}