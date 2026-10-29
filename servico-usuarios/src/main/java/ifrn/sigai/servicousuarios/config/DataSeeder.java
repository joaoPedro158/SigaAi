package ifrn.sigai.servicousuarios.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import ifrn.sigai.servicousuarios.model.Role;
import ifrn.sigai.servicousuarios.model.Usuario;
import ifrn.sigai.servicousuarios.repository.UsuarioRepository;

@Component
@Profile("dev")
public class DataSeeder implements CommandLineRunner {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public DataSeeder(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        if (usuarioRepository.count() > 0) {
            System.out.println(">>> Usuários já existem no banco de dados. Pulando criação de usuários de teste.");
            return; // se já tem usuário, não duplica
        }

        Usuario admin = new Usuario("Administrador", "admin", passwordEncoder.encode("admin123"), Role.ADMIN);
        usuarioRepository.save(admin);

        Usuario cliente = new Usuario("Cliente de Teste", "cliente", passwordEncoder.encode("cliente123"), Role.CLIENTE);
        usuarioRepository.save(cliente);

        System.out.println(">>> Usuários de teste criados: admin/admin123, cliente/cliente123");
    }
}
