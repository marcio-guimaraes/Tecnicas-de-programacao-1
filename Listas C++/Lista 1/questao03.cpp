#include <iostream>
#include <iomanip>
#include <locale>

int main() {
    
    std::cout.imbue(std::locale("C"));

    int tipoLoteamento;
    int area;
    double iptu = 0;

    std::cin >> tipoLoteamento;
    std::cin >> area;

    if ((tipoLoteamento != 1 && tipoLoteamento != 2) || area <= 0) {
        std::cout << "Entrada inválida!" << std::endl;
        return 0; 
    } 
    else if (tipoLoteamento == 1) {
        if (area < 200) {
            iptu = area;
        } 
        else {
            iptu = area * 1.2;
        }
    } 
    else {
        if (area < 200) {
            iptu = area * 1.1;
        } 
        else {
            iptu = area * 1.3;
        }
    }
    
    std::cout << std::fixed << std::setprecision(2) << iptu << std::endl;

    return 0;
}