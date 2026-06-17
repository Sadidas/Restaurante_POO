package restaurante.modelo;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private ArrayList<Prato> pratos;
    private String status;
    private static int pedidos;
    private static double faturamento;

    public Pedido() {
        pratos = new ArrayList<>();
        status = "Aberto";
    }

    public void adicionarPrato(Prato prato) {
        if (pratos.isEmpty()) {
            pedidos++;
        }

        pratos.add(prato);
        prato.foiPedido();
    }

    public double calcularTotal() {
        double total = 0;

        for (Prato p : pratos) {
            total += p.getPreco();
        }

        return total;
    }

    public boolean estaVazio() {
        return pratos.isEmpty();
    }

    public boolean estaPago() {
        return "Pago".equals(status);
    }

    public boolean estaPronto() {
        return "Pronto".equals(status);
    }

    public List<Prato> getPratos() {
        return new ArrayList<>(pratos);
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void adicionarFaturamento(double faturamento) {
        Pedido.faturamento += faturamento;
    }

    public static double getFaturamento() {
        return Pedido.faturamento;
    }

    public static int getPedidos() {
        return pedidos;
    }
}
