package it.danieltrosko.shop;

import org.apache.catalina.filters.RestCsrfPreventionFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;
import java.util.logging.Level;
import java.util.logging.Logger;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    protected final Logger log = Logger.getLogger(getClass().getName());

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select username, password, enabled from users where username=?")
                .authoritiesByUsernameQuery("select username, authority from authorities where username=?")
                .passwordEncoder(new BCryptPasswordEncoder());
    }
//.hasRole("USER")
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/user/**").hasAnyRole("USER", "ADMIN")
                .and()
                .authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN")
                .and()
                .authorizeRequests().antMatchers("/login**").permitAll()
                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/signin")
                .usernameParameter("username")
                .passwordParameter("password")
                .successHandler((req,res,auth)->{
                    for (GrantedAuthority authority : auth.getAuthorities()) {
                        log.log(Level.INFO, "Logged in: " + auth.getName() + "  as: " + authority.getAuthority());
                    }
                    res.sendRedirect("/");
                })
                .failureHandler((req,res,exp)->{
                    String errMsg="";
                    if(exp.getClass().isAssignableFrom(BadCredentialsException.class)){
                        errMsg="Invalid username or password.";
                    }else{
                        errMsg="Unknown error - "+exp.getMessage();
                    }
                    req.getSession().setAttribute("message", errMsg);
                    res.sendRedirect("/login");
                })
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/signout")
                .logoutSuccessHandler((req,res,auth)->{
                    req.getSession().setAttribute("message", "You are logged out successfully.");
                    res.sendRedirect("/login");
                })
                .permitAll()
                .and()
                .csrf().disable();
    }
}
