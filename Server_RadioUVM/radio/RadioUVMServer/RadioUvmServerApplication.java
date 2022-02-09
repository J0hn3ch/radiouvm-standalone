package eu.universome.radio.RadioUVMServer;


//Logger to send output to the log console
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
public class RadioUvmServerApplication {
	
	private static final Logger log = LoggerFactory.getLogger(RadioUvmServerApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(RadioUvmServerApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
}

/*
 * If your configuration has JPA repository interface definitions located in a package that is not visible, 
 * you can point out alternate packages by using @EnableJpaRepositories and its type-safe 
 * basePackageClasses=MyRepository.class parameter. 
 */
