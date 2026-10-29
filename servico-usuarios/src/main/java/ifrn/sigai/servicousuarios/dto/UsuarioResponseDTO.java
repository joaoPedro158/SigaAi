package ifrn.sigai.servicousuarios.dto;

import ifrn.sigai.servicousuarios.model.Role;
import ifrn.sigai.servicousuarios.model.Usuario;

public record UsuarioResponseDTO(String nome, String username, Role papel) {

    public static UsuarioResponseDTO from(Usuario usuario) {
        return new UsuarioResponseDTO(usuario.getNome(), usuario.getUsername(), usuario.getRole());
    }
}
