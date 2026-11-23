package org.sistema.services;

import java.util.ArrayList;
import java.util.List;

import org.sistema.model.Usuario;

public class UsuarioService {

    private List<Usuario> usuarios = new ArrayList<>();

    public String cadastrarUsuario(Usuario usuario) {
        if (usuario.getNome() == null || usuario.getNome().isBlank()) {
            return "Nome do usuário é obrigatório.";
        }
        if (usuario.getIdade() == null || usuario.getIdade() < 0 || usuario.getIdade() > 150) {
            return "Idade inválida: deve estar entre 0 e 150.";
        }
        if (usuario.getCpf() == null || !usuario.getCpf().matches("\\d{11}")) {
            return "CPF inválido: deve ter 11 dígitos numéricos.";
        }
        usuarios.add(usuario);
        return "Usuário cadastrado com sucesso.";
        
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