package backend.entities;

import java.time.LocalDate;

public class Author {

	private final int id;
	private final String fullName;
	private final LocalDate birthDate;
	private final String country;
	
	public Author(int id, String fullName, LocalDate birthDate, String country) {
		this.id = id;
		this.fullName = fullName;
		this.birthDate = birthDate;
		this.country = country;
	}
	
	public int getId() { return id; }

	public String getFullName() { return fullName; }

	public LocalDate getBirthDate() { return birthDate; }
		
	public String getCountry() { return country; }
		
}
