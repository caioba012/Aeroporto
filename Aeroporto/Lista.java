import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.lang.reflect.*;


// Classe que representa a lista encadeada de aeroportos
class Lista<X> {
    private List<Aeroporto> aeroportos;

    public Lista() {
        this.aeroportos = new ArrayList<>();
    }

    public void cadastrarAeroporto(X nome, X codigo) throws Exception{

        if(nome == null && codigo == null)
            throw new Exception("Informacao ausente");

        X inserir = null;
        X inserir2 = null;
        if (nome instanceof Cloneable){
            inserir = (X)meuCloneDeX(nome);
            inserir2 = (X)meuCloneDeX(codigo);}
        else{
            inserir = nome;
            inserir2 = codigo;}

        String x = (String)nome;
        String x2 = (String)codigo;

        Aeroporto aeroporto = new Aeroporto(x, x2);
        aeroportos.add(aeroporto);
    }

    public void cadastrarVoo(String codigoOrigem, String codigoDestino, int numero) {
        int origemIndex = encontrarAeroportoIndex(codigoOrigem);
        int destinoIndex = encontrarAeroportoIndex(codigoDestino);

        if (origemIndex != -1 && destinoIndex != -1) {
            Aeroporto origem = aeroportos.get(origemIndex);
            origem.adicionarVoo(destinoIndex, numero);
        } else {
            System.out.println("Aeroporto de origem ou destino não encontrado.");
        }
    }

    public void removerVoo(int numero) {
        for (Aeroporto aeroporto : aeroportos) {
            aeroporto.removerVoo(numero);
        }
    }

    public void listarVoos(String codigoAeroporto) {
        int aeroportoIndex = encontrarAeroportoIndex(codigoAeroporto);

        if (aeroportoIndex != -1) {
            Aeroporto aeroporto = aeroportos.get(aeroportoIndex);
            List<Voo> voos = aeroporto.getVoos();

            System.out.println("Voos saindo do aeroporto " + aeroporto.getNome() + " (" + aeroporto.getCodigo() + "):");

            for (Voo voo : voos) {
                Aeroporto destino = aeroportos.get(voo.getDestinoIndex());
                System.out.println("- Voo " + voo.getNumero() + ": " + destino.getNome());
            }
        } else {
            System.out.println("Aeroporto não encontrado.");
        }
    }

    private int encontrarAeroportoIndex(String codigoAeroporto) {
        for (int i = 0; i < aeroportos.size(); i++) {
            Aeroporto aeroporto = aeroportos.get(i);
            if (aeroporto.getCodigo().equals(codigoAeroporto)) {
                return i;
            }
        }
        return -1;
    }

    private X meuCloneDeX (X x)
    {
        X ret=null;

        try
        {
            Class<?> classe         = x.getClass();
            Class<?>[] tipoDosParms = null;
            Method metodo           = classe.getMethod("clone",tipoDosParms);
            Object[] parms          = null;
            ret                     = (X)metodo.invoke(x,parms);
        }
        catch(NoSuchMethodException erro)
        {}
        catch(IllegalAccessException erro)
        {}
        catch(InvocationTargetException erro)
        {}

        return ret;
    }
}