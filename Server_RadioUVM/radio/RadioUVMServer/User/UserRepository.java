package eu.universome.radio.RadioUVMServer.User;


import java.util.Collection;
//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


//@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	//@Query("SELECT u FROM User u WHERE u.email=?")
	//Optional<User> findUserByEmail(String email);
	Collection<User> findByEmail(String email);
	
}