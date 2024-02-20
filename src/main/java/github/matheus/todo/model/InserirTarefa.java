package github.matheus.todo.model;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;

import java.util.Date;

public class InserirTarefa {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("defaultTODOAPPpersistence");
        EntityManager em = emf.createEntityManager();

        int idUsuario = 3;
        try {
            Usuario usuario = em.find(Usuario.class, idUsuario);

            Tarefa tarefa = new Tarefa("ESTUDAR BANCO DE DADOS",
                    "estudar 2 horas de banco de dados na udemy",
                    new Date(2023,02, 20), "max", usuario);

            em.getTransaction().begin();
            em.persist(tarefa);
            em.getTransaction().commit();

        } catch (NoResultException e) {
            System.out.println("USUARIO NAO ENCONTRADO!");
            System.out.println(e);
        }

    }
}
