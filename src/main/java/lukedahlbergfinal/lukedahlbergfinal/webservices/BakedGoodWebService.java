package lukedahlbergfinal.lukedahlbergfinal.webservices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lukedahlbergfinal.lukedahlbergfinal.entities.BakedGood;
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
	
	//TODO: Add Delete
}
