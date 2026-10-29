package ifrn.nc.SigaAi.servicoimoveis.config;



import ifrn.nc.SigaAi.servicoimoveis.model.Role;
import ifrn.nc.SigaAi.servicoimoveis.model.Usuario;
import ifrn.nc.SigaAi.servicoimoveis.repository.UsuariosRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


import ifrn.sigai.servicousuarios.repository.UsuarioRepository;

@Component
@Profile("dev")
public class DataSeed implements CommandLineRunner {

    private final UsuariosRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public DataSeed(UsuariosRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        if (usuarioRepository.count() > 0) {
            System.out.println(">>> Usuários já existem no banco de dados. Pulando criação de usuários de teste.");
            return; // se já tem usuário, não duplica
        }

        Usuario admin = new Usuario();
        admin.setPassword(passwordEncoder.encode("admin123"));
        admin.setRole(Role.ADMIN.name());
        admin.setUsername("admin");
        usuarioRepository.save(admin);

        Usuario cliente = new Usuario();
        cliente.setPassword(passwordEncoder.encode("cliente123"));
        cliente.setRole(Role.CLIENTE.name());
        cliente.setUsername("cliente");
        usuarioRepository.save(cliente);

        System.out.println(">>> Usuários de teste criados: admin/admin123, cliente/cliente123");
    }
}
