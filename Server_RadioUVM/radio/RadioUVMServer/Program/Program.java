package eu.universome.radio.RadioUVMServer.Program;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
/*
@Entity(name = "Program")
@Table(name = "\"Program\"")
public class Program { 

	@Id
	@SequenceGenerator(
			name = "program_sequence",
			sequenceName = "program_sequence",
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "program_sequence"
	)
	@Column(
			name = "id",
			updatable = false
	)
	private Long id;
	@Column(
			name = "title",
			nullable = false,
			columnDefinition = "TEXT",
			updatable = true
	)
	private String title;
	@Column(
			name = "description",
			updatable = true
	)
	private String description;
	private String speaker;
	private LocalDate published;


	protected Program() {	}

	public Program(Long id,
				String title,
				String description,
				String speaker,
				LocalDate published) {

		this.id = id;
		this.title = title;
		this.description = description;
		this.speaker = speaker;
		this.published = published;
	}
	
	public Program( String title,
			String description,
			String speaker,
			LocalDate published) {

		this.title = title;
		this.description = description;
		this.speaker = speaker;
		this.published = published;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSpeaker() {
		return speaker;
	}

	public void setSpeaker(String speaker) {
		this.speaker = speaker;
	}

	public LocalDate getPublished() {
		return published;
	}

	public void setPublished(LocalDate published) {
		this.published = published;
	}
	
	@Override
	public String toString() {
		return "Program {id=" + id + 
				", title=" + title + 
				", description=" + description + 
				", speaker=" + speaker + 
				", published=" + published + 
				"}";
	}
	
	

}*/