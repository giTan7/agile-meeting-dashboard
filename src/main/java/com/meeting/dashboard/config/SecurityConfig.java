package com.meeting.dashboard.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.meeting.dashboard.security.RestAuthenticationEntryPoint;
import com.meeting.dashboard.security.TokenAuthenticationFilter;
import com.meeting.dashboard.security.TokenHelper;
import com.meeting.dashboard.service.impl.CustomUserDetailsService;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	TokenHelper tokenHelper;
	@Autowired
	private CustomUserDetailsService jwtUserDetailsService;
	@Autowired
	private RestAuthenticationEntryPoint restAuthenticationEntryPoint;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(jwtUserDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
          .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
          .exceptionHandling().authenticationEntryPoint(restAuthenticationEntryPoint).and()
          .authorizeRequests()
          .antMatchers("/auth*").permitAll()
          .antMatchers("/user/**").hasRole("ADMIN")
          .antMatchers("/anonymous*").anonymous()
          .anyRequest().authenticated().and()
          .addFilterBefore(new TokenAuthenticationFilter(tokenHelper, jwtUserDetailsService), BasicAuthenticationFilter.class);
        http.csrf().disable();
    }

    @Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(HttpMethod.POST,"/auth/login");
	}

}