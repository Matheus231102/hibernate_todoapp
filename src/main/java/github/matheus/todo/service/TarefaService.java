package github.matheus.todo.service;

import github.matheus.todo.infra.TarefaDAO;
import github.matheus.todo.infra.UsuarioDAO;
import github.matheus.todo.model.Tarefa;
import github.matheus.todo.model.Usuario;
import jakarta.persistence.NoResultException;

import java.security.InvalidParameterException;
import java.util.List;

public class TarefaService {

    private static TarefaDAO tarefaDAO;
    private static UsuarioDAO usuarioDAO;

    static {
        tarefaDAO = new TarefaDAO<>(Tarefa.class);
        usuarioDAO = new UsuarioDAO(Usuario.class);
    }

    public TarefaService() {}

    public static List<Tarefa> buscarTarefasUsuarioPorID(int idUsuario) throws Exception {
        Usuario usuario = null;
        try {
            if (idUsuario <= 0) {
                throw new InvalidParameterException("id do usuarios não pode ser 0 ou negativo");
            }

            usuario = (Usuario) usuarioDAO.buscarUsuarioPorID(idUsuario);

        } catch (InvalidParameterException invalidParameterException) {
            invalidParameterException.printStackTrace();
            System.out.println(invalidParameterException.getMessage());

        } catch (NoResultException noResultException) {
            System.out.println(noResultException.getMessage());
            noResultException.printStackTrace();

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            exception.printStackTrace();

        }

        List<Tarefa> tarefas = null;
        try {
            tarefas = tarefaDAO.buscarTarefasUsuario(usuario);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return tarefas;
    }


    public static boolean buscarUsuarioInserirTarefa(int idUsuario, Tarefa tarefa) {

        try {
            if (idUsuario <= 0 || tarefa == null) {
                throw new InvalidParameterException("parâmetros passados estão incorretos");
            }

            Usuario usuario = (Usuario) usuarioDAO.buscarUsuarioPorID(idUsuario);
            tarefa.setUsuario(usuario);
            tarefaDAO.incluirAtomico(tarefa);

            return true;
        } catch (InvalidParameterException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return false;
    }

    public static boolean buscarTarefaPorIdAlterarDescricao(int idTarefa, String novaDescricao) {
        Tarefa tarefa = (Tarefa) tarefaDAO.buscarTarefaPorID(idTarefa);
        tarefaDAO.alterarDescricaoTarefa(tarefa, novaDescricao);
        return true;
    }
}
