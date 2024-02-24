package github.matheus.todo.teste;

import github.matheus.todo.infra.UsuarioDAO;
import github.matheus.todo.model.Usuario;

import java.util.Date;


public class NovoUsuario {

    public static void main(String[] args) {
        UsuarioDAO<Usuario> usuarioDAO = new UsuarioDAO<>();
        Usuario usuario = new Usuario("Matheus de souza", "matehsu@23", "97213", new Date());

        usuarioDAO.incluirAtomico(usuario);
    }
}
