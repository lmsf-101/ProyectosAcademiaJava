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

	
	// Set up the data source where the list of users are stored in:
	@Bean
	public UserDetailsManager userDetailsManager(DataSource dataSource) {
		// Work with a JDBC-based user details manager:
		return new JdbcUserDetailsManager(dataSource);
	}

	
	// Security-related settings to configure to relevant project resources:
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return http
				// Set up authorization for HTTP requests
				.authorizeHttpRequests(config ->
				
						config
						.requestMatchers("/list", "/list/**").hasRole("USER") // The list of tasks can only be accessed by users with the USER role
						.requestMatchers("/").permitAll() // Allow anyone to access the index page.
						.anyRequest().authenticated() // Any other requests should be authenticated
						).
				
				// Add the login page and enable its access to everyone:
				formLogin(login ->
						
						login
						.permitAll()).
				
				// Add the denied page
				exceptionHandling(config -> 
				
						config
						.accessDeniedPage("/restricted-access")
						
						).
		/*		
				csrf(csrf ->
						csrf.ignoringRequestMatchers("/h2-console/**")
							
							).headers(config ->
							config.frameOptions(fo ->
									fo.sameOrigin()
									)
				).*/
				// Finally, add the logout feature to the application:
				logout(logout ->
					
						logout
						.permitAll()
				)

				.build();
	}
	
}
