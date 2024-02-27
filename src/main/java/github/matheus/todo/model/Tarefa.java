package github.matheus.todo.model;

import github.matheus.todo.enums.EnumPrioridadeTarefa;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "TB_TAREFAS")
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TAREFA")
    private long id;

    @Column(name = "TITULO")
    private String titulo;

    @Column(name = "DESCRICAO")
    private String descricao;

    @Column(name = "DATA_VENCIMENTO")
    private Date dataVencimento;

    @Column(name = "PRIORIDADE")

    @Enumerated(EnumType.STRING)
    private EnumPrioridadeTarefa prioridade;

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO")
    private Usuario usuario;

    public Tarefa() {

    }

    public Tarefa(String titulo, String descricao, Date dataVencimento, EnumPrioridadeTarefa prioridade) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataVencimento = dataVencimento;
        this.prioridade = prioridade;
        this.usuario = null;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public EnumPrioridadeTarefa getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(EnumPrioridadeTarefa prioridade) {
        this.prioridade = prioridade;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
