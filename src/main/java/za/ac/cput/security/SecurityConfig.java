package za.ac.cput.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override //configures user credentials
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //super.configure(auth);

        auth.inMemoryAuthentication()
                .withUser("foo")
                .password(encoder().encode("123"))
                .roles("ADMIN")
                .and()
                .withUser("user")
                .password(encoder().encode("321"))
                .roles("USER");
    }

    @Override //configures user credentials
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(http);

        http.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/restaurant/**/save").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/restaurant/**/all").hasRole("USER") //TODO: Read all not applying to USER, only applied to last role
                .antMatchers(HttpMethod.GET, "/restaurant/**/all").hasRole("ADMIN")
                .and()
                .csrf().disable()
                .formLogin().disable();
    }

    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }
}
