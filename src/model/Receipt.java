package model;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.*;


public class Receipt {
	
	private int ID;
	private String title;
	private String author;
	private String description;
	private String picture;
	private int duration;
	private int degree;
	private String note;
	private Set<Ingredient> ingredients;// = new HashSet<Ingredient>();
	private Set<Equipment> equipments;// = new Set<Equipment>();
	
	public Receipt() {
		ingredients = new HashSet<>();
		equipments = new HashSet<>();
	}
	
	public void addIngredient(Ingredient ingredient) {
		ingredients.add(ingredient);
	}
	
	public void addEquipment(Equipment equipment) {
		equipments.add(equipment);
	}
	
	public void removeIngredient(Ingredient ingredient) {
		ingredients.remove(ingredient);
	}
	
	public void removeEquipment(Equipment equipment) {
		equipments.remove(equipment);
	}
	
	public String getIngredientsAsString() {
		StringBuffer ret = new StringBuffer();
		
		for (Ingredient ingredient : ingredients) {
			ret.append(ingredient.toString() + '\n');
		}
		
		return ret.toString();
	}
	
	public String getEquipmentAsString() {
		StringBuffer ret = new StringBuffer();
		
		for (Equipment equipment : equipments) {
			ret.append(equipment.toString() + '\n');
		}

		return ret.toString();
	}
	
	public Receipt createReceiptVariant(Set<Ingredient> ingredients) {
		Receipt receipt = new Receipt();
		receipt.setTitle(title);
		receipt.setAuthor(author);
		receipt.setDescription(description);
		receipt.setPicture(picture);
		receipt.setDuration(duration);
		receipt.setDegree(degree);
		receipt.setNote(note);
		receipt.setEquipments(equipments);
		receipt.setIngredients(ingredients);
		
		return receipt;
	}
	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	@NotEmpty(message = "Title must not be empty")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@NotEmpty(message = "Author must not be empty")
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@NotEmpty(message = "Description must not be empty")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	@Min(value = 1)
	@Max(value = 5)
	public int getDegree() {
		return degree;
	}

	public void setDegree(int degree) {
		this.degree = degree;
	}

//	@NotEmpty(message = "Note must not be empty")
	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Set<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(Set<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	public Set<Equipment> getEquipments() {
		return equipments;
	}

	public void setEquipments(Set<Equipment> equipments) {
		this.equipments = equipments;
	}

	@Override
	public String toString() {
		return "Receipt [ID=" + ID + ", title=" + title + ", author=" + author
				+ ", description=" + description + ", picture=" + picture
				+ ", duration=" + duration + ", degree=" + degree + ", note="
				+ note + ", ingredients=" + ingredients + ", equipments="
				+ equipments + "]";
	}
	
	
}
