# Sistema de Restaurante - Projeto POO

Projeto final da disciplina C06 desenvolvido em Java. O sistema simula o funcionamento de um restaurante por meio de um menu no terminal.

## Funcionalidades

- Listar e cadastrar pratos no cardapio
- Listar e cadastrar mesas
- Listar e cadastrar garcons
- Atribuir garcom a uma mesa
- Adicionar pratos ao pedido de uma mesa
- Consultar pedido de uma mesa
- Preparar pedido com o cozinheiro
- Pagar conta da mesa
- Gerar relatorio gerencial
- Demonstrar polimorfismo com funcionarios

## Como executar

```bash
javac *.java
java Main
```

## Estrutura das classes

- `Main`: interface de console e entrada de dados.
- `Restaurante`: controla mesas, cardapio, garcons, cozinheiro e gerente.
- `Mesa`: representa uma mesa e possui um pedido.
- `Pedido`: representa os itens pedidos, status, total e faturamento.
- `Prato`: representa um item do cardapio.
- `Funcionario`: classe abstrata base para funcionarios.
- `Garcom`: funcionario responsavel por mesas, pedidos e gorjetas.
- `Cozinheiro`: funcionario responsavel por preparar pedidos.
- `Gerente`: funcionario responsavel por gerar relatorios.

## Conceitos de POO aplicados

- Classes e objetos: pratos, mesas, pedidos e funcionarios.
- Encapsulamento: atributos privados ou protegidos com acesso por metodos.
- Heranca: `Garcom`, `Cozinheiro` e `Gerente` herdam de `Funcionario`.
- Abstracao: `Funcionario` e uma classe abstrata com o metodo `trabalhar`.
- Polimorfismo: diferentes funcionarios executam `trabalhar` de formas diferentes.
- Composicao/associacao: `Restaurante` possui colecoes de mesas, pratos e funcionarios; `Mesa` possui um `Pedido`; `Mesa` se associa a um `Garcom`.
