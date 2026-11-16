package org.sistema.services;

import java.util.ArrayList;
import java.util.List;

import org.sistema.model.Usuario;

public class UsuarioService {

    private List<Usuario> usuarios = new ArrayList<>();

    public void cadastrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void listarUsuario() {
        for (Usuario u : usuarios) {
            System.out.println(u.getNome());
        }
    }

    public void filtrarMaiorIdade() {
        System.out.println("\nUsuários maiores de idade:");
        System.out.println("--------------------------");
        for (Usuario u : usuarios) {
            if(u.getIdade() >= 18){
                System.out.println(u.getNome());
            }
        }
        System.out.println("--------------------------");
    }

}