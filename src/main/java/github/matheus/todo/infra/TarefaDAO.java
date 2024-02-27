package github.matheus.todo.infra;

import github.matheus.todo.model.Tarefa;
import github.matheus.todo.model.Usuario;
import jakarta.persistence.*;
import org.hibernate.boot.jaxb.internal.stax.BufferedXMLEventReader;

import java.lang.reflect.Type;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

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


    public Tarefa buscarTarefaPorID(int idTarefa) {
        try {
            String jpql = "SELECT T FROM Tarefa T WHERE T.id = :id";

            TypedQuery<Tarefa> query = em.createQuery(jpql, classe);
            query.setParameter("id", idTarefa);

            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }


    public List<Tarefa> buscarTarefasUsuario(Usuario usuario) {
        try {
            String jpql = "SELECT T FROM Tarefa T WHERE T.usuario = :usuario";
            TypedQuery<Tarefa> query = em.createQuery(jpql, classe);

            query.setParameter("usuario", usuario);

            return query.getResultList();
        } catch (Exception e) {
            System.err.println("Erro inesperado: " + e.getMessage());
            return new ArrayList<>();
        }
    }

}
