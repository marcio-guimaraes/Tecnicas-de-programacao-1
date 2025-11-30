#include <iostream>

class Retangulo {
private:
    int largura = 1;
    int comprimento = 1;

public:
    int perimetro() {
        return 2 * (comprimento + largura);
    }

    int area() {
        return comprimento * largura;
    }

    int getLargura() {
        return largura;
    }

    int getComprimento() {
        return comprimento;
    }

    void setLargura(int largura) {
        if (largura > 0 && largura < 20) {
            this->largura = largura;
        }
    }

    void setComprimento(int comprimento) {
        if (comprimento > 0 && comprimento < 20) {
            this->comprimento = comprimento;
        }
    }
};

int main() {

    Retangulo r1;
    int comprimento1;
    int largura1;
    std::cin >> comprimento1;
    std::cin >> largura1;
    r1.setComprimento(comprimento1);
    r1.setLargura(largura1);

    Retangulo r2;
    int comprimento2;
    int largura2;
    std::cin >> comprimento2;
    std::cin >> largura2;
    r2.setComprimento(comprimento2);
    r2.setLargura(largura2);

    int comprimento, largura, perimetro, area;

    comprimento = r1.getComprimento();
    largura = r1.getLargura();
    perimetro = r1.perimetro();
    area = r1.area();

    std::cout << comprimento << " " << largura << " " << perimetro << " " << area << "\n";

    comprimento = r2.getComprimento();
    largura = r2.getLargura();
    perimetro = r2.perimetro();
    area = r2.area();

    std::cout << comprimento << " " << largura << " " << perimetro << " " << area << "\n";

    return 0;
}