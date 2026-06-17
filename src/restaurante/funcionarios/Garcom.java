package restaurante.funcionarios;

import java.util.ArrayList;
import restaurante.modelo.Mesa;
import restaurante.modelo.Pedido;

public class Garcom extends Funcionario {

    private ArrayList<Mesa> mesas;
    private double gorjetasRecebidas;

    public Garcom(String nome) {
        super(nome, 1500);
        mesas = new ArrayList<>();
        gorjetasRecebidas = 0;
    }

    public void anotarPedido(Pedido pedido) {
        System.out.println("Pedido anotado.");
    }

    public void gorjeta(double gorjeta) {
        this.gorjetasRecebidas += gorjeta;
    }

    public double getGorjetasRecebidas() {
        return gorjetasRecebidas;
    }

    public void atribuirMesa(Mesa mesa) {
        if (!mesas.contains(mesa)) {
            mesas.add(mesa);
        }
    }

    public int getQuantidadeMesas() {
        return mesas.size();
    }

    @Override
    public void trabalhar() {
        System.out.println("Atendendo clientes.");
    }
}
