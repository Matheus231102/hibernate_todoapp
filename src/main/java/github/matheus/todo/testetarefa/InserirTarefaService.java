package github.matheus.todo.testetarefa;

import github.matheus.todo.enums.EnumPrioridadeTarefa;
import github.matheus.todo.model.Tarefa;
import github.matheus.todo.model.Usuario;
import github.matheus.todo.service.TarefaService;
import github.matheus.todo.service.UsuarioService;

import java.time.LocalDateTime;

public class InserirTarefaService {

    public static void main(String[] args) {
        Usuario usuario1 = UsuarioService.buscarPorId(1);
        Usuario usuario2 = UsuarioService.buscarPorId(2);
        Usuario usuario4 = UsuarioService.buscarPorId(4);
        Usuario usuario5 = UsuarioService.buscarPorId(5);
        Usuario usuario6 = UsuarioService.buscarPorId(6);


        Tarefa tarefa1 = new Tarefa();
        // Trecho 1
        tarefa1.setTitulo("Implementar autenticação de usuário");
        tarefa1.setDescricao("Adicionar funcionalidade de login e registro");
        tarefa1.setPrioridade(EnumPrioridadeTarefa.MAXIMA);
        LocalDateTime data1 = LocalDateTime.of(2024, 9, 15, 14, 30);
        tarefa1.setDataVencimento(data1);
        tarefa1.setUsuario(usuario1);

        Tarefa tarefa2 = new Tarefa();
        // Trecho 2
        tarefa2.setTitulo("Atualizar interface do usuário");
        tarefa2.setDescricao("Melhorar a usabilidade e o design da interface");
        tarefa2.setPrioridade(EnumPrioridadeTarefa.MEDIA);
        LocalDateTime data2 = LocalDateTime.of(2024, 9, 20, 9, 0);
        tarefa2.setDataVencimento(data2);
        tarefa2.setUsuario(usuario5);

        Tarefa tarefa3 = new Tarefa();
        // Trecho 3
        tarefa3.setTitulo("Corrigir bug na geração de relatórios");
        tarefa3.setDescricao("Investigar e corrigir problemas na geração de relatórios");
        tarefa3.setPrioridade(EnumPrioridadeTarefa.MAXIMA);
        LocalDateTime data3 = LocalDateTime.of(2024, 9, 25, 16, 45);
        tarefa3.setDataVencimento(data3);
        tarefa3.setUsuario(usuario4);

        Tarefa tarefa4 = new Tarefa();
        // Trecho 4
        tarefa4.setTitulo("Implementar funcionalidade de exportação de dados");
        tarefa4.setDescricao("Permitir que os usuários exportem dados para formatos específicos");
        tarefa4.setPrioridade(EnumPrioridadeTarefa.MEDIA);
        LocalDateTime data4 = LocalDateTime.of(2024, 10, 5, 11, 15);
        tarefa4.setDataVencimento(data4);
        tarefa4.setUsuario(usuario6);

        Tarefa tarefa5 = new Tarefa();
        // Trecho 5
        tarefa5.setTitulo("Concluir documentação do projeto");
        tarefa5.setDescricao("Revisar e finalizar a documentação técnica e de usuário");
        tarefa5.setPrioridade(EnumPrioridadeTarefa.MINIMA);
        LocalDateTime data5 = LocalDateTime.of(2024, 10, 10, 13, 0);
        tarefa5.setDataVencimento(data5);
        tarefa5.setUsuario(usuario6);

        Tarefa tarefa6 = new Tarefa();
        // Trecho 6
        tarefa6.setTitulo("Realizar testes de integração");
        tarefa6.setDescricao("Executar testes abrangentes para garantir a estabilidade do sistema");
        tarefa6.setPrioridade(EnumPrioridadeTarefa.MAXIMA);
        LocalDateTime data6 = LocalDateTime.of(2024, 10, 15, 10, 30);
        tarefa6.setDataVencimento(data6);
        tarefa6.setUsuario(usuario2);

        Tarefa tarefa7 = new Tarefa();
        // Trecho 7
        tarefa7.setTitulo("Aprimorar performance do sistema");
        tarefa7.setDescricao("Identificar e otimizar áreas de desempenho insatisfatório");
        tarefa7.setPrioridade(EnumPrioridadeTarefa.MAXIMA);
        LocalDateTime data7 = LocalDateTime.of(2024, 10, 20, 15, 45);
        tarefa7.setDataVencimento(data7);
        tarefa7.setUsuario(usuario1);

        Tarefa tarefa8 = new Tarefa();
        // Trecho 8
        tarefa8.setTitulo("Implementar funcionalidade de notificações por e-mail");
        tarefa8.setDescricao("Enviar notificações automáticas por e-mail para os usuários");
        tarefa8.setPrioridade(EnumPrioridadeTarefa.MAXIMA);
        LocalDateTime data8 = LocalDateTime.of(2024, 10, 25, 9, 15);
        tarefa8.setDataVencimento(data8);
        tarefa8.setUsuario(usuario5);

        Tarefa tarefa9 = new Tarefa();
        // Trecho 9
        tarefa9.setTitulo("Refatorar código legado");
        tarefa9.setDescricao("Reestruturar código antigo para melhorar sua manutenibilidade");
        tarefa9.setPrioridade(EnumPrioridadeTarefa.MEDIA);
        LocalDateTime data9 = LocalDateTime.of(2024, 10, 30, 14, 0);
        tarefa9.setDataVencimento(data9);
        tarefa9.setUsuario(usuario6);

        Tarefa tarefa10 = new Tarefa();
        // Trecho 10
        tarefa10.setTitulo("Realizar reunião de revisão do projeto");
        tarefa10.setDescricao("Conduzir uma reunião para revisar o progresso e planejar os próximos passos");
        tarefa10.setPrioridade(EnumPrioridadeTarefa.MINIMA);
        LocalDateTime data10 = LocalDateTime.of(2024, 11, 5, 16, 30);
        tarefa10.setDataVencimento(data10);
        tarefa10.setUsuario(usuario4);

        TarefaService.incluir(tarefa1);
        TarefaService.incluir(tarefa2);
        TarefaService.incluir(tarefa3);
        TarefaService.incluir(tarefa4);
        TarefaService.incluir(tarefa5);
        TarefaService.incluir(tarefa6);
        TarefaService.incluir(tarefa7);
        TarefaService.incluir(tarefa8);
        TarefaService.incluir(tarefa9);
        TarefaService.incluir(tarefa10);
    }
}
