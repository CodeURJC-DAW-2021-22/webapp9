package urjc.gamelink.Configuration.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import urjc.gamelink.Configuration.Security.jwt.JwtRequestFilter;

@Configuration
@Order(1)
public class RestSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private JwtRequestFilter jwtRequestFilter;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
	}

	//Expose AuthenticationManager as a Bean to be used in other services
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.antMatcher("/api/**");
		
		// URLs that need authentication to access to it
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/users/").hasAnyRole("ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/users/").not().hasAnyRole("USERO");
		http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/users/**").hasAnyRole("USERO");
		http.authorizeRequests().antMatchers(HttpMethod.PUT, "/api/users/**").hasAnyRole("USERO");
		http.authorizeRequests().antMatchers(HttpMethod.DELETE, "/api/users/**").hasAnyRole("USERO");

		http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/videogames/*/purchase/*").hasAnyRole("USERO");

		http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/auth/logout").hasAnyRole("USERO");
		http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/auth/**").not().hasAnyRole("USERO");
		// URLs where the admin has  unique access
		http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/news/**").hasAnyRole("ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.PUT, "/api/news/**").hasAnyRole("ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/videogames/**").hasAnyRole("ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.PUT, "/api/videogames/**").hasAnyRole("ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.DELETE, "/api/**").hasAnyRole("ADMIN");
		
		// Other URLs can be accessed without authentication
		http.authorizeRequests().anyRequest().permitAll();

		// Disable CSRF protection (it is difficult to implement in REST APIs)
		http.csrf().disable();

		// Disable Http Basic Authentication
		http.httpBasic().disable();
		
		// Disable Form login Authentication
		http.formLogin().disable();

		// Avoid creating session 
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		// Add JWT Token filter
		http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

	}
}
