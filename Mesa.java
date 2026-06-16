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

    public int getNumero() {
        return numero;
    }

    public void setGarcom(Garcom garcom){
        this.garcom = garcom;
        garcom.atribuirMesa(this);
    }

    public void pagarConta(){
        if(pedido != null){

            double total = pedido.calcularTotal();

            System.out.println(
                "Mesa " + numero +
                " pagou a conta de R$ " + total
            );

            garcom.gorjeta(total * 0.1);

            pedido.setFaturamento(total);
        }
    }
}