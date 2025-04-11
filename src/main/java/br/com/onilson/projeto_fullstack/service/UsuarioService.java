package br.com.onilson.projeto_fullstack.service;

import br.com.onilson.projeto_fullstack.dto.UsuarioDTO;
import br.com.onilson.projeto_fullstack.entity.Usuario;
import br.com.onilson.projeto_fullstack.entity.UsuarioCheck;
import br.com.onilson.projeto_fullstack.entity.enums.TipoSituacaoUsuario;
import br.com.onilson.projeto_fullstack.repository.UsuarioCheckRepository;
import br.com.onilson.projeto_fullstack.repository.UsuarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final EmailService emailService;
    private final UsuarioCheckRepository usuarioCheckRepository;

    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder,
                          EmailService emailService, UsuarioCheckRepository usuarioCheckRepository) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
        this.emailService= emailService;
        this.usuarioCheckRepository = usuarioCheckRepository;
    }

    public List<UsuarioDTO> listarTodas() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream().map(UsuarioDTO::new).toList();
    }

    public void inserir(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario(usuarioDTO);
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        usuarioRepository.save(usuario);
    }

    public void inserirNovoUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario(usuarioDTO);
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        usuario.setSituacao(TipoSituacaoUsuario.PENDENTE);
        usuario.setId(null);
        usuarioRepository.save(usuario);

        UsuarioCheck check = new UsuarioCheck();
        check.setUsuario(usuario);
        check.setUuid(UUID.randomUUID());
        check.setDataExpiracao(Instant.now().plusMillis(900000));
        usuarioCheckRepository.save(check);

        emailService.enviarEmailDestinatario(usuario.getEmail(), "Novo usuário cadastrado",
                "Você está recebendo um email de cadastro e o n° de validação é " + check.getUuid());
    }

    public String checarCadastro(String uuid) {
        System.out.println(uuid);
        Optional<UsuarioCheck>  usuarioCheck = usuarioCheckRepository.findByUuid(UUID.fromString(uuid));
        if (usuarioCheck != null) {
            if(usuarioCheck.get().getDataExpiracao().compareTo(Instant.now()) >= 0) {
                Usuario usuario = usuarioCheck.get().getUsuario();
                usuario.setSituacao(TipoSituacaoUsuario.ATIVO);
                usuarioRepository.save(usuario);

                return "Usuário verificado";
            }else {
                usuarioCheckRepository.delete(usuarioCheck.get());
                return "Tempo de verificação expirado";
            }
        } else {
            return "Usuário não verificado";
        }
    }

    public UsuarioDTO alterar(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario(usuarioDTO);
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        return new UsuarioDTO(usuarioRepository.save(usuario));
    }

    public void excluir(Long id) {
        Usuario usuario = usuarioRepository.findById(id).get();
        usuarioRepository.delete(usuario);
    }

    public UsuarioDTO buscarPorId(Long id) {
        return new UsuarioDTO(usuarioRepository.findById(id).get());
    }
}
