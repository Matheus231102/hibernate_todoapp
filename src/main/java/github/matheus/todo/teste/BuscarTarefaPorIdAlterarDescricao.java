package github.matheus.todo.teste;

import github.matheus.todo.service.TarefaService;

public class BuscarTarefaPorIdAlterarDescricao {

    public static void main(String[] args) {
        String novaDescricao = "TESTANDO ARROMB< CARALHO!";
        TarefaService.buscarTarefaPorIdAlterarDescricao(7, novaDescricao);

        String novaDescricao2 = "VAI TOMAR NO CU";
        TarefaService.buscarTarefaPorIdAlterarDescricao(8, novaDescricao2);
    }

}
