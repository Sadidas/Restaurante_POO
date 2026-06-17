package restaurante.servico;

import java.util.ArrayList;
import java.util.List;
import restaurante.funcionarios.Cozinheiro;
import restaurante.funcionarios.Funcionario;
import restaurante.funcionarios.Garcom;
import restaurante.funcionarios.Gerente;
import restaurante.modelo.Mesa;
import restaurante.modelo.Prato;

public class Restaurante {
    private List<Mesa> mesas;
    private List<Prato> cardapio;
    private List<Garcom> garcons;
    private Cozinheiro cozinheiro;
    private Gerente gerente;

    public Restaurante(Cozinheiro cozinheiro, Gerente gerente) {
        this.mesas = new ArrayList<>();
        this.cardapio = new ArrayList<>();
        this.garcons = new ArrayList<>();
        this.cozinheiro = cozinheiro;
        this.gerente = gerente;
    }

    public boolean cadastrarMesa(int numero) {
        if (buscarMesa(numero) != null) {
            return false;
        }

        mesas.add(new Mesa(numero));
        return true;
    }

    public void cadastrarPrato(String nome, double preco) {
        cardapio.add(new Prato(nome, preco));
    }

    public void cadastrarGarcom(String nome) {
        garcons.add(new Garcom(nome));
    }

    public Mesa buscarMesa(int numero) {
        for (Mesa mesa : mesas) {
            if (mesa.getNumero() == numero) {
                return mesa;
            }
        }

        return null;
    }

    public Prato buscarPrato(int indice) {
        if (indice < 1 || indice > cardapio.size()) {
            return null;
        }

        return cardapio.get(indice - 1);
    }

    public Garcom buscarGarcom(int indice) {
        if (indice < 1 || indice > garcons.size()) {
            return null;
        }

        return garcons.get(indice - 1);
    }

    public void atribuirGarcom(int numeroMesa, int indiceGarcom) {
        Mesa mesa = buscarMesa(numeroMesa);
        Garcom garcom = buscarGarcom(indiceGarcom);

        if (mesa == null || garcom == null) {
            System.out.println("Mesa ou garcom invalido.");
            return;
        }

        mesa.setGarcom(garcom);
        System.out.println("Garcom " + garcom.getNome() + " atribuido a mesa " + mesa.getNumero() + ".");
    }

    public void adicionarPratoAoPedido(int numeroMesa, int indicePrato) {
        Mesa mesa = buscarMesa(numeroMesa);
        Prato prato = buscarPrato(indicePrato);

        if (mesa == null || prato == null) {
            System.out.println("Mesa ou prato invalido.");
            return;
        }

        if (mesa.getGarcom() == null) {
            System.out.println("Atribua um garcom a mesa antes de registrar o pedido.");
            return;
        }

        mesa.adicionarPrato(prato);
        mesa.getGarcom().anotarPedido(mesa.getPedido());
        System.out.println(prato.getNome() + " adicionado ao pedido da mesa " + mesa.getNumero() + ".");
    }

    public void prepararPedido(int numeroMesa) {
        Mesa mesa = buscarMesa(numeroMesa);

        if (mesa == null) {
            System.out.println("Mesa invalida.");
            return;
        }

        if (mesa.getPedido().estaVazio()) {
            System.out.println("Mesa " + numeroMesa + " nao possui pedido para preparar.");
            return;
        }

        cozinheiro.prepararPedido(mesa.getPedido());
        System.out.println("Pedido da mesa " + numeroMesa + " preparado por " + cozinheiro.getNome() + ".");
    }

    public void pagarConta(int numeroMesa) {
        Mesa mesa = buscarMesa(numeroMesa);

        if (mesa == null) {
            System.out.println("Mesa invalida.");
            return;
        }

        mesa.pagarConta();
    }

    public void listarCardapio() {
        if (cardapio.isEmpty()) {
            System.out.println("Cardapio vazio.");
            return;
        }

        for (int i = 0; i < cardapio.size(); i++) {
            Prato prato = cardapio.get(i);
            System.out.printf("%d - %s | R$ %.2f | vendas: %d\n",
                    i + 1, prato.getNome(), prato.getPreco(), prato.getVendas());
        }
    }

    public void listarGarcons() {
        if (garcons.isEmpty()) {
            System.out.println("Nenhum garcom cadastrado.");
            return;
        }

        for (int i = 0; i < garcons.size(); i++) {
            Garcom garcom = garcons.get(i);
            System.out.printf("%d - %s | mesas: %d | gorjetas: R$ %.2f\n",
                    i + 1, garcom.getNome(), garcom.getQuantidadeMesas(), garcom.getGorjetasRecebidas());
        }
    }

    public void listarMesas() {
        if (mesas.isEmpty()) {
            System.out.println("Nenhuma mesa cadastrada.");
            return;
        }

        for (Mesa mesa : mesas) {
            String nomeGarcom = mesa.getGarcom() == null ? "sem garcom" : mesa.getGarcom().getNome();
            System.out.printf("Mesa %d | %s | pedido: %s | total: R$ %.2f\n",
                    mesa.getNumero(), nomeGarcom, mesa.getPedido().getStatus(), mesa.getPedido().calcularTotal());
        }
    }

    public void listarPedidoDaMesa(int numeroMesa) {
        Mesa mesa = buscarMesa(numeroMesa);

        if (mesa == null) {
            System.out.println("Mesa invalida.");
            return;
        }

        if (mesa.getPedido().estaVazio()) {
            System.out.println("Mesa " + numeroMesa + " ainda nao possui itens.");
            return;
        }

        System.out.println("Pedido da mesa " + numeroMesa + ":");
        for (Prato prato : mesa.getPedido().getPratos()) {
            System.out.printf("- %s | R$ %.2f\n", prato.getNome(), prato.getPreco());
        }
        System.out.printf("Total: R$ %.2f\n", mesa.getPedido().calcularTotal());
    }

    public void gerarRelatorio() {
        gerente.gerarRelatorio(cardapio, garcons);
    }

    public void listarFuncionariosEmAtividade() {
        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.addAll(garcons);
        funcionarios.add(cozinheiro);
        funcionarios.add(gerente);

        for (Funcionario funcionario : funcionarios) {
            System.out.print(funcionario.getNome() + ": ");
            funcionario.trabalhar();
        }
    }
}
