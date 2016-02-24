package lukedahlbergfinal.lukedahlbergfinal.daos.hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import lukedahlbergfinal.lukedahlbergfinal.daos.RecipeDao;
import lukedahlbergfinal.lukedahlbergfinal.entities.Recipe;

/**
 * The hibernate functionality for the Recipe's Database Table
 * @author ldahlberg
 */
@Transactional
@Component
public class RecipeHibernateDao implements RecipeDao {

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
		 * Creates a new row in the database Recipe table.
		 * @param recipe
		 */
		public void add(Recipe recipe) {
			
				em.persist(recipe);
				
		}

		/**
		 * Updates a single row from the EndUser table corresponding to the 
		 * passed-in EndUser object.
		 * @param endUser
		 */
		public void update(Recipe recipe) {
			
			em.merge(recipe);
			
		}
		
		/**
		 * Deletes a row from the Recipe table corresponding to the 
		 * passed-in parameter:
		 * @param recipeId
		 */
		public void delete(Integer recipeId) {
			
			Recipe recipe = getRecipeById(recipeId);
			em.remove(recipe);
			
		}
		
		/**
		 * Returns a list of all the rows in the EndUser table.
		 * @return List<EndUser>
		 */
		public List<Recipe> getAllRecipes() {
			
				return em.createQuery("SELECT i FROM Recipe i", Recipe.class).
						getResultList();
			
		}

		/**
		 * Returns a single row from the EndUser table with the passed in user id.
		 * @param endUserId
		 * @return EndUser
		 */
		public Recipe getRecipeById(Integer recipeId) {
			
				return em.createQuery("SELECT i FROM Recipe i WHERE i.recipeId = :id", Recipe.class)
						.setParameter("id", recipeId)
						.getSingleResult();
				
		}

		/**
		 * Returns a single row from the EndUser table with the passed in user name.
		 * @param lastname
		 * @return EndUser
		 */
		public Recipe getRecipeByName(String recipeName){
			
				return em.createQuery("SELECT i FROM Recipe i WHERE i.name = :recipeName", Recipe.class)
						 .setParameter("recipeName", recipeName)
						 .getSingleResult();
			
		}
}
