package model;

public abstract class Person {
	protected String id;
	protected String name;
	protected String lastName;
	protected String email;
	protected String gender;
	protected String country;
	protected String photo;
	protected String birthDay;
	
	public Person(String id, String name, String lastName, String email, String gender, String country, String photo,
			String birthDay) {
	
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.country = country;
		this.photo = photo;
		this.birthDay = birthDay;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	public String toString() {
		String msg = " ";
		
		msg += "El id es: " + id + "\n";
		msg += "El nombre es: " + name +"\n";
		msg += "El apellido es: " + lastName +"\n";
		msg += "El email es: " + email +"\n";
		msg += "El genero es: " + gender +"\n";
		msg += "El pais es: " + country +"\n";
		msg += "El cumpleaños es: " + birthDay +"\n";
		
		return msg;
	}
	
	
	
}
