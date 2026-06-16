import java.util.ArrayList;

public class Pedido {

    private ArrayList<Prato> pratos;
    private String status;
    private static int pedidos;
    private static double faturamento;

    public Pedido() {
        pratos = new ArrayList<>();
        status = "Aberto";
        pedidos++;
    }

    public void adicionarPrato(Prato prato){
        pratos.add(prato);
        prato.foiPedido();
    }

    public double calcularTotal(){
        double total = 0;

        for(Prato p : pratos){
            total += p.getPreco();
        }

        return total;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public String getStatus(){
        return status;
    }

    public void setFaturamento(double faturamento){
        Pedido.faturamento += faturamento;
    }

    public static double getFaturamento(){
        return Pedido.faturamento;
    }

    public static int getPedidos() {
        return pedidos;
    }
}