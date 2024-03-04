package github.matheus.todo.testetarefa;

import github.matheus.todo.enums.EnumPrioridadeTarefa;
import github.matheus.todo.model.Tarefa;
import github.matheus.todo.service.TarefaService;

import java.time.LocalDateTime;

public class AlterarAtributosTarefaService {

    public static void main(String[] args) {
        Tarefa tarefa = TarefaService.buscarPorId(6);
        LocalDateTime novadata = LocalDateTime.of(2025, 05, 12, 12, 23);

        tarefa.setTitulo("FOI DENOVO TITULO");
        tarefa.setDescricao("DESCRICAO LEGAL");
        tarefa.setPrioridade(EnumPrioridadeTarefa.MAXIMA);
        tarefa.setDataVencimento(novadata);

        TarefaService.atualizar(tarefa);
    }
}
