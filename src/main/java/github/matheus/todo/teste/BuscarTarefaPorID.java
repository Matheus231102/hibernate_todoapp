package github.matheus.todo.teste;

import github.matheus.todo.model.Tarefa;
import github.matheus.todo.service.TarefaService;

public class BuscarTarefaPorID {

    public static void main(String[] args) {
        Tarefa tarefa = TarefaService.buscarTarefaPorID(7);
        System.out.println(tarefa.getDescricao());
    }

}
