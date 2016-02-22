package lukedahlbergfinal.lukedahlbergfinal.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * This Java class represents the Baked Goods.
 * @author ldahlberg
 */
@Entity
public class BakedGood {

	private int bakedGoodId;
	private String name;
	private Double cost;
	private String vendorName;
	private Collection<Category> category;
	
	/**
	 * Generic getter for drinkId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getBakedGoodId() {
		
		return bakedGoodId;
		
	}
	
	/**
	 * Generic setter for drinkId
	 * @param bakedGoodId
	 */
	public void setBakedGoodId(int bakedGoodId) {
		
		this.bakedGoodId = bakedGoodId;
		
	}
	
	/**
	 * Generic getter for name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Generic setter for drink name
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
	 * Generic setter for coffee cost
	 * @param cost
	 */
	public void setCost(Double cost) {
		
		this.cost = cost;
		
	}
	
	/**
	 * Generic getter for vendor name
	 */
	public String getVendorName() {
		
		return vendorName;
		
	}
	
	/**
	 * Generic setter for coffee cost
	 * @param cost
	 */
	public void setVendorName(String vendorName) {
		
		this.vendorName = vendorName;
		
	}
	
	/**
	 * Generic getter for category
	 */
	@OneToMany(targetEntity = Category.class)
	@JoinColumn(name="categoryid")
	public Collection<Category> getCategory() {
		return category;
	}

	/**
	 * Generic setter for category
	 * @param category
	 */
	public void setCategory(Collection<Category> category) {
		this.category = category;
	}
}
