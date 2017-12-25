package jp.co.gyosei.botlog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import jp.co.gyosei.botlog.impl.UserDetailsServiceImpl;
import jp.co.gyosei.botlog.impl.AuthenticationProviderImpl;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;
	
	@Autowired
	private AuthenticationProviderImpl authenticationProvider;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		.antMatchers("/", "/login", "/loginerror").permitAll()
		//.antMatchers("/**").hasRole("USER")
		//.antMatchers("/**").hasAnyAuthority("ADMIN","USER")
		.and()
		.formLogin()
		.loginProcessingUrl("/loading")
		.loginPage("/")
		//.failureUrl("?error")
		.defaultSuccessUrl("/Customer", true)
		//.usernameParameter("username")
		.usernameParameter("custid")
		.passwordParameter("password");

		http
		.rememberMe()
		.tokenValiditySeconds(86400); 

		http
		.logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/")
		.deleteCookies("JSESSIONID")
		.invalidateHttpSession(true)
		.permitAll();

	}
	
/*	
 	@Autowired
 	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
 		auth
 		.inMemoryAuthentication()
 		.withUser("user").password("password").roles("USER");
 	}
*/ 
	
     @Bean
     public BCryptPasswordEncoder passwordEncoder() {
         return new BCryptPasswordEncoder();
     }
 
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		// �Ǝ��F�؃N���X��ݒ肷��
		auth
		.authenticationProvider(authenticationProvider)
		.userDetailsService(userDetailsService);
	}

}
