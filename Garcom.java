import java.util.ArrayList;

public class Garcom extends Funcionario {

    private ArrayList<Mesa> mesas;

    public Garcom(String nome){
        super(nome, 1500);
        mesas = new ArrayList<>();
    }

    public void anotarPedido(Pedido pedido){
        System.out.println("Pedido anotado.");
        mesas = new ArrayList<>();
    }

    public void gorjeta(double gorjeta){
        this.salario += gorjeta;
    }

    public double getGorjetasRecebidas(){
        return (this.salario - 1500);
    }

    public String getNome(){
        return this.nome;
    }

    public void atribuirMesa(Mesa mesa){ 
        mesas.add(mesa); 
    }

    public int getQuantidadeMesas() {
        return mesas.size();
    }

    @Override
    public void trabalhar() {
        System.out.println("Atendendo clientes.");
    }
}