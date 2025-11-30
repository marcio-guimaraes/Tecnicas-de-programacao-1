#include <iostream>
#include <string>
#include <vector>
#include <iomanip>

class Cliente {
private:
    std::string cpf;
    std::string nome;

public:
    Cliente(std::string cpf, std::string nome) : cpf(cpf), nome(nome) {}

    void setNome(std::string nome) {
        this->nome = nome;
    }

    std::string getNome() const {
        return nome;
    }

    std::string getCpf() const {
        return cpf;
    }
};

class Motorista {
private:
    std::string nome;
    std::string cnh;

public:
    Motorista(std::string nome, std::string cnh) : nome(nome), cnh(cnh) {}

    std::string getNome() const {
        return nome;
    }

    std::string getCnh() const {
        return cnh;
    }
};

class Veiculo {
private:
    std::string modelo;
    std::string placa;

public:
    Veiculo(std::string modelo, std::string placa) : modelo(modelo), placa(placa) {}

    std::string getModelo() const {
        return modelo;
    }

    std::string getPlaca() const {
        return placa;
    }

    friend std::ostream& operator<<(std::ostream& os, const Veiculo& v) {
        os << "Modelo: " << v.modelo << ", Placa: " << v.placa;
        return os;
    }
};

class TipoChamado {
public:
    enum Tipo { T_CORRIDA, T_VIAGEM };

private:
    Tipo tipoEnum;
    double valor;
    std::string nome;

public:
    TipoChamado(Tipo t, double v, std::string n) : tipoEnum(t), valor(v), nome(n) {}

    double getTipo() const {
        return valor;
    }

    friend std::ostream& operator<<(std::ostream& os, const TipoChamado& t) {
        os << t.nome;
        return os;
    }

    static const TipoChamado CORRIDA;
    static const TipoChamado VIAGEM;
};

const TipoChamado TipoChamado::CORRIDA(TipoChamado::T_CORRIDA, 3.59, "CORRIDA");
const TipoChamado TipoChamado::VIAGEM(TipoChamado::T_VIAGEM, 6.51, "VIAGEM");

class Chamado {
private:
    static int contadorChamados;
    int codigoChamado;
    std::string data;
    std::string origem;
    std::string destino;
    std::string horaPartida;
    std::string horaChegada;
    double kmInicial;
    double kmFinal;
    double valorTotal;
    bool finalizou;
    double distancia;

    Cliente* cliente;
    Motorista* motorista;
    Veiculo* veiculo;
    TipoChamado tipo;

    double calcularDistancia() {
        return kmFinal - kmInicial;
    }

    double calcularValorTotal() {
        return calcularDistancia() * this->tipo.getTipo();
    }

    bool isFinalizado() const {
        return this->finalizou;
    }

public:
    Chamado(TipoChamado tipo, std::string data, std::string origem, std::string destino, std::string horaPartida, double kmInicial, Veiculo* veiculo, Motorista* motorista, Cliente* cliente)
        : data(data), origem(origem), destino(destino), horaPartida(horaPartida), kmInicial(kmInicial), cliente(cliente), motorista(motorista), veiculo(veiculo), tipo(tipo) {
        this->codigoChamado = contadorChamados++;
        this->valorTotal = 0;
        this->finalizou = false;
        this->kmFinal = 0;
        this->distancia = 0;
    }

    Chamado(TipoChamado tipo, std::string data, std::string origem, std::string destino, std::string horaPartida, std::string horaChegada, double kmInicial, double kmFinal, Veiculo* veiculo, Motorista* motorista, Cliente* cliente)
        : data(data), origem(origem), destino(destino), horaPartida(horaPartida), kmInicial(kmInicial), cliente(cliente), motorista(motorista), veiculo(veiculo), tipo(tipo) {
        this->codigoChamado = contadorChamados++;
        this->valorTotal = 0;
        this->finalizou = false;
        finalizarChamado(horaChegada, kmFinal);
    }

