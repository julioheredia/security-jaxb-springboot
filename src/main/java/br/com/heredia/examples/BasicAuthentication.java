package br.com.heredia.examples;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class BasicAuthentication extends WebSecurityConfigurerAdapter {

	@Autowired
	private PropertiesConfig propertiesConfig;

	@Value("${custom.auth.validation}")
	private boolean customAuthValidation;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		auth.inMemoryAuthentication().withUser("user").password(encoder.encode("password")).roles("USER").and()
				.withUser(propertiesConfig.getAuthUser()).password(encoder.encode(propertiesConfig.getAuthPassword()))
				.roles("USER", "ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		if (customAuthValidation) {
			http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
		} else {
			http.authorizeRequests().antMatchers("/**").permitAll().anyRequest().authenticated();
		}
	}
}
