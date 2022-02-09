package eu.universome;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

//@Configuration
public class ClientConfiguration {
	
	@Bean
	public AppClient appClient() {
		return new AppClient(WebClient.builder());
	}
}
