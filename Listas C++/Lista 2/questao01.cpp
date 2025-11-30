#include <iostream>
#include <string>

using namespace std;

class Emergencia {
public:
    string nome, telefone, local, dataHora, natureza, tipo, status, feitoNoCel, coordenadas;

    void chamarEmergencia() {
        getline(cin, nome);
        getline(cin, telefone);
        getline(cin, local);
        getline(cin, dataHora);
        getline(cin, natureza);
        getline(cin, tipo);
        getline(cin, status);
        getline(cin, feitoNoCel);

        if (feitoNoCel == "sim" || feitoNoCel == "SIM" || feitoNoCel == "Sim") {
            feitoNoCel = "Sim";
            getline(cin, coordenadas);
        } else {
            feitoNoCel = "Não";
            coordenadas = "";
        }
    }

    void mostrarEmergencias(int quant) {
        if (quant != 1) {
            cout << endl;
        }

        cout << "Emergência #" << quant << endl;
        cout << endl;
        cout << "--- Informações da Emergência ---" << endl;
        cout << endl;
        cout << "Nome do Chamador: " << nome << endl;
        cout << "Telefone: " << telefone << endl;
        cout << "Local da Emergência: " << local << endl;
        cout << "Data/hora do Relato: " << dataHora << endl;
        cout << "Natureza da Emergência: " << natureza << endl;
        cout << "Tipo de Resposta: " << tipo << endl;
        cout << "Status da Resposta: " << status << endl;
        cout << "Chamada via celular: " << feitoNoCel << endl;

        if (feitoNoCel == "Sim") {
            cout << "Coordenadas GPS: " << coordenadas << endl;
        }
    }
};

int main() {
    int quant;
    cin >> quant;
    cin.ignore();

    for (int i = 1; i <= quant; i++) {
        Emergencia emergencia;
        emergencia.chamarEmergencia();
        emergencia.mostrarEmergencias(i);
    }

    return 0;
}