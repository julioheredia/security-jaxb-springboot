package br.com.heredia.examples;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({ @PropertySource("classpath:auth.properties"), @PropertySource("classpath:env.properties") })
public class PropertiesConfig {

	@Value("${auth.user}")
	private String authUser;

	@Value("${auth.password}")
	private String authPassword;

	@Value("${env.endress}")
	private String envEndress;

	public String getAuthUser() {
		return authUser;
	}

	public String getAuthPassword() {
		return authPassword;
	}

	public String getEnvEndress() {
		return envEndress;
	}

}
