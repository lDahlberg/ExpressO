package lukedahlbergfinal.lukedahlbergfinal.services;

import java.util.List;

import lukedahlbergfinal.lukedahlbergfinal.entities.Allergen;
import lukedahlbergfinal.lukedahlbergfinal.entities.BakedGood;
import lukedahlbergfinal.lukedahlbergfinal.entities.Category;
import lukedahlbergfinal.lukedahlbergfinal.entities.Vendor;

/**
 * The methods declared in this interface provide WebService functionality for BakedGoods 
 * @author ldahlberg
 */
public interface BakedGoodService {

		/**
		 * Add a new bakedGood to the application.
		 * 
		 * @param bakedGood
		 */
		void add(BakedGood bakedGood);

		/**
		 * Update the information in an existing bakedGood. Uses parameter:
		 * @param bakedGood
		 */
		void update(BakedGood bakedGood);
		
		/**
		 * Deletes the BakedGood in storage by searching for its parameter:
		 * @param bakedGoodId
		 */
		void delete(Integer bakedGoodId);

		/**
		 * Retrieve all bakedGoods from the application.
		 * @return List<BakedGood>
		 */
		List<BakedGood> getAllBakedGoods();

		/**
		 * Retrieve a single bakedGood's information if that bakedGood's bakedGoodId
		 * matches @param bakedGoodId
		 * @return BakedGood
		 */
		BakedGood getBakedGoodById(Integer bakedGoodId);

		/**
		 * Retrieve a single bakedGood's information if that bakedGood's bakedGoodname
		 * matches the supplied bakedGoodname.
		 * 
		 * @param bakedGoodName
		 * @return BakedGood
		 */
		BakedGood getBakedGoodByName(String bakedGoodName);
		
		/**
		 * Retrieve all allergens
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
