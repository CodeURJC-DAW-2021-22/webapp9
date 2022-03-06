package urjc.gamelink.Configuration;


import java.security.SecureRandom;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(10, new SecureRandom());
	}


    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	
    	/* Public pages */
        http.authorizeRequests().antMatchers("/").permitAll();
        http.authorizeRequests().antMatchers("/about").permitAll();
        http.authorizeRequests().antMatchers("/videogameStatistics").permitAll();
        http.authorizeRequests().antMatchers("/errorMessage").permitAll();
        http.authorizeRequests().antMatchers("/home").permitAll();
        http.authorizeRequests().antMatchers("/news").permitAll();
        http.authorizeRequests().antMatchers("/showNews").permitAll();
        http.authorizeRequests().antMatchers("/showVideogame").permitAll();
        http.authorizeRequests().antMatchers("/videogame").permitAll();
        http.authorizeRequests().antMatchers("/").permitAll();
	    
        // Logged can not acces

        http.authorizeRequests().antMatchers("/login").not().hasAnyRole("USERO");
        http.authorizeRequests().antMatchers("/signin").not().hasAnyRole("USERO");

        // Logged Only pages

        http.authorizeRequests().antMatchers("/paymentConfirmation").hasAnyRole("USERO");
        http.authorizeRequests().antMatchers("/userProfile").hasAnyRole("USERO");

            /* Admin Only pages*/

        http.authorizeRequests().antMatchers("/admin").hasAnyRole("ADMIN");
        http.authorizeRequests().antMatchers("/createVideogame").hasAnyRole("ADMIN");
        http.authorizeRequests().antMatchers("/editVg/**").hasAnyRole("ADMIN");
        http.authorizeRequests().antMatchers("/deleteVg/**").hasAnyRole("ADMIN");
        http.authorizeRequests().antMatchers("/createNew").hasAnyRole("ADMIN");
        http.authorizeRequests().antMatchers("/editNew/**").hasAnyRole("ADMIN");
        http.authorizeRequests().antMatchers("/deleteNew/**").hasAnyRole("ADMIN");
        


        // Login form

        http.formLogin().loginPage("/login");
        http.formLogin().usernameParameter("username");
        http.formLogin().passwordParameter("password");
        http.formLogin().defaultSuccessUrl("/userProfile");
        http.formLogin().failureUrl("/loginError");


        // Logout

        http.logout().logoutUrl("/logout");
        http.logout().logoutSuccessUrl("/");
    }
    
}
