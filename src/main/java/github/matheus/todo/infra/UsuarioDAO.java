package github.matheus.todo.infra;

import jakarta.persistence.*;

import java.util.List;

public class UsuarioDAO<Usuario>{

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

    public UsuarioDAO<Usuario> abrirT() {
        em.getTransaction().begin();
        return this;
    }

    public UsuarioDAO<Usuario> fecharT() {
        em.getTransaction().commit();
        return this;
    }

    public UsuarioDAO<Usuario> incluir(Usuario entidade) {
        em.persist(entidade);
        return this;
    }

    public UsuarioDAO<Usuario> incluirAtomico(Usuario entidade) {
        return this.abrirT().incluir(entidade).fecharT();
    }

    public void fechar() {
        em.close();
    }

    public List<Usuario> obterTodosUsuarios(int quantidade, int deslocamento) {
        if (classe == null) {
            throw new UnsupportedOperationException("a classe está nula, por isso não é possível manter a operação");
        }

        String jpql = "select e from " + classe.getSimpleName() + " e";
        TypedQuery<Usuario> query = em.createQuery(jpql, classe);
        query.setMaxResults(quantidade);
        query.setFirstResult(deslocamento);
       return query.getResultList();
    }

    public List<Usuario> obterTodosUsuarios() {
        return obterTodosUsuarios(1000, 0);
    }

    public Usuario buscarUsuarioPorID(int idUsuario) throws NoResultException {
        try {
            String jpql = "SELECT U FROM Usuario U WHERE U.id = :id";

            TypedQuery<Usuario> query = em.createQuery(jpql, classe);
            query.setParameter("id", idUsuario);

            return query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }


}
