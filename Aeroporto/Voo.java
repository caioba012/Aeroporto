import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Classe que representa um voo entre dois aeroportos
class Voo {
    private int destinoIndex;
    private int numero;

    public Voo(int destinoIndex, int numero) {
        this.destinoIndex = destinoIndex;
        this.numero = numero;
    }

    public int getDestinoIndex() {
        return destinoIndex;
    }

    public int getNumero() {
        return numero;
    }
}





