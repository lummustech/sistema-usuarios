package org.sistema;

import org.sistema.model.Usuario;
import org.sistema.services.UsuarioService;

public class Main {
    static void main() {

        Usuario ana = new Usuario("Ana", 16, "00421134465");
        Usuario cris = new Usuario("Cris", 22, "00011122212");
        Usuario paulo = new Usuario("paulo", 19, "002223321112");

        UsuarioService usuarioService = new UsuarioService();

        usuarioService.cadastrarUsuario(ana);
        usuarioService.cadastrarUsuario(cris);
        usuarioService.cadastrarUsuario(paulo);

        // LISTAR USUARIOS CADASTRADOS
        usuarioService.listarUsuario();

        // FILTRAR POR USUARIOS MAIORES DE IDADE

    }
}
