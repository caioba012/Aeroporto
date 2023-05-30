import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {//----------------LEMBRAR DE TRATAR ERROS EM RELAÇÃO A X SER QUALQUER COISA--------
    public static void main(String[] args) throws Exception {
        Lista listaAeroportos = new Lista();
        
        // Cadastrando aeroportos iniciais
        listaAeroportos.cadastrarAeroporto("Belo Horizonte", "CNF");
        listaAeroportos.cadastrarAeroporto("Brasília", "BSB");
        listaAeroportos.cadastrarAeroporto("Rio de Janeiro", "GIG");
        listaAeroportos.cadastrarAeroporto("Salvador", "SSA");
        listaAeroportos.cadastrarAeroporto("São Paulo", "GRU");

        // Cadastrando voos iniciais
        listaAeroportos.cadastrarVoo("CNF", "SSA", 123);
        listaAeroportos.cadastrarVoo("CNF", "GIG", 456);
        listaAeroportos.cadastrarVoo("CNF", "GRU", 789);
        listaAeroportos.cadastrarVoo("SSA", "CNF", 890);

        // Menu de opções
        int opcao;
        do {
            Teclado teclado = new Teclado();
            System.out.println("========== Menu ==========");
            System.out.println("1. Cadastrar Aeroporto");
            System.out.println("2. Cadastrar Voo");
            System.out.println("3. Remover Voo");
            System.out.println("4. Listar Voos");
            System.out.println("0. Sair");
            System.out.println("==========================");

            System.out.print("Digite a opção desejada: ");
            opcao = teclado.getUmInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do aeroporto: ");
                    String nomeAeroporto = teclado.getUmString();
                    System.out.print("Digite o código do aeroporto: ");
                    String codigoAeroporto = teclado.getUmString();
                    listaAeroportos.cadastrarAeroporto(nomeAeroporto, codigoAeroporto);
                    System.out.println("Aeroporto cadastrado com sucesso.");
                    break;
                case 2:
                    System.out.print("Digite o código do aeroporto de origem: ");
                    String codigoOrigem = teclado.getUmString();
                    System.out.print("Digite o código do aeroporto de destino: ");
                    String codigoDestino = teclado.getUmString();
                    System.out.print("Digite o número do voo: ");
                    int numeroVoo = teclado.getUmInt();                    
                    listaAeroportos.cadastrarVoo(codigoOrigem, codigoDestino, numeroVoo);
                    System.out.println("\nVoo cadastrado com sucesso.");
                    break;
                case 3:
                    System.out.print("Digite o número do voo a ser removido: ");
                    int numeroVooRemover = teclado.getUmInt();
                    listaAeroportos.removerVoo(numeroVooRemover);
                    System.out.println("\nVoo removido com sucesso.");
                    break;
                case 4:
                    System.out.print("Digite o código do aeroporto: ");
                    String codigoAeroportoListar = teclado.getUmString();
                    listaAeroportos.listarVoos(codigoAeroportoListar);
                    break;
                case 0:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

            System.out.println();
        } while (opcao != 0);
    }
}

