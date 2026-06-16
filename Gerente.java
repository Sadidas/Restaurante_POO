import java.util.ArrayList;

public class Gerente extends Funcionario {

    public Gerente(String nome) {
        super(nome, 6000);
    }

    public void gerarRelatorio(
            ArrayList<Prato> cardapio,
            ArrayList<Garcom> garcons) {

        System.out.println("===============================");
        System.out.println("   RELATÓRIO GERENCIAL");
        System.out.println("===============================");

        System.out.println("\nPedidos realizados: "
                + Pedido.getPedidos());

        System.out.println("Faturamento total: R$ "
                + Pedido.getFaturamento());

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
        System.out.println(maisVendido.getNome()
                + " (" + maisVendido.getVendas() + " vendas)");

        System.out.println("\nMenos vendido:");
        System.out.println(menosVendido.getNome()
                + " (" + menosVendido.getVendas() + " vendas)");

        System.out.println("\n--- GARÇONS ---");

        for (Garcom garcom : garcons) {

            System.out.println("\n" + garcom.getNome());

            System.out.println("Mesas atendidas: "
                    + garcom.getQuantidadeMesas());

            System.out.printf("Gorjetas: R$ %.2f\n", garcom.getGorjetasRecebidas());
        }
    }

    @Override
    public void trabalhar() {
        System.out.println("Gerenciando restaurante.");
    }
}