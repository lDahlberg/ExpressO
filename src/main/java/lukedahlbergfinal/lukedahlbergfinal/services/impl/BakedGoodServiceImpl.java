package lukedahlbergfinal.lukedahlbergfinal.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lukedahlbergfinal.lukedahlbergfinal.entities.BakedGood;
import lukedahlbergfinal.lukedahlbergfinal.services.BakedGoodService;

@Service
public class BakedGoodServiceImpl implements BakedGoodService {

	@Autowired
	private BakedGoodService bakedGoodService;

	/**
	 * Sets the bakedGoodService object
	 * @param bakedGoodService
	 */
	public void setBakedGoodService(BakedGoodService bakedGoodService) {
		
		this.bakedGoodService = bakedGoodService;
		
	}

	/**
	 * Retrieve all BakedGoods from the application.
	 * @return
	 */
	public List<BakedGood> getAllBakedGoods() {

		List<BakedGood> bakedGoods = bakedGoodService.getAllBakedGoods();
		return bakedGoods;
		
	}

	/**
	 * Add a new BakedGood to the application.
	 * @param bakedGood
	 */
	public void add(BakedGood bakedGood) {

		bakedGoodService.add(bakedGood);
		
	}

	/**
	 * Update the information in an existing BakedGood. The bakedGoodId is used to
	 * find the unique bakedGood's information.
	 * @param bakedGood
	 */
	public void update(BakedGood bakedGood) {
		bakedGoodService.update(bakedGood);
	}

	/**
	 * Retrieve a single bakedGood's information if that bakedGood's bakedGoodId
	 * matches the supplied bakedGoodId
	 * @param bakedGoodId
	 * @return BakedGood
	 */
	public BakedGood getBakedGoodById(Integer bakedGoodId){
		return bakedGoodService.getBakedGoodById(bakedGoodId);
	}

	/**
	 * Retrieve a single bakedGood's information if that bakedGood's bakedGoodName
	 * matches the supplied bakedGoodName.
	 * @param bakedGoodName
	 * @return BakedGood
	 **/
	public BakedGood getBakedGoodByName(String bakedGoodName) {
		return bakedGoodService.getBakedGoodByName(bakedGoodName);

	}
}
