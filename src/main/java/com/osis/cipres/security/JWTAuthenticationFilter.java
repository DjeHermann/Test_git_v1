package com.osis.cipres.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.osis.cipres.users.AppUser;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	
private AuthenticationManager authenticationManager;
	
	public JWTAuthenticationFilter (AuthenticationManager authenticationManager) {
		super();
		this.authenticationManager = authenticationManager;
	}
	
	@Override
	public Authentication attemptAuthentication (HttpServletRequest req, HttpServletResponse res) 
			throws AuthenticationException{ 
				AppUser appUser = null;
				try {
					appUser = new ObjectMapper().readValue(req.getInputStream(), AppUser.class);
					
					} catch (Exception e) {
				throw new RuntimeException(e);
		}
				
				System.out.println("*********************************");
				System.out.println("username "+appUser.getUsername());
				System.out.println("password "+appUser.getPassword());
				
				return authenticationManager.authenticate(
						new UsernamePasswordAuthenticationToken(
								appUser.getUsername(),
								appUser.getPassword(),
								new ArrayList<>())
							);

	}
	
	  @Override
	    protected void successfulAuthentication(HttpServletRequest req,
	                                            HttpServletResponse res,
	                                            FilterChain chain,
	                                            Authentication auth) throws IOException, ServletException {
		  User springUser = (User)auth.getPrincipal();
	        String jwt = Jwts.builder() 
	                .setSubject(springUser.getUsername())
	                .setExpiration(new Date(System.currentTimeMillis()+SecurityConstants.EXPIRATION_TIME))
	                .signWith(SignatureAlgorithm.HS256,SecurityConstants.SECRET)
	                .claim("role", springUser.getAuthorities())
	                .compact();
	        res.addHeader(SecurityConstants.HEADER_STRING, SecurityConstants.TOKEN_PREFIX+jwt);
	    }
	

}
