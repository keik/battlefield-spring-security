package info.keik.sandbox.bss.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.csrf()
				.disable()

				.authorizeRequests()
				.antMatchers(HttpMethod.POST, "/method_authentication_1").authenticated()

				.antMatchers(HttpMethod.GET, "/method_authentication_2").authenticated()

				.anyRequest().permitAll()

				.and()
				.formLogin().loginPage("/login").loginProcessingUrl("/session").permitAll()
				.usernameParameter("id").passwordParameter("password")

				.and()
				.logout().logoutUrl("/logout").logoutSuccessUrl("/");

	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth
				.inMemoryAuthentication()
				.withUser("a").password("a").roles("ADMIN");
	}
}
