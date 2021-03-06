package lukedahlbergfinal.lukedahlbergfinal.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lukedahlbergfinal.lukedahlbergfinal.daos.BakedGoodDao;
import lukedahlbergfinal.lukedahlbergfinal.entities.Allergen;
import lukedahlbergfinal.lukedahlbergfinal.entities.BakedGood;
import lukedahlbergfinal.lukedahlbergfinal.entities.Category;
import lukedahlbergfinal.lukedahlbergfinal.entities.Vendor;
import lukedahlbergfinal.lukedahlbergfinal.services.BakedGoodService;

@Service
public class BakedGoodServiceImpl implements BakedGoodService {

	@Autowired
	private BakedGoodDao bakedGoodDao;

	/**
	 * Sets the bakedGoodDao object
	 * @param bakedGoodDao
	 */
	public void setBakedGoodDao(BakedGoodDao bakedGoodDao) {
		
		this.bakedGoodDao = bakedGoodDao;
		
	}

	/**
	 * Add a new BakedGood to the application.
	 * @param bakedGood
	 */
	public void add(BakedGood bakedGood) {

		bakedGoodDao.add(bakedGood);
		
	}

	/**
	 * Update the information in an existing BakedGood. The bakedGoodId is used to
	 * find the unique bakedGood's information.
	 * @param bakedGood
	 */
	public void update(BakedGood bakedGood) {
		
		bakedGoodDao.update(bakedGood);
		
	}
	
	/**
	 * Delete an existing BakedGood by referencing its parameter:
	 * @parameter: bakedGoodId
	 */
	public void delete(Integer bakedGoodId) {
		bakedGoodDao.delete(bakedGoodId);
	}
	
	
	/**
	 * Retrieve all BakedGoods from the application.
	 * @return
	 */
	public List<BakedGood> getAllBakedGoods() {

		List<BakedGood> bakedGoods = bakedGoodDao.getAllBakedGoods();
		return bakedGoods;
		
	}

	/**
	 * Retrieve a single bakedGood's information if that bakedGood's bakedGoodId
	 * matches the supplied bakedGoodId
	 * @param bakedGoodId
	 * @return BakedGood
	 */
	public BakedGood getBakedGoodById(Integer bakedGoodId){
		return bakedGoodDao.getBakedGoodById(bakedGoodId);
	}

	/**
	 * Retrieve a single bakedGood's information if that bakedGood's bakedGoodName
	 * matches the supplied bakedGoodName.
	 * @param bakedGoodName
	 * @return BakedGood
	 **/
	public BakedGood getBakedGoodByName(String bakedGoodName) {
		return bakedGoodDao.getBakedGoodByName(bakedGoodName);

	}
	
	/**
	 * Retrieve all BakedGoods from the application.
	 * @return
	 */
	public List<Allergen> getAllAllergens() {

		List<Allergen> allergens = bakedGoodDao.getAllAllergens();
		return allergens;
		
	}
	
	/**
	 * Retrieve all Categories from the application.
	 * @return
	 */
	public List<Category> getAllCategories() {

		List<Category> categories = bakedGoodDao.getAllCategories();
		return categories;
		
	}
	
	/**
	 * Retrieve all Vendors from the application.
	 * @return
	 */
	public List<Vendor> getAllVendors() {

		List<Vendor> vendor = bakedGoodDao.getAllVendors();
		return vendor;
		
	}

}
