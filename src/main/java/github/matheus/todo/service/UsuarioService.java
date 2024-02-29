package github.matheus.todo.service;

import github.matheus.todo.infra.TarefaDAO;
import github.matheus.todo.infra.UsuarioDAO;
import github.matheus.todo.model.Tarefa;
import github.matheus.todo.model.Usuario;

public class UsuarioService {

    private static TarefaDAO tarefaDAO;
    private static UsuarioDAO usuarioDAO;

    static {
        tarefaDAO = new TarefaDAO<>(Tarefa.class);
        usuarioDAO = new UsuarioDAO(Usuario.class);
    }

    public UsuarioService() {}

    public static Usuario buscarUsuarioPorID(int idUsuario) {
        return (Usuario) usuarioDAO.buscarUsuarioPorID(idUsuario);
    }
}
