package github.matheus.todo.infra;

import jakarta.persistence.*;

import java.util.List;

public class UsuarioDAO<Usuario> {

    private static EntityManagerFactory emf;
    private EntityManager em;
    private Class<Usuario> classe;

    static {
        try {
            emf = Persistence.createEntityManagerFactory("defaultTODOAPPpersistence");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public UsuarioDAO() {
        this(null);
    }

    public UsuarioDAO(Class<Usuario> classe) {
        this.classe = classe;
        em = emf.createEntityManager();
    }

    /*Métodos privados*/
    private UsuarioDAO<Usuario> abrirT() {
        em.getTransaction().begin();
        return this;
    }

    private UsuarioDAO<Usuario> fecharT() {
        em.getTransaction().commit();
        return this;
    }

    private void fechar() {
        em.close();
    }

    private UsuarioDAO<Usuario> incluirT(Usuario entidade) {
        em.persist(entidade);
        return this;
    }

    private UsuarioDAO<Usuario> atualizarT(Usuario usuario) {
        em.merge(usuario);
        return this;
    }

    private UsuarioDAO<Usuario> removerT(Usuario usuario) {
        em.remove(usuario);
        return this;
    }


    /*Métodos públicos*/
    public Usuario buscarPorId(int idUsuario) {
        try {
            String jpql = "SELECT U FROM Usuario U WHERE U.id = :id";

            TypedQuery<Usuario> query = em.createQuery(jpql, classe);
            query.setParameter("id", idUsuario);
            return query.getSingleResult();

        } catch (NoResultException e) {
            System.out.println("Usuário com o ID " + idUsuario + " não encontrado.");
            return null;

        } catch (IllegalArgumentException e) {
            System.out.println("Argumento inválido");
            return null;

        }
    }

    public UsuarioDAO<Usuario> atualizar(Usuario usuario) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try {
            em.merge(usuario);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            System.out.println("Erro ao atualizar o usuário: " + e.getMessage());
        }
        return this;
    }

    public UsuarioDAO<Usuario> incluir(Usuario usuario) {
        return abrirT().incluirT(usuario).fecharT();
    }

    public UsuarioDAO<Usuario> remover(Usuario usuario) {
        return abrirT().removerT(usuario).fecharT();
    }


    public List<Usuario> obterTodos(int quantidade, int deslocamento) {
        if (classe == null) {
            throw new UnsupportedOperationException("a classe está nula, por isso não é possível manter a operação");
        }

        String jpql = "select U from Usuario U";
        TypedQuery<Usuario> query = em.createQuery(jpql, classe);
        query.setMaxResults(quantidade);
        query.setFirstResult(deslocamento);
       return query.getResultList();
    }

    public List<Usuario> obterTodos() {
        return obterTodos(1000, 0);
    }

}
