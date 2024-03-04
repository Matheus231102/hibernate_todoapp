package github.matheus.todo.testeusuario;

import github.matheus.todo.model.Usuario;
import github.matheus.todo.service.UsuarioService;

public class RemoverUsuarioService {

    public static void main(String[] args) {
        UsuarioService service = new UsuarioService();
        Usuario usuario = service.buscarPorId(7);

        System.out.println(usuario.getNome());

        service.remover(usuario);

    }
}
