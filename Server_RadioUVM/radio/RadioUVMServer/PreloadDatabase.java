package eu.universome.radio.RadioUVMServer;

//Date parsing
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//import eu.universome.radio.RadioUVMServer.Program.Program;
//import eu.universome.radio.RadioUVMServer.Program.ProgramRepository;
//import eu.universome.radio.RadioUVMServer.User.User;
//import eu.universome.radio.RadioUVMServer.User.UserRepository;

//@Configuration
public class PreloadDatabase {
	
	// Logger Database Loader
	//private static final Logger log = LoggerFactory.getLogger(PreloadDatabase.class);

	
	/*
	
	@Bean
	CommandLineRunner preloadProgram(ProgramRepository repository) {
		return (args) -> {
			
			Program program1 = new Program(
					"Title1", 
					"Descr1", 
					"Speaker1", 
					LocalDate.parse("2016-01-01" ));
			
			Program program2 = new Program(
					"Title2", 
					"Descr2", 
					"Speaker2", 
					LocalDate.parse("2016-01-02" ));
			
			Program program3 = new Program(
					"Title3", 
					"Descr3", 
					"Speaker3", 
					LocalDate.parse("2016-01-03" ));
			
			repository.saveAll(List.of(program1, program2, program3));
			
			// fetch all programs
			log.info("Programs found with findAll():");
			log.info("------------------------------");
			for (Program program : repository.findAll()) {
				log.info(program.toString());
			}
			
			log.info("");
			
			// fetch an individual customer by ID
			Program program = repository.findById(1L);
			log.info("Program found with findById(1L):");
		    log.info("--------------------------------");
		    log.info(program.toString());
		    log.info("");
		    
		    // fetch customers by last name
		    //log.info("Customer found with findByLastName('Bauer'):");
		    //log.info("--------------------------------------------");
		    //repository.findByLastName("Bauer").forEach(bauer -> {
		    //	log.info(bauer.toString());
		    //});
	    	// for (Customer bauer : repository.findByLastName("Bauer")) {
		    //  log.info(bauer.toString());
		    // }
		    //log.info("");
		};
	}*/
}
