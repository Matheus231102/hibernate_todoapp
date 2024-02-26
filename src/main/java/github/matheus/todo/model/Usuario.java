package github.matheus.todo.model;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity()
@Table(name = "TB_USUARIOS")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_USUARIO")
    private long id;

    @Column(name = "NOME", nullable = false)
    private String nome;

    @Column(name = "EMAIL", nullable = false, unique = true)
    private String email;

    @Column(name = "SENHA")
    private String senha;

    @Column(name = "DATA_INSERCAO_USUARIO")
    private Date dataInsercaoUsuario;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    private List<Tarefa> tarefas = new ArrayList<>();

    public Usuario() {

    }

    public Usuario(String nome, String email, String senha, Date dataInsercaoUsuario) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.dataInsercaoUsuario = dataInsercaoUsuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Tarefa> getTarefas() {
        return tarefas;
    }

    public void setTarefas(List<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }

    public Date getDataInsercaoUsuario() {
        return dataInsercaoUsuario;
    }

    public void setDataInsercaoUsuario(Date dataInsercaoUsuario) {
        this.dataInsercaoUsuario = dataInsercaoUsuario;
    }
}

