package github.matheus.todo.teste;

import github.matheus.todo.enums.EnumPrioridadeTarefa;
import github.matheus.todo.model.Tarefa;
import github.matheus.todo.service.TarefaService;

import java.util.Date;

public class BuscarUsuarioInserirTarefa {

    public static void main(String[] args) {
        Tarefa tarefa = new Tarefa(
                "nome tarefa teste",
                "comprar",
                new Date(2024, 02, 29),
                EnumPrioridadeTarefa.MINIMA
        );
        TarefaService.buscarUsuarioInserirTarefa(1, tarefa);

    }
}
