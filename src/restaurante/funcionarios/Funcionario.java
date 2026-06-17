package restaurante.funcionarios;

public abstract class Funcionario {
    protected String nome;
    protected double salario;

    public Funcionario(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
    }

    public abstract void trabalhar();

    public String getNome() {
        return this.nome;
    }

    public double getSalario() {
        return this.salario;
    }
}
