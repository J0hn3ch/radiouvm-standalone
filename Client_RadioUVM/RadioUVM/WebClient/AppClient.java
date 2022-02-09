package eu.universome;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import eu.universome.client.user.UserResponse;
import eu.universome.client.user.User;
import eu.universome.client.user.UserInfo;
import reactor.core.publisher.Mono;

//@Service
//@Component
public class AppClient {

  private final WebClient client;

  // Spring Boot auto-configures a `WebClient.Builder` instance with nice defaults and customizations.
  // We can use it to create a dedicated `WebClient` for our component.
  // Constructor
  public AppClient(WebClient.Builder builder) {
    this.client = builder
    		.baseUrl("https://api.spreaker.com/v2")
    		.build();
  }
  
  public UserInfo getUser() {
	  WebClient.ResponseSpec responseSpec = this.client
			  .get()
			  .uri("/users/universome")
			  .accept(MediaType.APPLICATION_JSON)
			  .retrieve();
	  
	  Mono<User> user_mono = responseSpec.bodyToMono(User.class);
	//System.out.println(user_mono.map(User::toString));
	  UserInfo user = user_mono.block().getResponse().getUser();
	  return user;
  }
  
  /*
  public ProgramInfo getProgram() {
	  WebClient.ResponseSpec responseSpec = this.client
			  .get()
			  .uri("/universome/shows")
			  .accept(MediaType.APPLICATION_JSON)
			  .retrieve();
	  //Mono<Program> program_mono = responseSpec.bodyToMono(Program.class);
	  //ProgramInfo program = program_mono.block().getResponse().getProgram();
	  //return program;
  }*/

}
