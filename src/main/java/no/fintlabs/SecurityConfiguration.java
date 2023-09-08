package no.fintlabs;


import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfiguration {

    //    @Value("${fint.integration.service.authorized-role:rolle}")
    //    private String authorizedRole;
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/**")
                .permitAll()
                //.hasRole(authorizedRole)
                .and()
                .oauth2ResourceServer((resourceServer) -> resourceServer
                        .jwt()
                        .jwtAuthenticationConverter(new JwtUserConverter()));
        return http.build();
    }
}
