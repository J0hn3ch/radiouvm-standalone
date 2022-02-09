package eu.universome.radio.RadioUVMServer.User;

import java.time.LocalDate;
import java.time.Period;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.*;

@Entity
@Table(name = "\"User\"")
public class User { 

	@Id
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "user_sequence"
	)
	@SequenceGenerator(
			name = "user_sequence",
			sequenceName = "user_sequence",
			allocationSize = 1
	)
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	
	//@Transient
	//private Integer age;

	protected User() {	}
	
	public User(Long id,
				String firstName,
				String lastName,
				String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public User(String firstName,
				String lastName,
				String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

//	public Integer getAge() {
//		return Period.between(this.dob, LocalDate.now()).getYears();
//	}

//	public void setAge(Integer age) {
//		this.age = age;
//	}

	@Override
	public String toString() {
		return "User [id=" + id + 
				", firstName=" + firstName + 
				", lastName=" + lastName + 
				", email=" + email + 
				"]";
	}
}