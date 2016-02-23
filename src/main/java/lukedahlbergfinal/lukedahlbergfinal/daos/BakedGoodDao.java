package lukedahlbergfinal.lukedahlbergfinal.daos;

import java.util.List;

import lukedahlbergfinal.lukedahlbergfinal.entities.Allergen;
import lukedahlbergfinal.lukedahlbergfinal.entities.BakedGood;
import lukedahlbergfinal.lukedahlbergfinal.entities.Category;
import lukedahlbergfinal.lukedahlbergfinal.entities.Vendor;

/**
 * The methods declared in this interface are to provide basic CRUD functionality related to bakedGood objects.
 * @author lDahlberg
 *
 */
public interface BakedGoodDao {

	/**
	 * Adds information about an bakedGood to storage.
	 * @param bakedGood
	 */
	void add(BakedGood bakedGood);

	/**
	 * Updates the information about an bakedGood already in storage.
	 * @param bakedGood
	 */
	void update(BakedGood bakedGood);
	
	/**
	 * Retrieves all bakedGoods currently in storage.
	 * @return all BakedGoods
	 */
	List<BakedGood> getAllBakedGoods();
	
	/**
	 * Retrieve information about a single bakedGood from storage with a matching bakedGoodId
	 * @param bakedGoodId
	 * @return BakedGood
	 */
	BakedGood getBakedGoodById(Integer bakedGoodId);

	/**
	 * Retrieves an bakedGood with a matching bakedGoodName.
	 * 
	 * @param bakedGoodName
	 * @return BakedGood
	 */
	BakedGood getBakedGoodByName(String bakedGoodName);
	
	/**
	 * Retrieves all allergens currently in storage.
	 * @return List<Allergen>
	 */
	List<Allergen> getAllAllergens();
	
	/**
	 * Retrieves all categories currently in storage.
	 * @return List<Category>
	 */
	List<Category> getAllCategories();
	
	/**
	 * Retrieves all vendors currently in storage.
	 * @return List<Vendor>
	 */
	List<Vendor> getAllVendors();
	
}
