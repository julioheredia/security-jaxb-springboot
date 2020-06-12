package br.com.heredia.examples;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;

import com.sun.xml.ws.transport.http.servlet.WSSpringServlet;

@EnableWs
@Configuration
@ImportResource(locations = "jaxws-config.xml")
public class WebServiceConfig extends WsConfigurerAdapter {

	@Bean
	public ServletRegistrationBean<WSSpringServlet> servletRegistrationBean() {
		return new ServletRegistrationBean<WSSpringServlet>(new WSSpringServlet(), 
				"/MusicianService", "/BandService");
	}

}