    void finalizarChamado(std::string horaChegada, double kmFinal) {
        this->horaChegada = horaChegada;
        this->kmFinal = kmFinal;
        this->finalizou = true;
        this->distancia = calcularDistancia();
        this->valorTotal = calcularValorTotal();
    }

    void setMotorista(Motorista* motorista) {
        this->motorista = motorista;
    }

    void mostrarChamado() {
        std::cout << "Chamado: " << this->codigoChamado << std::endl;
        std::cout << "Data: " << this->data << std::endl;
        std::cout << "Tipo: " << this->tipo << std::endl;
        std::cout << "Cliente: " << this->cliente->getNome() << " (CPF: " << this->cliente->getCpf() << ")" << std::endl;
        std::cout << "Motorista: " << this->motorista->getNome() << " (CNH: " << this->motorista->getCnh() << ")" << std::endl;
        std::cout << "Veículo: " << this->veiculo->getModelo() << " (Placa: " << this->veiculo->getPlaca() << ")" << std::endl;
        std::cout << "Origem: " << this->origem << std::endl;
        std::cout << "Destino: " << this->destino << std::endl;
        std::cout << "Partida: " << this->horaPartida << std::endl;

        if (isFinalizado()) {
            std::cout << "Chegada: " << this->horaChegada << std::endl;
            std::cout << std::fixed << std::setprecision(1) << "Distância: " << distancia << " km" << std::endl;
            std::cout << std::fixed << std::setprecision(2) << "Valor total: R$ " << valorTotal << std::endl;
        } else {
            std::cout << "Chegada: Aguardando finalização..." << std::endl;
        }
    }
};

int Chamado::contadorChamados = 100;

int main() {
    
    Cliente cliente1("12345678901", "João");
    Cliente cliente2("98765432100", "Maria");
    Cliente cliente3("55544433322", "Carlos");

    Motorista motorista1("Carlos Silva", "1234567890");
    Motorista motorista2("José Souza", "0987654321");
    Motorista motorista3("Ana Costa", "1122334455");

    Veiculo veiculo1("Fiat Uno", "ABC1D23");
    Veiculo veiculo2("Volkswagen Gol", "XYZ9A87");
    Veiculo veiculo3("Chevrolet Onix", "LMN5P32");

    cliente1.setNome("João da Silva Santos");

    std::cout << "Motorista 2: " << motorista2.getNome() << "\n\n";

    std::cout << "Veículo 3: " << veiculo3 << "\n\n";

    std::vector<Chamado> chamados;

    chamados.emplace_back(TipoChamado::CORRIDA, "01/05/2025", "Setor Comercial Sul", "Asa Norte", "14:00", "14:30", 1234, 1241, &veiculo3, &motorista3, &cliente3);
    
    chamados.emplace_back(TipoChamado::CORRIDA, "01/05/2025", "Asa Norte", "Praça dos Três Poderes", "15:00", "15:20", 1242, 1251, &veiculo3, &motorista3, &cliente1);
    
    chamados.emplace_back(TipoChamado::VIAGEM, "01/05/2025", "Asa Sul", "Formosa", "15:30", "17:00", 2000, 2075, &veiculo1, &motorista1, &cliente2);
    
    chamados.emplace_back(TipoChamado::CORRIDA, "05/05/2025", "Taguatinga", "Shopping Conjunto Nacional", "13:00", 3050, &veiculo1, &motorista1, &cliente2);
    
    chamados.emplace_back(TipoChamado::CORRIDA, "05/05/2025", "Estádio Mané Garrincha", "Shopping ParkShopping", "12:00", 1000, &veiculo2, &motorista1, &cliente1);
    
    chamados.back().setMotorista(&motorista3);

    chamados.emplace_back(TipoChamado::VIAGEM, "05/05/2025", "Cruzeiro", "Planaltina", "11:00", 1270, &veiculo3, &motorista2, &cliente3);
    
    chamados.back().finalizarChamado("12:10", 1315);

    for (auto& chamado : chamados) {
        chamado.mostrarChamado();
        std::cout << std::endl;
    }

    return 0;
}