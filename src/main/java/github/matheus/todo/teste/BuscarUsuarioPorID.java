package github.matheus.todo.teste;

import github.matheus.todo.model.Usuario;
import github.matheus.todo.service.UsuarioService;

public class BuscarUsuarioPorID {

    public static void main(String[] args) {
        Usuario user = UsuarioService.buscarUsuarioPorID(1);
        System.out.println(user.getNome());
        System.out.println(user.getSenha());

    }

}
