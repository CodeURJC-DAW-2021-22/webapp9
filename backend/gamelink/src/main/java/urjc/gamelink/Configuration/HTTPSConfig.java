package urjc.gamelink.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

public class HTTPSConfig {

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
      return http
        .requiresChannel(channel -> 
            channel.anyRequest().requiresSecure())
        .authorizeRequests(authorize ->
            authorize.anyRequest().permitAll())
        .build();
      }
    
}
