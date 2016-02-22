package lukedahlbergfinal.lukedahlbergfinal.daos.hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import lukedahlbergfinal.lukedahlbergfinal.daos.IngredientDao;
import lukedahlbergfinal.lukedahlbergfinal.entities.Ingredient;

/**
 * The hibernate functionality for the Ingredient's Database Table
 * @author ldahlberg
 */
@Transactional
@Component
public class IngredientHibernateDao implements IngredientDao {

		@PersistenceContext
		private EntityManager em;
		
		/**
		 * Sets the EntityManager
		 * @param em
		 */
		public void setEm(EntityManager em) {
			
			this.em = em;
			
		}
		
		/**
		 * Creates a new row in the database Ingredient table.
		 * @param ingredient
		 */
		public void add(Ingredient ingredient) {
			
				em.persist(ingredient);
				
		}

		/**
		 * Updates a single row from the EndUser table corresponding to the 
		 * passed-in EndUser object.
		 * @param endUser
		 */
		public void update(Ingredient ingredient) {
			
			em.merge(ingredient);
			
		}
		
		/**
		 * Returns a list of all the rows in the EndUser table.
		 * @return List<EndUser>
		 */
		public List<Ingredient> getAllIngredients() {
			
				return em.createQuery("SELECT i FROM Ingredient i", Ingredient.class).
						getResultList();
			
		}

		/**
		 * Returns a single row from the EndUser table with the passed in user id.
		 * @param endUserId
		 * @return EndUser
		 */
		public Ingredient getIngredientById(Integer ingredientId) {
			
				return em.createQuery("SELECT i FROM Ingredient i WHERE i.ingredientId = :id", Ingredient.class)
						.setParameter("id", ingredientId)
						.getSingleResult();
				
		}

		/**
		 * Returns a single row from the EndUser table with the passed in user name.
		 * @param lastname
		 * @return EndUser
		 */
		public Ingredient getIngredientByName(String ingredientName){
			
				return em.createQuery("SELECT i FROM Ingredient i WHERE i.name = :ingredientName", Ingredient.class)
						 .setParameter("ingredientName", ingredientName)
						 .getSingleResult();
			
		}
}
