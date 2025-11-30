#include <iostream>
#include <iomanip>
#include <locale>

int main() {
    
    std::cout.imbue(std::locale("C"));

    double A;
    char sexo;

    std::cin >> A;
    std::cin >> sexo;

    double peso_ideal = 0;

    if (A <= 0 || (sexo != 'm' && sexo != 'f')) {
        std::cout << "Entrada inválida!" << std::endl;
    } 
    else {
        if (sexo == 'f') {
            peso_ideal = (62.1 * A) - 44.7;
        } 
        else if (sexo == 'm') {
            peso_ideal = (72.7 * A) - 58;
        }

        std::cout << std::fixed << std::setprecision(1) << peso_ideal << " kg" << std::endl;
    }

    return 0;
}