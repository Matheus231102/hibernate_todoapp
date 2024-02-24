package github.matheus.todo.infra;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

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

    public UsuarioDAO<Usuario> teste() {
        return this;
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

    public List<Usuario> obterTodos(int quantidade, int deslocamento) {
        if (classe == null) {
            throw new UnsupportedOperationException("A classe está nula!");
        }

        String jpql = "select e from " + classe.getSimpleName() + " e";
        TypedQuery<Usuario> query = em.createQuery(jpql, classe);
        query.setMaxResults(quantidade);
        query.setFirstResult(deslocamento);
       return query.getResultList();
    }

    public List<Usuario> obterTodos() {
        return obterTodos(1000, 0);
    }

    public void fechar() {
        em.close();
    }

}
