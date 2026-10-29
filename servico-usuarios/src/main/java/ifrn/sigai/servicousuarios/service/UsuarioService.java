package ifrn.sigai.servicousuarios.service;

import org.springframework.stereotype.Service;

import ifrn.sigai.servicousuarios.dto.UsuarioResponseDTO;
import ifrn.sigai.servicousuarios.exception.UsuarioNaoEncontradoException;
import ifrn.sigai.servicousuarios.repository.UsuarioRepository;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioResponseDTO buscarPorId(Long id) {
        return usuarioRepository.findById(id)
            .map(UsuarioResponseDTO::from)
            .orElseThrow(() -> new UsuarioNaoEncontradoException(id));
    }
}
