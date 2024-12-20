package rolins.forumHub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@SpringBootApplication
public class ForumHubApplication {

	public static void main(String[] args) {

		SpringApplication.run(ForumHubApplication.class, args);
		System.out.println("Hello WOrd!");
	}
	@Configuration
	public class UserDetailsServiceConfig {

		@Bean
		public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
			UserDetails user = User.builder()
					.username("admin")
					.password(passwordEncoder.encode("admin123")) // Senha criptografada
					.roles("USER")
					.build();

			return new InMemoryUserDetailsManager(user); // Usuário armazenado em memória
		}
	}
}
