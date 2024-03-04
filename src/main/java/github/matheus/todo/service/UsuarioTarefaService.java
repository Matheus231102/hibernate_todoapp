package github.matheus.todo.service;

import github.matheus.todo.model.Tarefa;
import github.matheus.todo.model.Usuario;

public class UsuarioTarefaService {

    static {
        TarefaService tarefaService = new TarefaService();
        UsuarioService usuarioService = new UsuarioService();
    }

    public UsuarioTarefaService() {
    }

    public static void inserirTarefaUsuario(Tarefa tarefa, Usuario usuario) {
        tarefa.setUsuario(usuario);
    }


}
