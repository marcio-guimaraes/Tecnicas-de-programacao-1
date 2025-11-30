#include <iostream>
#include <vector>
#include <string>
#include <utility>

int main() {
    
    int n;
    std::cin >> n;

    std::vector<std::pair<std::string, int>> estoque(n);

    for (int i = 0; i < n; ++i) {
        std::cin >> estoque[i].first;
        std::cin >> estoque[i].second;
    }

    std::string produtoDesejado;
    int quantidadeDesejada = 0;

    while (std::cin >> produtoDesejado) {
        if (produtoDesejado == "fim") {
            for (int i = 0; i < n; ++i) {
                std::cout << estoque[i].first << " " << estoque[i].second << "\n";
            }
            return 0;
        }

        bool encontrouProduto = false;
        for (int i = 0; i < n; ++i) {
            if (produtoDesejado == estoque[i].first) {
                encontrouProduto = true;
                std::cin >> quantidadeDesejada;
                std::cout << produtoDesejado << " " << quantidadeDesejada << std::endl;
                
                estoque[i].second -= quantidadeDesejada;
                
                break;
            }
        }

        if (!encontrouProduto) {
            std::cout << produtoDesejado << " produto não encontrado" << std::endl;
        }
    }

    return 0;
}