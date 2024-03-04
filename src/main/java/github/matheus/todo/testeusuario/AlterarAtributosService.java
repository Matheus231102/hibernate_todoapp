package github.matheus.todo.testeusuario;

import github.matheus.todo.model.Usuario;
import github.matheus.todo.service.UsuarioService;

public class AlterarAtributosService {

    public static void main(String[] args) {
        Usuario usuario = UsuarioService.buscarPorId(1);
        usuario.setNome("ESSE É MEU NOME AGORA");
        usuario.setEmail("ESSE É MEU EMAIL AGORA");
        usuario.setSenha("@#@332332");
        UsuarioService.atualizar(usuario);
        System.out.println("***************");
    }
}
