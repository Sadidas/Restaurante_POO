package restaurante.modelo;

import restaurante.funcionarios.Garcom;

public class Mesa {

    private int numero;
    private Pedido pedido;
    private Garcom garcom;

    public Mesa(int numero) {
        this.numero = numero;
        pedido = new Pedido();
    }

    public Pedido getPedido() {
        return pedido;
    }

    public Garcom getGarcom() {
        return garcom;
    }

    public int getNumero() {
        return numero;
    }

    public void setGarcom(Garcom garcom) {
        this.garcom = garcom;
        garcom.atribuirMesa(this);
    }

    public void adicionarPrato(Prato prato) {
        if (pedido.estaPago()) {
            pedido = new Pedido();
        }

        pedido.adicionarPrato(prato);
        pedido.setStatus("Aberto");
    }

    public void pagarConta() {
        if (pedido != null) {
            if (garcom == null) {
                System.out.println("Mesa " + numero + " nao possui garcom atribuido.");
                return;
            }

            if ("Pago".equals(pedido.getStatus())) {
                System.out.println("Mesa " + numero + " ja pagou a conta.");
                return;
            }

            if (pedido.estaVazio()) {
                System.out.println("Mesa " + numero + " nao possui itens no pedido.");
                return;
            }

            if (!pedido.estaPronto()) {
                System.out.println("Pedido da mesa " + numero + " ainda nao esta pronto.");
                return;
            }

            double total = pedido.calcularTotal();

            System.out.printf("Mesa %d pagou a conta de R$ %.2f\n", numero, total);

            garcom.gorjeta(total * 0.1);

            pedido.adicionarFaturamento(total);
            pedido.setStatus("Pago");
        }
    }
}
