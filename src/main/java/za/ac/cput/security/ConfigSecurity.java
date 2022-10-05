package za.ac.cput.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class ConfigSecurity {

    @Bean
    public UserDetailsService userDetails() {

            UserDetails user = User.builder()
              .username("user")
               .password(passwordEncoder().encode("102568"))
                .roles("USER")
               .build();

       UserDetails admin = User.builder()
              .username("admin")
              .password(passwordEncoder().encode("985623"))
               .roles("USER","ADMIN")
               .build();

        return new InMemoryUserDetailsManager(user,admin);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.httpBasic()
                .and()
                .authorizeRequests()

                //Restaurant
                .antMatchers(HttpMethod.POST, "/restaurant/restaurant/save").hasRole("RESTAURANT")
                .antMatchers(HttpMethod.GET,"/restaurant/restaurant/find/").hasRole("RESTAURANT")
                .antMatchers(HttpMethod.GET,"/restaurant/restaurant/all").hasRole("RESTAURANT")
                .antMatchers(HttpMethod.DELETE,"restaurant/restaurant/delete").hasRole("RESTAURANT")
                //Table
                .antMatchers(HttpMethod.POST, "/restaurant/tablee/save").hasRole("TABLEE")
                .antMatchers(HttpMethod.GET,"/restaurant/tablee/find/").hasRole("TABLEE")
                .antMatchers(HttpMethod.GET,"/restaurant/tablee/all").hasRole("TABLEE")
                .antMatchers(HttpMethod.DELETE,"restaurant/tablee/delete").hasRole("TABLEE")




                .and()
                .csrf().disable()
                .formLogin().disable();

        return http.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
