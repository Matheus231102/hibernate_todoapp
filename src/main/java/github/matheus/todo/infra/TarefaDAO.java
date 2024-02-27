package github.matheus.todo.infra;

import github.matheus.todo.model.Usuario;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

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


    public Tarefa buscarTarefaPorID(int idTarefa) throws IllegalArgumentException {
        try {
            if (idTarefa <= 0) {
                throw new IllegalArgumentException("o valor do id da tarefa não pode ser nulo ou negativo");
            }

            String jpql = "SELECT T FROM Tarefa T WHERE T.id = :id";

            TypedQuery<Tarefa> query = em.createQuery(jpql, classe);
            query.setParameter("id", idTarefa);

            return query.getSingleResult();
        } catch (NoResultException noResultException) {

            System.out.println(noResultException.getMessage());
            noResultException.printStackTrace();
            return null;

        } catch (IllegalArgumentException illegalArgumentException) {

            System.out.println(illegalArgumentException.getMessage());
            illegalArgumentException.printStackTrace();
            return null;
        }
    }


    public List<Tarefa> buscarTarefasUsuario(Usuario usuario) throws NoResultException  {
        try {
            String jpql = "SELECT T FROM Tarefa T WHERE T.usuario = :usuario";
            TypedQuery<Tarefa> query = em.createQuery(jpql, classe);

            query.setParameter("usuario", usuario);

            return query.getResultList();

        } catch (NoResultException e) {

            System.err.println("nenhum registro foi buscado: " + e.getMessage());
            e.printStackTrace();
            return new ArrayList<>();

        } catch (Exception e) {

            System.err.println("ocorreu um erro na busca de tarefas do usuario: " + e.getMessage());
            e.printStackTrace();
            return new ArrayList<>();

        }
    }

    public boolean alterarDescricaoTarefa(Tarefa tarefa, String novaDescricao) {
        try {
            String jpql = "UPDATE Tarefa T SET T.descricao = :descricao WHERE T = :tarefa";
            Query query = em.createQuery(jpql);

            query.setParameter("descricao", novaDescricao);
            query.setParameter("tarefa", tarefa);

            em.getTransaction().begin();
            int affectedRows = query.executeUpdate();
            em.getTransaction().commit();

            return affectedRows >  0;

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return false;
    }

}
