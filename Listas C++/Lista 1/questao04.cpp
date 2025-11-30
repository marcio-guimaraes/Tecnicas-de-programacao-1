#include <iostream>
#include <iomanip>
#include <locale>

int main() {
    
    std::cout.imbue(std::locale("C"));

    double valorArrecadado = 0;
    int quantMulher = 0;
    int quantHomem = 0;
    char entrada;

    while (std::cin >> entrada) {
        
        if (entrada == 'h') {
            quantHomem++;
            valorArrecadado += 12.50;
        }
        else if (entrada == 'm') {
            quantMulher++;
            valorArrecadado += 7.40;
        }
        else if (entrada == 'q') {
            std::cout << std::fixed << std::setprecision(2);
            
            double totalHomem = quantHomem * 12.5;
            double totalMulher = quantMulher * 7.4;
            
            std::cout << quantHomem << " " << quantMulher << "\n";
            std::cout << totalHomem << " " << totalMulher << " " << valorArrecadado << std::endl;
            
            return 0;
        }
    }

    return 0;
}