package github.matheus.todo.service;

import github.matheus.todo.infra.TarefaDAO;
import github.matheus.todo.model.Tarefa;

public class TarefaService {

    private static TarefaDAO tarefaDAO;

    static {
        tarefaDAO = new TarefaDAO<>(Tarefa.class);
    }

    public TarefaService() {}

    public static Tarefa buscarPorId(int idTarefa) {
        try {
            return (Tarefa) tarefaDAO.buscarTarefaPorId(idTarefa);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean atualizar(Tarefa tarefa) {
        try {
            tarefaDAO.atualizar(tarefa);
            return true;

        } catch (Exception e) {
            System.out.println("Não foi possível atualizar a tarefa informada");
            System.out.println(e.getMessage());
            return false;

        }
    }

    public static boolean remover(Tarefa tarefa) {
        try {
            tarefaDAO.remover(tarefa);
            return true;

        } catch (Exception e) {
            System.out.println("Não foi possível remover a tarefa informada");
            System.out.println(e.getMessage());
            return false;

        }
    }

    public static boolean incluir(Tarefa tarefa) {
        try {
            tarefaDAO.incluir(tarefa);
            return true;

        } catch (Exception e) {
            System.out.println("Não foi possível incluir a tarefa informada");
            System.out.println(e.getMessage());
            return false;

        }
    }

}
