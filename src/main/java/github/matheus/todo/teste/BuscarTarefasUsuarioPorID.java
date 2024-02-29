package github.matheus.todo.teste;

import github.matheus.todo.model.Tarefa;
import github.matheus.todo.service.TarefaService;

import java.util.List;

public class BuscarTarefasUsuarioPorID {

    public static void main(String[] args) throws Exception {
        List<Tarefa> tarefas = TarefaService.buscarTarefasUsuarioPorID(1);
        for (Tarefa tarefa : tarefas) {
            System.out.println("Tarefa título: " + tarefa.getTitulo() + " / Descrição>: " + tarefa.getDescricao());
        }

    }

}
