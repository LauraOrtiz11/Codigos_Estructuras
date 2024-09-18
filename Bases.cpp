#include <iostream>
#include <iomanip>  
#include <bitset>   
using namespace std;

//Convertir decimal a BCD 
void BCD(int decimal) {
    cout << "BCD natural: ";
    string bcd = ""; 
    while (decimal > 0) {
        int digito = decimal % 10;
        bcd = bitset<4>(digito).to_string() + " " + bcd; // Agregar cada dígito 
        decimal /= 10;
    }
    cout << bcd << endl;
}

int main() {
    int numero;
	cout <<"Laura Valentina Ortiz Bustos\n Nicolas Felipe Gonzalez Bello\n"<<endl;
    cout << "Introduce un número decimal: ";
    cin >> numero;
    cout << "Decimal: " << dec << numero << endl;
	cout << "Binario: " << bitset<32>(numero).to_string().substr(bitset<32>(numero).to_string().find('1')) << endl;
	cout << "Hexadecimal: " << hex << numero << endl;
    BCD(numero);
	
    return 0;
}

