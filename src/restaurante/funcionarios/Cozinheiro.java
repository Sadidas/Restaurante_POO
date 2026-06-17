package restaurante.funcionarios;

import restaurante.modelo.Pedido;

public class Cozinheiro extends Funcionario {

    public Cozinheiro(String nome) {
        super(nome, 3500);
    }

    public void prepararPedido(Pedido pedido) {
        pedido.setStatus("Pronto");
    }

    @Override
    public void trabalhar() {
        System.out.println("Preparando pratos.");
    }
}
