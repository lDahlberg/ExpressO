package lukedahlbergfinal.lukedahlbergfinal.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * This Java class represents the Ingredients.
 * @author ldahlberg
 */
@Entity
public class Ingredient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ingredientId;
	private String name;
	private Double cost;
	private Double measure;
	
	/**
	 * Generic getter for ingredientId
	 */
	public Integer getIngredientId() {
		
		return ingredientId;
		
	}
	
	/**
	 * Generic setter for ingredientId
	 * @param ingredientId
	 */
	public void setIngredientId(int ingredientId) {
		
		this.ingredientId = ingredientId;
		
	}
	
	/**
	 * Generic getter for name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Generic setter for ingredient name
	 * @param name
	 */
	public void setName(String name) {
		
		this.name = name;
		
	}
	
	/**
	 * Generic getter for cost
	 */
	public Double getCost() {
		
		return cost;
		
	}
	
	/**
	 * Generic setter for ingredient cost
	 * @param cost
	 */
	public void setCost(Double cost) {
		
		this.cost = cost;
		
	}
	
	/**
	 * Generic getter for measure
	 */
	public Double getMeasure() {
		
		return measure;
		
	}
	
	/**
	 * Generic setter for measurement
	 * @param measure
	 */
	public void setMeasure(Double measure) {
		this.measure = measure;
	}	
}
