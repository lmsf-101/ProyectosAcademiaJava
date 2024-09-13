package academyMty.lmsf.final_project.security.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
	public UserDetailsManager userDetailsManager(DataSource dataSource) {
		return new JdbcUserDetailsManager(dataSource);
	}

	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return http
				.authorizeHttpRequests(config ->
				
						config
						.requestMatchers("/list").hasRole("USER")
						.requestMatchers("/").permitAll()
						.requestMatchers("/h2-console/**").permitAll()
						.anyRequest().authenticated()
						).
				
				formLogin(login ->
						
						login
						.permitAll()).
				
				exceptionHandling(config -> 
				
						config
						.accessDeniedPage("/restricted-access")
						
						).
				
				csrf(csrf ->
						csrf.ignoringRequestMatchers("/h2-console/**")
							
							).headers(config ->
							config.frameOptions(fo ->
									fo.sameOrigin()
									)
				).
				logout(logout ->
					
						logout
						.permitAll()
				)

				.build();
	}
	
}
