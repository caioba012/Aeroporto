import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


// Classe que representa um aeroporto
class Aeroporto<X> {
    private X nome;
    private X codigo;
    private List<Voo> voos;
    private Aeroporto aer = new Aeroporto(nome, codigo);

    public Aeroporto(X nome, X codigo) {
        this.nome = nome;
        this.codigo = codigo;
        this.voos = new ArrayList<>();
    }

    public X getNome() {
        return nome;
    }

    public X getCodigo() {
        return codigo;
    }

    public List<Voo> getVoos() {
        return voos;
    }

    public void adicionarVoo(int destinoIndex, int numero) {
        voos.add(new Voo(destinoIndex, numero));
    }   

    public void removerVoo(int numero) {
        voos.removeIf(voo -> voo.getNumero() == numero);
    }
}