package github.matheus.todo.model;

import jakarta.persistence.*;

@Entity(name = "senha")
public class Senha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_SENHA") // verificar código;
    private long id;

    @Column(name = "VALOR")
    private String valor;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Usuario usuario;

    public Senha() {

    }

    public Senha(String valor, Usuario usuario) {
        this.valor = valor;
        this.usuario = usuario;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
