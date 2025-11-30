#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <locale>

int main() {
    
    std::cin.imbue(std::locale("C"));
    
    int n;
    std::cin >> n;
    std::cin.ignore();

    std::vector<std::string> palavras(n);

    for (int i = 0; i < n; i++) {
        std::getline(std::cin, palavras[i]);
    }

    std::string palavraProcurada;
    std::getline(std::cin, palavraProcurada);

    for (int i = 0; i < n; i++) {
        
        if (palavraProcurada == palavras[i]) {
            std::cout << "palavra correta" << std::endl;
            return 0;
        } 
        else if (palavraProcurada.length() == palavras[i].length() && (palavraProcurada.length() > 0 && (palavraProcurada[0] == palavras[i][0] || palavraProcurada[0] == palavras[i][1]))) {
            
            for (size_t j = 0; j < palavraProcurada.length() - 1; j++) {

                std::string tentativa = palavraProcurada;
                std::swap(tentativa[j], tentativa[j + 1]);

                if (tentativa == palavras[i]) {
                    std::cout << "palavra incorreta" << std::endl;
                    std::cout << palavras[i] << "?" << std::endl;
                    return 0;
                }
            }
        }
    }
    
    std::cout << "palavra incorreta" << std::endl;
    std::cout << "nenhuma sugestão" << std::endl;
    
    return 0;
}