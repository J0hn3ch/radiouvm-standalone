package eu.universome.radio.RadioUVMServer.User;

// REST import
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
public class UserController { 

	private final UserService userService;
	
	@RequestMapping(path="/users")
	Collection<User> users(){
		return this.userRepository.findAll();
	}
	
	@Autowired UserRepository userRepository;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping
	public void getUser(){
		//return userService.getUsers();
	}
	
	@PostMapping
	public void registerNewUser(@RequestBody User user) {
		userService.addNewUser(user);
	}
	
	@DeleteMapping(path = "{userId}")
	public void deleteUser(
			@PathVariable("userId") Long userId) {
		userService.deleteUser(userId);
	}
	
	@PutMapping(path = "{userId}")
	public void updateUser(
			@PathVariable("userId") Long userId,
			@RequestParam(required = false) String firstName,
			@RequestParam(required = false) String lastName,
			@RequestParam(required = false) String email) {
		userService.updateUser(userId, firstName, lastName, email);
	}

}