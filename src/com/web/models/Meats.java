package com.web.models;

public class Meats {

	// Attributes

	private int Id;
	private String Name;
	private String Description;

	// Getters, Setters

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	// toString()

	@Override
	public String toString() {
		return "Meats [Id=" + Id + ", Name=" + Name + ", Description=" + Description + "]";
	}

}
