package github.matheus.spring.model.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "tb_produtos")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String nome;


    @Column
    private Double preco;

    @Column
    private Double desconto;

    public Produto() {}

    public Produto(String nome, Double preco, Double desconto) {
        setNome(nome);
        setDesconto(desconto);
        setPreco(preco);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {

        this.desconto = desconto;
    }
}
