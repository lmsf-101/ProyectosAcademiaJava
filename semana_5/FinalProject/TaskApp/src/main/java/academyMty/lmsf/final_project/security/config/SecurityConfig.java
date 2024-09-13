package academyMty.lmsf.final_project.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {

	
	@Bean
	public InMemoryUserDetailsManager manageUserDetails() {
		
		UserDetails luis = User.builder()
				.username("luis")
				.password("{noop}lmsfxideral")
				.roles("USER")
				.build();
		
		
		return new InMemoryUserDetailsManager(luis);
		
	}
}
