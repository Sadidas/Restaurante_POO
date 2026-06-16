public class Prato {
    private String nome;
    private double preco;
    private int vendas;

    public Prato(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
        this.vendas = 0;
    }

    public double getPreco() {
        return preco;
    }

    public String getNome() {
        return nome;
    }

    public int getVendas(){
        return vendas;
    }

    public void foiPedido(){
        this.vendas += 1;
    }
}