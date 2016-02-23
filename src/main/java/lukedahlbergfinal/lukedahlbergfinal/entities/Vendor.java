package lukedahlbergfinal.lukedahlbergfinal.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vendor {
	private int vendorId;
	private String name;
	
	/**
	 * Generic getter for vendorId. Gets generated Hibernate ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getVendorId() {
		
		return vendorId;
		
	}
	
	/**
	 * Generic setter for vendorId
	 * @param vendorId
	 */
	public void setVendorId(int vendorId) {
		
		this.vendorId = vendorId;
		
	}
	
	/**
	 * Generic getter for name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Generic setter for vendor name
	 * @param name
	 */
	public void setName(String name) {
		
		this.name = name;
		
	}
}
