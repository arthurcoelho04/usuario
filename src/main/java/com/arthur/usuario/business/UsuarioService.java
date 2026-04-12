package com.arthur.usuario.business;

import com.arthur.usuario.business.Converter.UsuarioConverter;
import com.arthur.usuario.business.dto.UsuarioDTO;
import com.arthur.usuario.infrastructure.entity.Usuario;
import com.arthur.usuario.infrastructure.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioConverter usuarioConverter;

    public UsuarioDTO salvarUsuario(UsuarioDTO usuarioDTO){
        Usuario usuario = usuarioConverter.paraUsuario(usuarioDTO);
        return  usuarioConverter.paraUsuarioDTO(usuarioRepository.save(usuario));

    }

}
