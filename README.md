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
- Listar funcionarios em atividade

## Estrutura do projeto

```text
Restaurante_POO/
|-- src/
|   `-- restaurante/
|       |-- Main.java
|       |-- funcionarios/
|       |   |-- Funcionario.java
|       |   |-- Garcom.java
|       |   |-- Cozinheiro.java
|       |   `-- Gerente.java
|       |-- modelo/
|       |   |-- Mesa.java
|       |   |-- Pedido.java
|       |   `-- Prato.java
|       `-- servico/
|           `-- Restaurante.java
|-- README.md
`-- Restaurante_POO.iml
```

## Como executar

```bash
javac -d out $(find src -name "*.java")
java -cp out restaurante.Main
```

No PowerShell:

```powershell
javac -d out (Get-ChildItem -Recurse src -Filter *.java).FullName
java -cp out restaurante.Main
```

## Estrutura das classes

- `restaurante.Main`: interface de console e entrada de dados.
- `restaurante.servico.Restaurante`: controla mesas, cardapio, garcons, cozinheiro e gerente.
- `restaurante.modelo.Mesa`: representa uma mesa e possui um pedido.
- `restaurante.modelo.Pedido`: representa os itens pedidos, status, total e faturamento.
- `restaurante.modelo.Prato`: representa um item do cardapio.
- `restaurante.funcionarios.Funcionario`: classe abstrata base para funcionarios.
- `restaurante.funcionarios.Garcom`: funcionario responsavel por mesas, pedidos e gorjetas.
- `restaurante.funcionarios.Cozinheiro`: funcionario responsavel por preparar pedidos.
- `restaurante.funcionarios.Gerente`: funcionario responsavel por gerar relatorios.

## Conceitos de POO aplicados

- Classes e objetos: pratos, mesas, pedidos e funcionarios.
- Encapsulamento: atributos privados ou protegidos com acesso por metodos.
- Heranca: `Garcom`, `Cozinheiro` e `Gerente` herdam de `Funcionario`.
- Abstracao: `Funcionario` e uma classe abstrata com o metodo `trabalhar`.
- Polimorfismo: diferentes funcionarios executam `trabalhar` de formas diferentes.
- Composicao/associacao: `Restaurante` possui colecoes de mesas, pratos e funcionarios; `Mesa` possui um `Pedido`; `Mesa` se associa a um `Garcom`.
