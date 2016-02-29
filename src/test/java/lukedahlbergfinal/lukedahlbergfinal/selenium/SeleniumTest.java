package lukedahlbergfinal.lukedahlbergfinal.selenium;

/**
 * This Java class tests the Web Functionality of the Express-O App.
 * @author ldahlberg
 */
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SeleniumTest {
	private WebDriver driver;
	String testLocation = "http://localhost:8080/#/recipeHome";
	String detailRedirect = "/html/body/div/ui-view/div[1]/div/a";
	String addNewBakedGoodButton = "/html/body/div/ui-view/form/div/div/button[1]";
	String addNewIngredientButton = "/html/body/div/ui-view/form/div/div/button[1]";
	String saveIngredientButton ="/html/body/div/ui-view/form/div/div/button[1]";
	String saveBakedGoodButton = "/html/body/div/ui-view/form/div/div/button[1]";
	String saveRecipeButton = "/html/body/div/ui-view/form/div[3]/div/button[1]";
	String editIngredient = "/html/body/div/ui-view/div/div/button[1]";
	String editBakedGood = "/html/body/div/ui-view/div/div/button[1]";
	String editRecipe = "/html/body/div/ui-view/div/div/button[1]";
	String deleteBakedGoodButton = "/html/body/div/ui-view/div/div/button[3]";
	String deleteRecipeButton = "/html/body/div/ui-view/div/div/button[3]";
	String addIngredientRecipeButton ="/html/body/div/ui-view/form/div[2]/div[1]/button";
	String addNewRecipeButton ="/html/body/div/ui-view/form/div[3]/div/button[1]";
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:/tools/chromedriver.exe/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	/**
	 * Test to ensure that correct page is loaded.
	 **/
	@Test
	public void getTitle() {
		driver.get(testLocation);
		String actualTitle = driver.getTitle();
		assertEquals("Express-O", actualTitle);
	}
	
	/**
	 * Test to ensure that Baked Goods button redirects to Baked Goods Home.
	 */
	@Test
	public void testBakedGoodsRedirection() throws InterruptedException {
		driver.get(testLocation);
		driver.findElement(By.linkText("Baked Goods")).click();
		Thread.sleep(1000);
		String url = driver.getCurrentUrl();
		assertEquals("http://localhost:8080/#/bakedGoodHome", url);
	}
	
	/**
	 * Test to ensure that Ingredients button redirects to Ingredients Home
	 */
	@Test
	public void testIngredientsRedirection() throws InterruptedException {
		driver.get(testLocation);
		driver.findElement(By.linkText("Ingredients")).click();
		Thread.sleep(1000);
		String url = driver.getCurrentUrl();
		assertEquals("http://localhost:8080/#/ingredientHome", url);
	}
	
	/**
	 * Test to ensure that Add New Recipe button redirects to newRecipe page
	 */
	@Test
	public void testRecipeAddPageLocation() throws InterruptedException {
		driver.get(testLocation);
		driver.findElement(By.cssSelector("button")).click();
		Thread.sleep(1000);
		String url = driver.getCurrentUrl();
		assertEquals("http://localhost:8080/#/newRecipe", url);
	}
	
	/**
	 * Test to ensure that Add New Baked Goods button redirects to Baked Goods Add Page.
	 */
	@Test
	public void testBakedGoodsAddNewRedirect() throws InterruptedException {
		driver.get(testLocation);
		driver.findElement(By.linkText("Baked Goods")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("button")).click();
		Thread.sleep(1000);
		String url = driver.getCurrentUrl();
		assertEquals("http://localhost:8080/#/newBakedGood", url);
	}
	
	/**
	 * Test to ensure that Add New Ingredients button redirects to Ingredients Add Page.
	 */
	@Test
	public void testIngredientsAddNewRedirect() throws InterruptedException {
		driver.get(testLocation);
		driver.findElement(By.linkText("Ingredients")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("button")).click();
		Thread.sleep(1000);
		String url = driver.getCurrentUrl();
		assertEquals("http://localhost:8080/#/newIngredient", url);
	}
	
	/**
	 * Test to ensure that Recipe Edit page redirects to detail page.
	 * @throws InterruptedException 
	 */
	@Test
	public void testRecipeEditRedirection() throws InterruptedException {
		driver.get(testLocation);
		driver.findElement(By.xpath(detailRedirect)).click();
		Thread.sleep(1000);
		String url = driver.getCurrentUrl();
		assertEquals("http://localhost:8080/#/recipeDetail", url);
	}
	
	/**
	 * Test to ensure that Ingredients button redirects to Ingredients Home
	 */
	@Test
	public void testBakedGoodsEditRedirection() throws InterruptedException {
		driver.get(testLocation);
		driver.findElement(By.linkText("Baked Goods")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(detailRedirect)).click();
		Thread.sleep(1000);
		String url = driver.getCurrentUrl();
		assertEquals("http://localhost:8080/#/bakedGoodDetail", url);
	}
	
	/**
	 * Test to ensure that Ingredients button redirects to Ingredients Home
	 */
	@Test
	public void testIngredientsEditRedirection() throws InterruptedException {
		driver.get(testLocation);
		driver.findElement(By.linkText("Ingredients")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(detailRedirect)).click();
		Thread.sleep(1000);
		String url = driver.getCurrentUrl();
		assertEquals("http://localhost:8080/#/ingredientDetail", url);
	}
	
	/**
	 * Test that ensures Ingredient Add, Edit, and Delete act appropriately.
	 */
	@Test
	public void testIngredientHappyPath() throws InterruptedException {
		
		//Add function
		driver.get(testLocation);
		driver.findElement(By.linkText("Ingredients")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("button")).click();
		Thread.sleep(1000);
		WebElement nameElement = driver.findElement(By.id("ingredientName"));
		nameElement.sendKeys("test");
		WebElement costElement = driver.findElement(By.id("ingredientCost"));
		costElement.sendKeys("2");
		WebElement measureElement = driver.findElement(By.id("ingredientMeasure"));
		measureElement.sendKeys("2");
		driver.findElement(By.xpath(addNewIngredientButton)).click();
		Thread.sleep(1000);
		
		//Edit function
		driver.findElement(By.linkText("test")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(editIngredient)).click();
		Thread.sleep(1000);
		WebElement nameEdit = driver.findElement(By.id("ingredientName"));
		nameEdit.sendKeys("2");
		WebElement costEdit = driver.findElement(By.id("ingredientCost"));
		costEdit.sendKeys("2");
		WebElement measureEdit = driver.findElement(By.id("ingredientMeasure"));
		measureEdit.sendKeys("2");
		driver.findElement(By.xpath(saveIngredientButton)).click();
		Thread.sleep(1000);
		
	}
	
	/**
	 * Test that ensures Ingredient Add, Edit, and Delete act appropriately.
	 */
	@Test
	public void testBakedGoodHappyPath() throws InterruptedException {
		
		//Add function
		driver.get(testLocation);
		driver.findElement(By.linkText("Baked Goods")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("button")).click();
		Thread.sleep(1000);
		WebElement nameElement = driver.findElement(By.id("bakedGoodName"));
		nameElement.sendKeys("test");
		WebElement costElement = driver.findElement(By.id("bakedGoodCost"));
		costElement.sendKeys("2");
		new Select(driver.findElement(By.name("bakedGoodVendor"))).selectByVisibleText("Hinkleman Bagels");
		new Select(driver.findElement(By.name("bakedGoodAllergen"))).selectByVisibleText("Peanuts");
		new Select(driver.findElement(By.name("bakedGoodCategory"))).selectByVisibleText("Bagel");
		driver.findElement(By.xpath(addNewBakedGoodButton)).click();
		Thread.sleep(1000);
		
		//Edit function
		driver.findElement(By.linkText("test")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(editBakedGood)).click();
		Thread.sleep(1000);
		WebElement nameEdit = driver.findElement(By.id("bakedGoodName"));
		nameEdit.sendKeys("2");
		driver.findElement(By.xpath(saveBakedGoodButton)).click();
		Thread.sleep(1000);
		
		//Delete function
		driver.findElement(By.linkText("test2")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(deleteBakedGoodButton)).click();
		Thread.sleep(2000);
		String url = driver.getCurrentUrl();
		assertEquals("http://localhost:8080/#/bakedGoodHome", url);
	}
	
	/**
	 * Test that ensures Ingredient Add, Edit, and Delete act appropriately.
	 */
	@Test
	public void testRecipeHappyPath() throws InterruptedException {
		
		//Add function
		driver.get(testLocation);
		driver.findElement(By.cssSelector("button")).click();
		Thread.sleep(1000);
		WebElement nameElement = driver.findElement(By.id("recipeName"));
		nameElement.sendKeys("test");
		WebElement costElement = driver.findElement(By.id("recipeInstructions"));
		costElement.sendKeys("testable");
		new Select(driver.findElement(By.name("ingredients"))).selectByVisibleText("Small Milk");
		driver.findElement(By.xpath(addIngredientRecipeButton)).click();
		driver.findElement(By.xpath(addNewRecipeButton)).click();
		Thread.sleep(2000);
		
		//Edit function
		driver.findElement(By.linkText("test")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(editRecipe)).click();
		Thread.sleep(1000);
		WebElement nameEdit = driver.findElement(By.id("recipeName"));
		nameEdit.sendKeys("2");
		driver.findElement(By.xpath(saveRecipeButton)).click();
		Thread.sleep(1000);
		
		//Delete function
		driver.findElement(By.linkText("test2")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(deleteRecipeButton)).click();
		Thread.sleep(2000);
		String url = driver.getCurrentUrl();
		assertEquals("http://localhost:8080/#/recipeHome", url);
	}
	
	@After
	public void tearDown() throws Exception {
		driver.close();
		driver.quit();
	}
}
