import java.util.ArrayList;

public class main {
    public static void main(String[] args) throws Exception {
        Mesa mesa1 = new Mesa(1);
        Mesa mesa2 = new Mesa(2);
        Mesa mesa3 = new Mesa(3);
        Mesa mesa4 = new Mesa(4);

        Prato petit = new Prato("Petit Gateau", 47);
        Prato cheesecake = new Prato("Cheesecake com Geleia", 39);
        Prato file =  new Prato("File Mignon", 138);
        Prato camarao = new Prato("Porção de Camarão", 120);
        Prato espumante = new Prato("Espumante Premium", 245);
        Prato suco = new Prato("Suco natural de frutas vermelhas", 31);

        Garcom paula = new Garcom("Paula");
        Garcom breno = new Garcom("Breno");

        ArrayList<Prato> cardapio = new ArrayList<>();

        cardapio.add(petit);
        cardapio.add(cheesecake);
        cardapio.add(file);
        cardapio.add(camarao);
        cardapio.add(espumante);
        cardapio.add(suco);

        ArrayList<Garcom> garcons = new ArrayList<>();

        garcons.add(paula);
        garcons.add(breno);

        mesa1.setGarcom(paula);
        mesa3.setGarcom(paula);

        mesa2.setGarcom(breno);
        mesa4.setGarcom(breno);

        mesa1.getPedido().adicionarPrato(file);
        mesa1.getPedido().adicionarPrato(espumante);

        mesa2.getPedido().adicionarPrato(camarao);
        mesa2.getPedido().adicionarPrato(suco);

        mesa3.getPedido().adicionarPrato(file);
        mesa3.getPedido().adicionarPrato(file);
        mesa3.getPedido().adicionarPrato(espumante);

        mesa4.getPedido().adicionarPrato(cheesecake);
        mesa4.getPedido().adicionarPrato(suco);

        Cozinheiro joao = new Cozinheiro("Joao");

        joao.prepararPedido(mesa1.getPedido());

        mesa1.pagarConta();
        mesa2.pagarConta();
        mesa3.pagarConta();
        mesa4.pagarConta();

        Gerente carlos = new Gerente("Carlos");

        carlos.gerarRelatorio(cardapio, garcons);

    }
}
