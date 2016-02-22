package lukedahlbergfinal.lukedahlbergfinal.services;

import java.util.List;

import lukedahlbergfinal.lukedahlbergfinal.entities.BakedGood;

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

}
