package restaurante.funcionarios;

import java.util.List;
import restaurante.modelo.Pedido;
import restaurante.modelo.Prato;

public class Gerente extends Funcionario {

    public Gerente(String nome) {
        super(nome, 6000);
    }

    public void gerarRelatorio(List<Prato> cardapio, List<Garcom> garcons) {
        System.out.println("===============================");
        System.out.println("   RELATORIO GERENCIAL");
        System.out.println("===============================");

        System.out.println("\nPedidos realizados: " + Pedido.getPedidos());
        System.out.printf("Faturamento total: R$ %.2f\n", Pedido.getFaturamento());

        if (cardapio.isEmpty()) {
            System.out.println("\nCardapio vazio.");
            return;
        }

        Prato maisVendido = cardapio.get(0);
        Prato menosVendido = cardapio.get(0);

        for (Prato prato : cardapio) {
            if (prato.getVendas() > maisVendido.getVendas()) {
                maisVendido = prato;
            }

            if (prato.getVendas() < menosVendido.getVendas()) {
                menosVendido = prato;
            }
        }

        System.out.println("\nMais vendido:");
        System.out.println(maisVendido.getNome() + " (" + maisVendido.getVendas() + " vendas)");

        System.out.println("\nMenos vendido:");
        System.out.println(menosVendido.getNome() + " (" + menosVendido.getVendas() + " vendas)");

        System.out.println("\n--- GARCONS ---");
        for (Garcom garcom : garcons) {
            System.out.println("\n" + garcom.getNome());
            System.out.println("Mesas atendidas: " + garcom.getQuantidadeMesas());
            System.out.printf("Gorjetas: R$ %.2f\n", garcom.getGorjetasRecebidas());
        }
    }

    @Override
    public void trabalhar() {
        System.out.println("Gerenciando restaurante.");
    }
}
