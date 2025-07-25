package com.cefet.projeto_academia.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.cefet.projeto_academia.security.JwtAuthenticationFilter;
import com.cefet.projeto_academia.services.UsuarioDetailsService;

@Configuration
public class SecurityConfig {

    @Autowired
    private UsuarioDetailsService usuarioDetailsService;

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter() {
        return new JwtAuthenticationFilter();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .cors().and()    
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/h2-console/**").permitAll()
                .requestMatchers("/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui.html").permitAll()
              //  .requestMatchers(HttpMethod.POST, "/usuarios").permitAll()
                .requestMatchers(HttpMethod.POST, "/auth").permitAll()
                


                 // Regras de Autorização para usuario
                .requestMatchers(HttpMethod.GET, "/usuarios").hasAnyRole("ADMIN")
                .requestMatchers(HttpMethod.GET, "/usuarios/{id}").hasAnyRole("ADMIN")
                .requestMatchers(HttpMethod.POST, "/usuarios").hasAnyRole("ADMIN")
                .requestMatchers(HttpMethod.PUT, "/usuarios/**").hasAnyRole("ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/usuarios/**").hasRole("ADMIN")

                // Regras de Autorização para Pessoas
                .requestMatchers(HttpMethod.GET, "/pessoas").hasAnyRole("ADMIN")
                .requestMatchers(HttpMethod.GET, "/pessoas/{id}").hasAnyRole("ADMIN", "CLIENTE")
                .requestMatchers(HttpMethod.POST, "/pessoas").hasAnyRole("ADMIN")
                .requestMatchers(HttpMethod.PUT, "/pessoas/**").hasAnyRole("ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/pessoas/**").hasRole("ADMIN")

                // Regras de Autorização para Planos
                .requestMatchers(HttpMethod.GET, "/planos").hasAnyRole("ADMIN", "CLIENTE")
                .requestMatchers(HttpMethod.GET, "/planos/{id}").hasAnyRole("ADMIN", "CLIENTE")
                .requestMatchers(HttpMethod.POST, "/planos").hasAnyRole("ADMIN")
                .requestMatchers(HttpMethod.PUT, "/planos/**").hasAnyRole("ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/planos/**").hasRole("ADMIN")

                //Exercicios
                .requestMatchers(HttpMethod.GET, "/exercicios").hasAnyRole("ADMIN", "CLIENTE")
                .requestMatchers(HttpMethod.GET, "/exercicios/{id}").hasAnyRole("ADMIN", "CLIENTE")
                .requestMatchers(HttpMethod.POST, "/exercicios").hasAnyRole("ADMIN")
                .requestMatchers(HttpMethod.PUT, "/exercicios/**").hasAnyRole("ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/exercicios/**").hasRole("ADMIN")

                //  Fichas
                .requestMatchers(HttpMethod.GET, "/fichas").hasAnyRole("ADMIN")
                .requestMatchers(HttpMethod.GET, "/fichas/{id}").hasAnyRole("ADMIN", "CLIENTE")
                .requestMatchers(HttpMethod.POST, "/fichas").hasAnyRole("ADMIN")
                .requestMatchers(HttpMethod.PUT, "/fichas/**").hasAnyRole("ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/fichas/**").hasRole("ADMIN")
                
                // Matriculas
                .requestMatchers(HttpMethod.GET, "/matriculas").hasAnyRole("ADMIN")
                .requestMatchers(HttpMethod.GET, "/matriculas/{id}").hasAnyRole("ADMIN", "CLIENTE")
                .requestMatchers(HttpMethod.POST, "/matriculas").hasAnyRole("ADMIN")
                .requestMatchers(HttpMethod.PUT, "/matriculas/**").hasAnyRole("ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/matriculas/**").hasRole("ADMIN")

                // Regras para Pagamentos
                .requestMatchers(HttpMethod.GET, "/pagamentos").hasAnyRole("ADMIN")
                .requestMatchers(HttpMethod.GET, "/pagamentos/{id}").hasAnyRole("ADMIN", "CLIENTE")
                .requestMatchers(HttpMethod.POST, "/pagamentos").hasAnyRole("ADMIN")
                .requestMatchers(HttpMethod.PUT, "/pagamentos/**").hasAnyRole("ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/pagamentos/**").hasRole("ADMIN")
                
                // FichaExercicio
                .requestMatchers(HttpMethod.GET, "/fichaExercicios").hasAnyRole("ADMIN")
                .requestMatchers(HttpMethod.GET, "/fichaExercicios/{id}").hasAnyRole("ADMIN", "CLIENTE")
                .requestMatchers(HttpMethod.POST, "/fichaExercicios").hasAnyRole("ADMIN")
                .requestMatchers(HttpMethod.PUT, "/fichaExercicios/**").hasAnyRole("ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/fichaExercicios/**").hasRole("ADMIN")

                .anyRequest().authenticated()
            )
            .headers(headers -> headers.frameOptions().disable())
            .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
            
        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

        @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(usuarioDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

     @Bean
	  public WebMvcConfigurer corsConfigurer() {
	    return new WebMvcConfigurer() {
	      @Override
	      public void addCorsMappings(CorsRegistry registry) {
	        registry.addMapping("/**")
	          .allowedOrigins("http://localhost:4200", "https://ds-guia12.netlify.app")
	          .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
	          .allowedHeaders("*")
	          .allowCredentials(true);
	      }
	    };
	  }        
}