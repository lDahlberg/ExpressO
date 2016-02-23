package lukedahlbergfinal.lukedahlbergfinal.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 * This Java class represents the Baked Goods.
 * @author ldahlberg
 */
@Entity
public class BakedGood {

	private int bakedGoodId;
	private String name;
	private Double cost;
	private Vendor vendor;
	private List<Allergen> allergen;
	private Category category;
	
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
	@ManyToOne(targetEntity = Vendor.class)
	@JoinColumn(name="vendorid")
	public Vendor getVendor() {
		
		return vendor;
		
	}
	
	/**
	 * Generic setter for coffee cost
	 * @param cost
	 */
	public void setVendor(Vendor vendor) {
		
		this.vendor = vendor;
		
	}
	
	/**
	 * Generic getter for category
	 */
	@ManyToOne(targetEntity = Category.class)
	@JoinColumn(name="categoryid")
	public Category getCategory() {
		return category;
	}

	/**
	 * Generic setter for category
	 * @param category
	 */
	public void setCategory(Category category) {
		this.category = category;
	}

	/**
	 * Generic getter for allergen
	 */
	//TODO: Add multiple allergens
	@ManyToMany(targetEntity = Allergen.class)
	@JoinColumn(name="allergenid")
	public List<Allergen> getAllergen() {
		return allergen;
	}

	/**
	 * Generic setter for allergen
	 * @param allergen
	 */
	public void setAllergen(List<Allergen> allergen) {
		this.allergen = allergen;
	}
}
