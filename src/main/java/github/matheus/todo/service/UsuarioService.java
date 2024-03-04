package github.matheus.todo.service;

import github.matheus.todo.infra.UsuarioDAO;
import github.matheus.todo.model.Usuario;

public class UsuarioService {

    private static UsuarioDAO usuarioDAO;

    static {
        usuarioDAO = new UsuarioDAO(Usuario.class);
    }

    public UsuarioService() {}

    public static Usuario buscarPorId(int idUsuario) {
        try {
            return (Usuario) usuarioDAO.buscarPorId(idUsuario);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean atualizar(Usuario usuario) {
        try {
            usuarioDAO.atualizar(usuario);
            return true;
        } catch (Exception e) {
            System.out.println("Não foi possível atualizar o usuario informado");
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean remover(Usuario usuario) {
        try {
            usuarioDAO.remover(usuario);
            return true;
        } catch (Exception e) {
            System.out.println("Não foi possível remover o usuario informado");
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean incluir(Usuario usuario) {
        try {
            usuarioDAO.incluir(usuario);
            return true;
        } catch (Exception e) {
            System.out.println("Não foi possível incluir o usuario informado");
            System.out.println(e.getMessage());
            return false;
        }
    }



}
