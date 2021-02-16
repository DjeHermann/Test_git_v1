package com.osis.cipres.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.osis.cipres.users.UserDetailsServiceImplement;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
    private UserDetailsServiceImplement userDetailsService;
	
	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

	  @Override
	    public void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
	    }


     @Override
  		protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
       // http.formLogin();
        http.authorizeRequests().antMatchers("/verifuserinfos/**").permitAll();
        http.authorizeRequests().antMatchers("/test/**").permitAll();
        http.authorizeRequests().antMatchers("/sendTrace/**").permitAll();
        http.authorizeRequests().antMatchers("/downloadFile/**").permitAll();
        http.authorizeRequests().antMatchers("/login/**").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.OPTIONS).permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.POST, "/register/**").hasAuthority("ADMIN");
        http.authorizeRequests().antMatchers(HttpMethod.DELETE, "/**").hasAuthority("ADMIN");
        http.authorizeRequests().anyRequest().authenticated();
                
             //add Filter   
           http.addFilter(new JWTAuthenticationFilter(authenticationManager()));
           http.addFilterBefore(new JWTAuthorizationFilter(),UsernamePasswordAuthenticationFilter.class);
                
              
    }
	
}
