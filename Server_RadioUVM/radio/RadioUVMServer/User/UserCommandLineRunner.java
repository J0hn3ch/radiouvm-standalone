package eu.universome.radio.RadioUVMServer.User;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import eu.universome.radio.RadioUVMServer.RadioUvmServerApplication;

@Component
public class UserCommandLineRunner implements CommandLineRunner {
	
	@Override
	public void run(String...args) throws Exception{
		for(User u : this.userRepository.findAll()) {
			System.out.println(u.toString());
		}
	}
	
	@Autowired UserRepository userRepository;
	
	/*
	private static final Logger log = LoggerFactory.getLogger(RadioUvmServerApplication.class);
		
	@Bean
	CommandLineRunner preloadUser(UserRepository repository) {
		return args -> {
			User mariam = new User(
					"Mariam",
					"Jamal",
					"mariam.jamal@gmail.com",
					LocalDate.of(2000, Month.JANUARY, 5)
				);
			
			User alex = new User(
					"alex",
					"Jamal",
					"alex@gmail.com",
					LocalDate.of(2004, Month.JANUARY, 5)
				);
			
			repository.saveAll(
					List.of(mariam, alex)
					);
		};
	}*/
}