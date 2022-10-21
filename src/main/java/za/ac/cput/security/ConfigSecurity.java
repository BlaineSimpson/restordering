package za.ac.cput.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class ConfigSecurity extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("Admin")
                .password(encoder().encode("1234"))
                .roles("ADMIN")
                .and()
                .withUser("User")
                .password(encoder().encode("1234"))
                .roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic()
                .and()
                .authorizeRequests()

                //Restaurant
                .antMatchers(HttpMethod.POST, "/restaurant/restaurant/save").hasRole("USER")
                .antMatchers(HttpMethod.GET,"/restaurant/restaurant/find/").hasRole("USER")
                .antMatchers(HttpMethod.GET,"/restaurant/restaurant/all").hasRole("USER")
                .antMatchers(HttpMethod.DELETE,"restaurant/restaurant/delete/").hasRole("USER")
                //Table
                .antMatchers(HttpMethod.POST, "/restaurant/tablee/save").hasRole("USER")
                .antMatchers(HttpMethod.GET,"/restaurant/tablee/find/").hasRole("USER")
                .antMatchers(HttpMethod.GET,"/restaurant/tablee/all").hasRole("USER")
                .antMatchers(HttpMethod.DELETE,"restaurant/tablee/delete/").hasRole("USER")
                //Admin
                .antMatchers(HttpMethod.POST, "/restaurant/admin/save").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/restaurant/admin/find/").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/restaurant/admin/all").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/restaurant/admin/delete/").hasRole("ADMIN")
                //User
                .antMatchers(HttpMethod.POST, "/restaurant/user/save").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/restaurant/user/find/").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/restaurant/user/all").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/restaurant/user/delete/").hasRole("ADMIN")


                //Menu
                .antMatchers(HttpMethod.POST, "/restaurant/menu/save").hasRole("USER")
                .antMatchers(HttpMethod.GET,"/restaurant/menu/find/").hasRole("USER")
                .antMatchers(HttpMethod.GET,"/restaurant/menu/all").hasRole("USER")
                .antMatchers(HttpMethod.DELETE,"restaurant/menu/delete/").hasRole("USER")
                //Supplier
                .antMatchers(HttpMethod.POST, "/restaurant/supplier/save").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/restaurant/supplier/find/").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/restaurant/supplier/all").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/restaurant/supplier/delete/").hasRole("ADMIN")
                //Item
                .antMatchers(HttpMethod.POST, "/restaurant/item/save").hasRole("USER")
                .antMatchers(HttpMethod.GET,"/restaurant/item/find/").hasRole("USER")
                .antMatchers(HttpMethod.GET,"/restaurant/item/all").hasRole("USER")
                .antMatchers(HttpMethod.DELETE,"restaurant/item/delete/").hasRole("USER")
                //Inventory
                .antMatchers(HttpMethod.POST, "/restaurant/inventory/save").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/restaurant/inventory/find/").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/restaurant/inventory/all").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/restaurant/inventory/delete/").hasRole("ADMIN")
                //OrderItem
                .antMatchers(HttpMethod.POST, "/restaurant/orderItem/save").hasRole("USER")
                .antMatchers(HttpMethod.GET,"/restaurant/orderItem/find/").hasRole("USER")
                .antMatchers(HttpMethod.GET,"/restaurant/orderItem/all").hasRole("USER")
                .antMatchers(HttpMethod.DELETE,"restaurant/orderItem/delete/").hasRole("USER")
                //Order
                .antMatchers(HttpMethod.POST, "/restaurant/order/save").hasRole("USER")
                .antMatchers(HttpMethod.GET,"/restaurant/order/find/").hasRole("USER")
                .antMatchers(HttpMethod.GET,"/restaurant/order/all").hasRole("USER")
                .antMatchers(HttpMethod.DELETE,"restaurant/order/delete/").hasRole("USER")
                //Customer
                .antMatchers(HttpMethod.POST, "/restaurant/inventory/save").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/restaurant/inventory/find/").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/restaurant/inventory/all").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/restaurant/inventory/delete/").hasRole("ADMIN")
               // Bill
                .antMatchers(HttpMethod.POST, "/restaurant/bill/save").hasRole("USER")
                .antMatchers(HttpMethod.GET,"/restaurant/bill/find/").hasRole("USER")
                .antMatchers(HttpMethod.GET,"/restaurant/bill/all").hasRole("USER")
                .antMatchers(HttpMethod.DELETE,"restaurant/bill/delete/").hasRole("USER")
                .and()
                .csrf().disable()
                .formLogin().disable();
    }
    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }
}
