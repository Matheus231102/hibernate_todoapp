package github.matheus.todo.infra;

import jakarta.persistence.*;

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

    /*MÉTODOS PRIVADOS*/
    private TarefaDAO<Tarefa> abrirT() {
        em.getTransaction().begin();
        return this;
    }

    private TarefaDAO<Tarefa> fecharT() {
        em.getTransaction().commit();
        return this;
    }

    private TarefaDAO<Tarefa> incluirT(Tarefa entidade) {
        em.persist(entidade);
        return this;
    }

    private TarefaDAO<Tarefa> atualizarT(Tarefa tarefa) {
        em.merge(tarefa);
        return this;
    }

    private TarefaDAO<Tarefa> removerT(Tarefa tarefa) {
        em.remove(tarefa);
        return this;
    }

    /*MÉTODOS PÚBLICOS*/
    public void fechar() {
        em.close();
    }

    public Tarefa buscarTarefaPorId(int idTarefa) throws IllegalArgumentException {
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

    public TarefaDAO<Tarefa> atualizar(Tarefa tarefa) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try {
            em.merge(tarefa);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            System.out.println("Erro ao atualizar o tarefa: " + e.getMessage());
        }
        return this;
    }

    public TarefaDAO<Tarefa> incluir(Tarefa tarefa) {
        return this.abrirT().incluirT(tarefa).fecharT();
    }

    public TarefaDAO<Tarefa> remover(Tarefa tarefa) {
        return this.abrirT().removerT(tarefa).fecharT();
    }

}
