package github.matheus.todo.testetarefa;

import github.matheus.todo.model.Tarefa;
import github.matheus.todo.service.TarefaService;

public class RemoverTarefaService {

    public static void main(String[] args) {
        Tarefa tarefa = TarefaService.buscarPorId(18);
        TarefaService.remover(tarefa);
    }
}
