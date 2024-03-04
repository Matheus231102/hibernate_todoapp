package github.matheus.todo.testeusuario;

import github.matheus.todo.model.Usuario;
import github.matheus.todo.service.UsuarioService;

public class InserirUsuarioService {


    public static void main(String[] args) {
        UsuarioService service = new UsuarioService();
        Usuario usuario = new Usuario();
        usuario.setNome("TESTANDO2 USUARIO NOME");
        usuario.setEmail("TESTANDO2 USUARIO EMAIL");
        usuario.setSenha("TESTANDO2 USUARIO SENHA");

        service.incluir(usuario);
    }
}
