package carrental;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;




/**
 * 
 * CSRFに対処したコードを書きたいが未実装　
 * まだ時間があるので実装まで持っていきたい
 * 
 * @author Tanaka
 *
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();//暗号化
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
		.formLogin(login -> login 
				.loginProcessingUrl("/login")
				.loginPage("/loginForm") 
				.defaultSuccessUrl("/reserve", true)
				.failureUrl("/loginForm?error")
				.permitAll()
		).logout(logout -> logout
				.logoutSuccessUrl("/loginForm")
		).authorizeHttpRequests(authz -> authz
						.requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
						.requestMatchers("/").permitAll()
						.requestMatchers("/reserve").permitAll()
						.requestMatchers("/signup").permitAll()
						.requestMatchers("/admin/**").hasRole("ADMIN")
						.anyRequest().authenticated());
		
		 return http.build();
	}
	

//
//	@Bean
//	public JdbcUserDetailsManager userDetailesManager() {
//		String username = "fullnameId";
//		String password = "password";
//		
//		UserDetails user = User.withUsername(username)
//				.password(
//				PasswordEncoderFactories
//					.createDelegatingPasswordEncoder()
//					.encode(password))
//				.roles("USER")
//				.build();
//		return new JdbcUserDetailsManager((DataSource) user);
//	}
}


//@SuppressWarnings("removal")
//.addFilterBefore(new CharacterEncodingFilter("UTF-8",true),CsrfFilter.class)
//.csrf()
//.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
//.and()


