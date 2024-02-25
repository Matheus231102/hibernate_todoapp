package github.matheus.todo.teste;

import github.matheus.todo.enums.EnumPrioridadeTarefa;
import github.matheus.todo.infra.TarefaDAO;
import github.matheus.todo.infra.UsuarioDAO;
import github.matheus.todo.model.Tarefa;
import github.matheus.todo.model.Usuario;

import java.util.Date;

public class InserirRegistro {

    public static void main(String[] args) {
        Usuario usuario = new Usuario("matheus badia", "matheusbadia23@gmail", "231102", new Date());
        Tarefa tarefa = new Tarefa("Trabalhar", "trabalhando em programação", new Date(2024, 02, 25), EnumPrioridadeTarefa.MINIMA, usuario);

        UsuarioDAO usuariodao = new UsuarioDAO(Usuario.class);
        usuariodao.incluirAtomico(usuario);
        usuariodao.fechar();

        TarefaDAO tarefadao = new TarefaDAO(Tarefa.class);
        tarefadao.incluirAtomico(tarefa);
        tarefadao.fechar();

        System.out.println("finalizado");
    }
}
