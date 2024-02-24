package github.matheus.todo.teste;

import github.matheus.todo.model.Tarefa;
import github.matheus.todo.model.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Calendar;
import java.util.Date;

public class Inserir {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("defaultTODOAPPpersistence");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Usuario usuario1 = new Usuario("matheus", "matheusbadia23@example.com", "231102", new Date());
        em.persist(usuario1);

        Tarefa tarefa1 = new Tarefa("tarefa 1", "fazer compras de carne", new Date(2023, Calendar.FEBRUARY, 24), "min", usuario1);
        em.persist(tarefa1);

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
