package lukedahlbergfinal.lukedahlbergfinal.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * This Java class represents the Recipe.
 * @author ldahlberg
 */
@Entity
public class Recipe {

	private int recipeId;
	private String name;
	private String instructions;
	private List<Ingredient> ingredient;
	
	/**
	 * Generic getter for recipeId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getRecipeId() {
		
		return recipeId;
		
	}
	
	/**
	 * Generic setter for recipeId
	 * @param recipeId
	 */
	public void setRecipeId(int recipeId) {
		this.recipeId = recipeId;
	}
	
	/**
	 * Generic getter for name
	 */
	public String getName() {
		
		return name;
		
	}

	/**
	 * Generic setter for name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Generic getter for instructions
	 */
	public String getInstructions() {
		
		return instructions;
		
	}
	
	/**
	 * Generic setter for instructions
	 * @param ingredient
	 */
	public void setInstructions(String instructions) {
		
		this.instructions = instructions;
		
	}
	
	/**
	 * Generic getter for ingredient
	 */
	@ManyToMany
	public List<Ingredient> getIngredient() {
		
		return ingredient;
		
	}
	
	/**
	 * Generic setter for ingredients
	 * @param ingredient
	 */
	public void setIngredient(List<Ingredient> ingredient) {
		
		this.ingredient = ingredient;
		
	}
}
