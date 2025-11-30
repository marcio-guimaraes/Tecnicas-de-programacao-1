#include <iostream>
#include <string>
#include <vector>
#include <sstream>
#include <map>
#include <algorithm>

std::string toLower(std::string s) {
    std::transform(s.begin(), s.end(), s.begin(), 
                   [](unsigned char c){ return std::tolower(c); });
    return s;
}

int main() {
    
    int quant;
    std::cin >> quant;
    std::cin.ignore();

    std::map<std::string, std::string> dicionario;

    for (int i = 0; i < quant; i++) {
        std::string linha;
        std::getline(std::cin, linha);

        std::stringstream ss(linha);
        std::string sigla, palavra;
        
        if (ss >> sigla >> palavra) {
            dicionario[toLower(sigla)] = palavra;
        }
    }

    std::string frase;
    std::getline(std::cin, frase);

    std::stringstream ssFrase(frase);
    std::string palavraAtual;
    
    while (ssFrase >> palavraAtual) {
        
        std::string palavraMinuscula = toLower(palavraAtual);
        
        if (dicionario.count(palavraMinuscula)) {
            std::cout << dicionario[palavraMinuscula] << " ";
        } 
        else {
            std::cout << palavraAtual << " ";
        }
    }
    
    std::cout << std::endl;

    return 0;
}
