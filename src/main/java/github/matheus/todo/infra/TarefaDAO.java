package github.matheus.todo.infra;

import github.matheus.todo.model.Tarefa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class TarefaDAO<Tarefa> {
    private static EntityManagerFactory emf;
    private EntityManager em;
    private Class<Tarefa> classe;

    static {
        try {
            emf = Persistence.createEntityManagerFactory("defaultTODOAPPpersistence");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public TarefaDAO() {
        this(null);
    }

    public TarefaDAO(Class<Tarefa> classe) {
        this.classe = classe;
        em = emf.createEntityManager();
    }

    public TarefaDAO<Tarefa> abrirT() {
        em.getTransaction().begin();
        return this;
    }

    public TarefaDAO<Tarefa> fecharT() {
        em.getTransaction().commit();
        return this;
    }

    public TarefaDAO<Tarefa> incluir(Tarefa entidade) {
        em.persist(entidade);
        return this;
    }

    public TarefaDAO<Tarefa> incluirAtomico(Tarefa tarefa) {
        return this.abrirT().incluir(tarefa).fecharT();
    }

    public void fechar() {
        em.close();
    }

}
