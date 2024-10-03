package pl.pankalkulator.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebAuthorizationConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
        .httpBasic(Customizer.withDefaults())
                .authorizeHttpRequests((e) -> {
                    e.requestMatchers("users/login", "users/register").permitAll();
                    e.anyRequest().authenticated();
                });
        return http.build();
    }
}
