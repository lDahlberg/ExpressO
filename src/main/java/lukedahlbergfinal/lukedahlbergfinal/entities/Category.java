package lukedahlbergfinal.lukedahlbergfinal.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * This Java class represents the categories.
 * @author ldahlberg
 */
@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int categoryId;
	private String name;
	
	/**
	 * Generic getter for categoryId
	 */
	public Integer getCategoryId() {
		
		return categoryId;
		
	}
	
	/**
	 * Generic setter for categoryId
	 * @param categoryId
	 */
	public void setCategoryId(int categoryId) {
		
		this.categoryId = categoryId;
		
	}
	
	/**
	 * Generic getter for name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Generic setter for category name
	 * @param name
	 */
	public void setName(String name) {
		
		this.name = name;
		
	}
	
}
