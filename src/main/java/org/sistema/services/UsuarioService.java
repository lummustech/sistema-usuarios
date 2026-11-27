package org.sistema.services;

import java.util.ArrayList;
import java.util.List;

import org.sistema.model.Usuario;

public class UsuarioService {

    private List<Usuario> usuarios = new ArrayList<>();

    public String cadastrarUsuario(Usuario usuario) {
        if (usuario.getNome() == null || usuario.getNome().isBlank()) {
            return "\nNome do usuário é obrigatório.";
        }
        if (usuario.getIdade() == null || usuario.getIdade() < 0 || usuario.getIdade() > 150) {
            return "\nIdade inválida: deve estar entre 0 e 150.";
        }
        if(usuario.getIdade() < 5){
            return "\nIdade mínima permitida para cadastro é 5 anos.";
        }
        if (usuario.getCpf() == null || !usuario.getCpf().matches("\\d{11}")) {
            return "\nCPF inválido: deve ter 11 dígitos numéricos.";
        }else{
            for (Usuario u : usuarios) {
                if(usuario.getCpf().equals(u.getCpf())){
                    return "\nCPF já possui cadastrado no sistema!";
                }
            }
        }
        usuarios.add(usuario);
        return "\nUsuário cadastrado com sucesso.";
        
    }

    public void listarUsuario() {
        System.out.println();
        System.out.println("\nLista de usuários:");
        System.out.println("--------------------------");
        for (Usuario u : usuarios) {
            System.out.println(u.getNome());
        }
        System.out.println("--------------------------");
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