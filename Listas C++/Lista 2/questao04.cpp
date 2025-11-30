#include <iostream>
#include <string>
#include <iomanip>
#include <locale>

class Conta {
private:
    int numConta;
    int senha;
    std::string nome;
    double saldo;

public:
    Conta(int numConta, int senha, std::string nome, double saldo) : 
        numConta(numConta), senha(senha), nome(nome), saldo(saldo) {}

    int getNumConta() const {
        return numConta;
    }

    std::string getNome() const {
        return nome;
    }

    double getSaldo(int senha) const {
        if (senha == this->senha) {
            return saldo;
        }
        return -1;
    }

    bool sacar(double valorSaque, int senha) {
        if (senha == this->senha && valorSaque > 0 && valorSaque <= this->saldo) {
            this->saldo -= valorSaque;
            return true;
        }
        return false;
    }

    bool depositar(double valorDeposito, int senha) {
        if (senha == this->senha && valorDeposito > 0) {
            this->saldo += valorDeposito;
            return true;
        }
        return false;
    }

    bool tranferir(double valor, int senha, Conta& conta2) {
        if (senha == this->senha && valor > 0 && valor <= this->saldo) {
            this->saldo -= valor;
            conta2.saldo += valor; 
            return true;
        }
        return false;
    }
};

int main() {
    
    std::cout.imbue(std::locale("C"));

    int numConta1, senhaConta1;
    std::string nomeCliente1;
    double saldoInicial1;

    std::cin >> numConta1 >> senhaConta1 >> nomeCliente1 >> saldoInicial1;
    Conta c1(numConta1, senhaConta1, nomeCliente1, saldoInicial1);

    int numConta2, senhaConta2;
    std::string nomeCliente2;
    double saldoInicial2;

    std::cin >> numConta2 >> senhaConta2 >> nomeCliente2 >> saldoInicial2;
    Conta c2(numConta2, senhaConta2, nomeCliente2, saldoInicial2);

    int opcao;
    while (std::cin >> opcao) {
        if (opcao == 5) {
            break;
        }

        switch (opcao) {
            case 1: { // Mostrar Saldo (Conta c1)
                int senha;
                std::cin >> senha; 
                double saldo = c1.getSaldo(senha);
                if (saldo == -1) {
                    std::cout << "senha incorreta" << std::endl;
                } else {
                    std::cout << std::fixed << std::setprecision(2) << saldo << std::endl;
                }
                break;
            }
            case 2: { // Sacar (Conta c1)
                double valorSaque;
                int senha;
                std::cin >> valorSaque >> senha;

                if (c1.sacar(valorSaque, senha)) {
                    std::cout << "saque realizado" << std::endl;
                } else {
                    std::cout << "saque não realizado" << std::endl;
                }
                break;
            }
            case 3: { // Depositar (Conta c1)
                double valorDeposito;
                int senha;
                std::cin >> valorDeposito >> senha;

                if (c1.depositar(valorDeposito, senha)) {
                    std::cout << "depósito realizado" << std::endl;
                } else {
                    std::cout << "depósito não realizado" << std::endl;
                }
                break;
            }
            case 4: { // Transferir (c1 para c2)
                std::string nomeDestino;
                std::cin >> nomeDestino;
                
                if (nomeDestino == c2.getNome()) {
                    double valorTransferencia;
                    int senha;
                    std::cin >> valorTransferencia >> senha; 
                    if (c1.tranferir(valorTransferencia, senha, c2)) {
                        std::cout << "transferência realizada" << std::endl;
                    } else {
                        std::cout << "transferência não realizada" << std::endl;
                    }
                } else {
                    std::cout << "nenhum usuário encontrado" << std::endl;
                }
                break;
            }
        }
    }
    
    return 0;
}