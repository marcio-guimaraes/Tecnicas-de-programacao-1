#include <iostream>
#include <vector>
#include <cmath> 
#include <functional>

class Circulo {
private:
    int x;
    int y;
    int raio;

public:
    static constexpr double PI = 3.14159;

    Circulo(int x, int y, int raio) : x(x), y(y), raio(raio) {}

    int getX() const {
        return x;
    }

    int getY() const {
        return y;
    }

    int getRaio() const {
        return raio;
    }

    void setRaio(int raio) {
        this->raio = raio;
    }

    double circunferencia() const {
        return 2 * PI * raio;
    }
};

int main() {
    
    std::vector<Circulo> vetor1;
    vetor1.reserve(3);

    for (int i = 0; i < 3; i++) {
        int x, y, raio;
        if (!(std::cin >> x >> y >> raio)) return 1;
        vetor1.emplace_back(x, y, raio);
    }

    std::vector<std::reference_wrapper<Circulo>> vetor2;
    for (Circulo& c : vetor1) {
        vetor2.push_back(std::ref(c));
    }
    
    std::vector<Circulo> vetor3;
    vetor3.reserve(3);
    
    for (int i = 0; i < 3; i++) {
        vetor3.emplace_back(
            vetor1[i].getX(),
            vetor1[i].getY(),
            vetor1[i].getRaio()
        );
    }

    for (int i = 0; i < 3; i++) {
        int novoRaio;
        if (!(std::cin >> novoRaio)) return 1;
        vetor1[i].setRaio(novoRaio);
    }

    std::cout << "vetor1:\n";
    for (const auto& circulo : vetor1) {
        std::cout << circulo.getX() << " " << circulo.getY() << " " << circulo.getRaio() << "\n";
    }

    std::cout << "vetor2:\n";
    for (const auto& circuloRef : vetor2) { 
        std::cout << circuloRef.get().getX() << " " << circuloRef.get().getY() << " " << circuloRef.get().getRaio() << "\n";
    }

    std::cout << "vetor3:\n";
    for (const auto& circulo : vetor3) {
        std::cout << circulo.getX() << " " << circulo.getY() << " " << circulo.getRaio() << "\n";
    }

    return 0;
}