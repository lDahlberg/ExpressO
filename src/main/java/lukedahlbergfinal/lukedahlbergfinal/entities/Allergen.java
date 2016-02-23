package lukedahlbergfinal.lukedahlbergfinal.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Allergen {
	
	private int allergenId;
	private String name;
	
	/**
	 * Generic getter for allergenId. Gets generated Hibernate ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getAllergenId() {
		
		return allergenId;
		
	}
	
	/**
	 * Generic setter for allergenId
	 * @param allergenId
	 */
	public void setAllergenId(int allergenId) {
		
		this.allergenId = allergenId;
		
	}
	
	/**
	 * Generic getter for name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Generic setter for allergen name
	 * @param name
	 */
	public void setName(String name) {
		
		this.name = name;
		
	}
}
