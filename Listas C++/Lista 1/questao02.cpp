#include <iostream>
#include <iomanip>
#include <locale>

int main() {
    
    std::cout.imbue(std::locale("C"));

    double consumo;
    std::cin >> consumo; 

    double tarifa_total = 0; 
    double tarifa_basica = 5;

    if (consumo <= 500) {
        tarifa_total = tarifa_basica + consumo * 0.02;
    }
    else if (consumo <= 1000) {
        tarifa_total = tarifa_basica + 50 + (consumo - 500) * 0.05;
    }
    else if (consumo > 1000) {
        tarifa_total = tarifa_basica + 350 + (consumo - 1000) * 0.1;
    }

    std::cout << std::fixed << std::setprecision(2);
    
    std::cout << (tarifa_total - tarifa_basica) << " " << tarifa_basica << " " << tarifa_total << std::endl;

    return 0;
}