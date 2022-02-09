package eu.universome.radio.RadioUVMServer.User;

// JSON Response
import java.util.List;
import java.util.Objects;
import java.util.Optional;

// REST import
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
	
	private final UserRepository userRepository;
	
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public List<User> getUsers(){
		return userRepository.findAll();
	}
	
	/*
	public void addNewUser(User user) {
		Optional<User> userOptional = userRepository.findByEmail(user.getEmail());
		if (userOptional.isPresent()) {
			throw new IllegalStateException("email taken");
		}
		
		userRepository.save(user);
		
	}*/
	
	// Delete
	public void deleteUser(Long userId) {
		
		boolean exists = userRepository.existsById(userId);
		if (!exists) {
			throw new IllegalStateException("student with id " + userId + " does not exists");
		}
		
		userRepository.deleteById(userId);
	}
	
	// Update User
	@Transactional
	public void updateUser(Long userId, 
							String firstName,
							String lastName,
							String email) {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new IllegalStateException(
						"student with id " + userId + "does not exist"));
		
		if (firstName != null &&
				firstName.length() > 0 &&
				!Objects.equals(user.getFirstName(), firstName)) {
			user.setFirstName(firstName);
		}
		
		if (lastName != null &&
				lastName.length() > 0 &&
				!Objects.equals(user.getLastName(), lastName)) {
			user.setLastName(lastName);
		}
		
		if (email != null &&
				email.length() > 0 &&
				!Objects.equals(user.getEmail(), email)) {
			user.setEmail(email);
		}
	}
}