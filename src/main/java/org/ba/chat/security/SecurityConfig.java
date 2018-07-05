package org.ba.chat.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	/*@Autowired
	private DataSource dataSource;*/
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		PasswordEncoder encoder =
			     PasswordEncoderFactories.createDelegatingPasswordEncoder();
		
		auth.inMemoryAuthentication().withUser("issam").password(encoder.encode("123")).roles("ADMIN","USER");
		auth.inMemoryAuthentication().withUser("ahmed").password(encoder.encode("123")).roles("USER");
		
		/*auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery("select login as principal, password as credentials, active from user where login=?")
		.authoritiesByUsernameQuery("select login as principal, role as role from user where login=?")
		.rolePrefix("ROLE_")
		.passwordEncoder(new BCryptPasswordEncoder());*/
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin().loginPage("/login");
		http.authorizeRequests().antMatchers("/chat","/").hasRole("USER");
	}
}
