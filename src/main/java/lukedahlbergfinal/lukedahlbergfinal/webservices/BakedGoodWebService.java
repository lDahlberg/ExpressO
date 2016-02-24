package lukedahlbergfinal.lukedahlbergfinal.webservices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lukedahlbergfinal.lukedahlbergfinal.entities.Allergen;
import lukedahlbergfinal.lukedahlbergfinal.entities.BakedGood;
import lukedahlbergfinal.lukedahlbergfinal.entities.Category;
import lukedahlbergfinal.lukedahlbergfinal.entities.Vendor;
import lukedahlbergfinal.lukedahlbergfinal.services.BakedGoodService;

/**
 * The web service for the BakedGood
 * @author ldahlberg
 */
@RestController
public class BakedGoodWebService {

	@Autowired
	private BakedGoodService bakedGoodService;
	
	/**
	 * Sets a BakedGoodService object
	 * @param bakedGoodService
	 */
	public void setBakedGoodService(BakedGoodService bakedGoodService) {
		this.bakedGoodService = bakedGoodService;
	}
		
	/**
	 * Returns a list of all the BakedGoods.
	 * @return List<BakedGood>
	 */
	@RequestMapping(value="/bakedgoods", method = RequestMethod.GET)
	public List<BakedGood> getAllBakedGoods(){
		return bakedGoodService.getAllBakedGoods();
	}	
	
	 /**
     * Retrieves BakedGood from Web and sends to Hibernate
     * @param BakedGood
     */
	@RequestMapping(value="/bakedgoods", method=RequestMethod.POST)
	public void add(@RequestBody BakedGood bakedGood){
		System.out.print(bakedGood);
		bakedGoodService.add(bakedGood);
	} 
	
    /**
     * Returns the information for a BakedGood with parameter:
     * @param id
     * @return BakedGood
     */
	@RequestMapping(value="/bakedgoods/{id}", method=RequestMethod.GET)
	public BakedGood getBakedGoodById(@PathVariable Integer id){ 
		return bakedGoodService.getBakedGoodById(id);
	}
	
	/**
	 * Edits an existing Baked Good in the BakedGood table
	 * @param bakedGood
	 */
	@RequestMapping(value="/bakedgoods/{id}", method = RequestMethod.PUT)
	public void update(@RequestBody BakedGood bakedGood){
		bakedGoodService.update(bakedGood);
	}
	
	/**
	 * Deletes an existing Baked Good in the BakedGood table
	 * @param bakedGoodId
	 */
	@RequestMapping(value="/bakedgoods/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Integer id){
		
		bakedGoodService.delete(id);
		 
	}
	
	/**
	 * Returns a list of all the Allergens.
	 * @return List<Allergen>
	 */
	@RequestMapping(value="/allergens", method = RequestMethod.GET)
	public List<Allergen> getAllAllergens(){
		return bakedGoodService.getAllAllergens();
	}
	
	/**
	 * Returns a list of all the Categories.
	 * @return List<Category>
	 */
	@RequestMapping(value="/categories", method = RequestMethod.GET)
	public List<Category> getAllCategories(){
		return bakedGoodService.getAllCategories();
	}
	
	/**
	 * Returns a list of all the Vendors.
	 * @return List<Vendor>
	 */
	@RequestMapping(value="/vendors", method = RequestMethod.GET)
	public List<Vendor> getAllVendors(){
		return bakedGoodService.getAllVendors();
	}
}
