package eu.universome.radio.RadioUVMServer.User;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

public class UserConfig {
	
	private static final Logger log = LoggerFactory.getLogger(UserConfig.class);
	
	@Bean
	CommandLineRunner preloadUser(UserRepository repository) {
		return args -> {
			User mariam = new User(
					"Mariam",
					"Jamal",
					"mariam.jamal@gmail.com"
				);
			
			User alex = new User(
					"alex",
					"Jamal",
					"alex@gmail.com"
				);
			
			repository.saveAll(
					List.of(mariam, alex)
					);
		};
	}
}
