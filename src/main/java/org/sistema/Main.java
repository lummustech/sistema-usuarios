package org.sistema;

import org.sistema.model.Usuario;
import org.sistema.services.UsuarioService;

public class Main {
    static void main() {

        Usuario ana = new Usuario("Ana", 16, "00421134465");
        Usuario cris = new Usuario("Cris", 22, "00011122212");
        Usuario paulo = new Usuario("paulo", 19, "002223321112");

        UsuarioService usuarioService = new UsuarioService();

        System.out.println(usuarioService.cadastrarUsuario(ana));
        System.out.println(usuarioService.cadastrarUsuario(cris));
        System.out.println(usuarioService.cadastrarUsuario(paulo));

        Usuario semNome = new Usuario("", 20, "12345678901");
        Usuario idadeInvalida = new Usuario("Teste", 200, "12345678901");
        Usuario cpfCurto = new Usuario("Teste", 30, "123");

        System.out.println(usuarioService.cadastrarUsuario(semNome));
        System.out.println(usuarioService.cadastrarUsuario(idadeInvalida));
        System.out.println(usuarioService.cadastrarUsuario(cpfCurto));

        // LISTAR USUARIOS CADASTRADOS
        usuarioService.listarUsuario();

        // FILTRAR POR USUARIOS MAIORES DE IDADE
        usuarioService.filtrarMaiorIdade();
    }
}
