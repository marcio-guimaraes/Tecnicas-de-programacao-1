#include <iostream>
#include <string>
#include <cctype>
#include <stdexcept>

class ValidarSenha {
    std::string senha;

public:
    ValidarSenha(std::string senha) {
        this->senha = senha;
    }

    void verificarMaiusculas() {
        for (char c : this->senha) {
            if (std::isupper(c)) {
                return;
            }
        }
        throw std::invalid_argument("Erro: a senha deve conter pelo menos uma letra maiúscula");
    }
};

int main() {
    std::string entrada;
    
    while (true) {
        if (!std::getline(std::cin, entrada)) {
            break;
        }

        try {
            ValidarSenha senha1(entrada);
            senha1.verificarMaiusculas();
            std::cout << "Senha válida" << std::endl;
            break;
        } catch (const std::invalid_argument& e) {
            std::cout << e.what() << std::endl;
        }
    }

    return 0;
}