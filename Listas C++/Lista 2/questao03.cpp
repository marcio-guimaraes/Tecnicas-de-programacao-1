#include <iostream>
#include <iomanip>
#include <string>
#include <sstream>
#include <locale>

class Temperatura {
private:
    double temperatura;

public:
    Temperatura(double temp) : temperatura(temp) {}

    void celciusToFahreinheit() {
        temperatura = temperatura * 9.0 / 5.0 + 32;
    }

    void fahreinheitToCelcius() {
        temperatura = (temperatura - 32) * 5.0 / 9.0;
    }

    double getTemperatura() const {
        return temperatura;
    }
};

std::ostream& operator<<(std::ostream& os, const Temperatura& t) {
    os << "temperatura: " << std::fixed << std::setprecision(1) << t.getTemperatura() << " graus";
    return os;
}

int main() {
    std::cout.imbue(std::locale("C"));

    double temperatura;
    if (!(std::cin >> temperatura)) {
        return 1;
    }

    Temperatura t1(temperatura);

    t1.celciusToFahreinheit();
    std::cout << t1 << " fahrenheit" << std::endl; 
    
    t1.fahreinheitToCelcius();
    std::cout << t1 << " celsius" << std::endl;

    return 0;
}