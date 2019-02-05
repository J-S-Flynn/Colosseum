package com.jsf.config;

import com.jsf.services.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.session.web.http.HeaderHttpSessionStrategy;
import org.springframework.session.web.http.HttpSessionStrategy;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


    private final CustomUserDetailsService userDetailsService ;


    @Autowired
    public SecurityConfiguration(CustomUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    /**
     * Automatically manages the log in session for a user
     * @return a new session for the logged in user to keep conection alive
     */
    @Bean
    public HttpSessionStrategy httpSessionStrategy(){

        return new HeaderHttpSessionStrategy() ;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(userDetailsService).passwordEncoder(getPasswordEncoder()) ;
    }

    /**
     * this method controlled which pages can be accessed and which will require permission
     * in this case any endpoint that begins with the /colosseum prefix will require the user to be authenticated.
     * @param http the endpiont that the user is truing to access
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers().authenticated()
                //.antMatchers("/colosseum/**").authenticated()
                .anyRequest().permitAll()
                .and().formLogin().loginPage("/login").permitAll() ;
    }

    /**
     * @return an encoded password
     */
    private PasswordEncoder getPasswordEncoder() {

        return new PasswordEncoder() {

            @Override
            public String encode(CharSequence charSequence) {
                return charSequence.toString() ;
            }

            @Override
            public boolean matches(CharSequence charSequence, String s) {
                return  true ;
            }
        } ;
    }
}
