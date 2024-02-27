package github.matheus.todo.service;

import github.matheus.todo.infra.TarefaDAO;
import github.matheus.todo.infra.UsuarioDAO;
import github.matheus.todo.model.Tarefa;
import github.matheus.todo.model.Usuario;

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

    public static List<Tarefa> buscarTarefasUsuarioPorID(int idUsuario) {
        Usuario usuario = (Usuario) usuarioDAO.buscarUsuarioPorID(idUsuario);
        List<Tarefa> tarefas = tarefaDAO.buscarTarefasUsuario(usuario);
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

}
