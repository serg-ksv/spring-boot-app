package mate.academy.springbootapp.config;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserDetailsService userDetailsService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(getEncoder());
    }

    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                        .antMatchers("/register", "/swagger-ui.html", "/h2-console/**").permitAll()
                        .antMatchers(HttpMethod.POST, "/reviews/**").hasRole("USER")
                        .antMatchers(HttpMethod.PUT, "/reviews/**").hasRole("USER")
                        .antMatchers(HttpMethod.GET,
                                "/reviews", "/products", "/users").hasRole("ADMIN")
                        .antMatchers(HttpMethod.DELETE, "/reviews/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
                        .and()
                .formLogin()
                        .permitAll()
                        .and()
                .httpBasic()
                        .and()
                .csrf().disable()
                .headers().frameOptions().disable();
    }

    @Bean
    public PasswordEncoder getEncoder() {
        return new BCryptPasswordEncoder();
    }
}