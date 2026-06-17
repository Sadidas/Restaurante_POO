import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Restaurante restaurante = criarRestauranteInicial();
        int opcao;

        do {
            exibirMenu();
            opcao = lerInteiro("Escolha uma opcao: ");
            executarOpcao(opcao, restaurante);
        } while (opcao != 0);

        scanner.close();
    }

    private static Restaurante criarRestauranteInicial() {
        Restaurante restaurante = new Restaurante(
                new Cozinheiro("Joao"),
                new Gerente("Carlos")
        );

        restaurante.cadastrarMesa(1);
        restaurante.cadastrarMesa(2);
        restaurante.cadastrarMesa(3);
        restaurante.cadastrarMesa(4);

        restaurante.cadastrarGarcom("Paula");
        restaurante.cadastrarGarcom("Breno");

        restaurante.cadastrarPrato("Petit Gateau", 47);
        restaurante.cadastrarPrato("Cheesecake com Geleia", 39);
        restaurante.cadastrarPrato("File Mignon", 138);
        restaurante.cadastrarPrato("Porcao de Camarao", 120);
        restaurante.cadastrarPrato("Espumante Premium", 245);
        restaurante.cadastrarPrato("Suco natural de frutas vermelhas", 31);

        return restaurante;
    }

    private static void exibirMenu() {
        System.out.println("\n========= RESTAURANTE =========");
        System.out.println("1 - Listar cardapio");
        System.out.println("2 - Cadastrar prato");
        System.out.println("3 - Listar mesas");
        System.out.println("4 - Cadastrar mesa");
        System.out.println("5 - Listar garcons");
        System.out.println("6 - Cadastrar garcom");
        System.out.println("7 - Atribuir garcom a mesa");
        System.out.println("8 - Adicionar prato ao pedido");
        System.out.println("9 - Ver pedido de uma mesa");
        System.out.println("10 - Preparar pedido");
        System.out.println("11 - Pagar conta");
        System.out.println("12 - Relatorio gerencial");
        System.out.println("13 - Demonstrar polimorfismo");
        System.out.println("0 - Sair");
    }

    private static void executarOpcao(int opcao, Restaurante restaurante) {
        switch (opcao) {
            case 1:
                restaurante.listarCardapio();
                break;
            case 2:
                cadastrarPrato(restaurante);
                break;
            case 3:
                restaurante.listarMesas();
                break;
            case 4:
                cadastrarMesa(restaurante);
                break;
            case 5:
                restaurante.listarGarcons();
                break;
            case 6:
                cadastrarGarcom(restaurante);
                break;
            case 7:
                atribuirGarcom(restaurante);
                break;
            case 8:
                adicionarPratoAoPedido(restaurante);
                break;
            case 9:
                verPedido(restaurante);
                break;
            case 10:
                prepararPedido(restaurante);
                break;
            case 11:
                pagarConta(restaurante);
                break;
            case 12:
                restaurante.gerarRelatorio();
                break;
            case 13:
                restaurante.demonstrarPolimorfismo();
                break;
            case 0:
                System.out.println("Sistema encerrado.");
                break;
            default:
                System.out.println("Opcao invalida.");
                break;
        }
    }

    private static void cadastrarPrato(Restaurante restaurante) {
        String nome = lerTexto("Nome do prato: ");
        double preco = lerDouble("Preco: R$ ");

        restaurante.cadastrarPrato(nome, preco);
        System.out.println("Prato cadastrado.");
    }

    private static void cadastrarMesa(Restaurante restaurante) {
        int numero = lerInteiro("Numero da mesa: ");

        if (restaurante.cadastrarMesa(numero)) {
            System.out.println("Mesa cadastrada.");
        } else {
            System.out.println("Ja existe uma mesa com esse numero.");
        }
    }

    private static void cadastrarGarcom(Restaurante restaurante) {
        String nome = lerTexto("Nome do garcom: ");

        restaurante.cadastrarGarcom(nome);
        System.out.println("Garcom cadastrado.");
    }

    private static void atribuirGarcom(Restaurante restaurante) {
        restaurante.listarMesas();
        int numeroMesa = lerInteiro("Numero da mesa: ");

        restaurante.listarGarcons();
        int indiceGarcom = lerInteiro("Numero do garcom na lista: ");

        restaurante.atribuirGarcom(numeroMesa, indiceGarcom);
    }

    private static void adicionarPratoAoPedido(Restaurante restaurante) {
        restaurante.listarMesas();
        int numeroMesa = lerInteiro("Numero da mesa: ");

        restaurante.listarCardapio();
        int indicePrato = lerInteiro("Numero do prato no cardapio: ");

        restaurante.adicionarPratoAoPedido(numeroMesa, indicePrato);
    }

    private static void verPedido(Restaurante restaurante) {
        int numeroMesa = lerInteiro("Numero da mesa: ");
        restaurante.listarPedidoDaMesa(numeroMesa);
    }

    private static void prepararPedido(Restaurante restaurante) {
        int numeroMesa = lerInteiro("Numero da mesa: ");
        restaurante.prepararPedido(numeroMesa);
    }

    private static void pagarConta(Restaurante restaurante) {
        int numeroMesa = lerInteiro("Numero da mesa: ");
        restaurante.pagarConta(numeroMesa);
    }

    private static String lerTexto(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextLine();
    }

    private static int lerInteiro(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String entrada = scanner.nextLine();

            try {
                return Integer.parseInt(entrada);
            } catch (NumberFormatException erro) {
                System.out.println("Digite um numero inteiro valido.");
            }
        }
    }

    private static double lerDouble(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String entrada = scanner.nextLine().replace(",", ".");

            try {
                double valor = Double.parseDouble(entrada);

                if (valor < 0) {
                    System.out.println("Digite um valor positivo.");
                    continue;
                }

                return valor;
            } catch (NumberFormatException erro) {
                System.out.println("Digite um valor numerico valido.");
            }
        }
    }
}
