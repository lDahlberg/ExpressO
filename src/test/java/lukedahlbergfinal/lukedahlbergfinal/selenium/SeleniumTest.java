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

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:/tools/chromedriver.exe");
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
		driver.findElement(By.xpath("/html/body/header/ul/li[3]/a")).click();
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
		driver.findElement(By.xpath("/html/body/header/ul/li[4]/a")).click();
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
		driver.findElement(By.xpath("/html/body/ui-view/button")).click();
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
		driver.findElement(By.xpath("/html/body/header/ul/li[3]/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/ui-view/button")).click();
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
		driver.findElement(By.xpath("/html/body/header/ul/li[4]/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/ui-view/button")).click();
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
		driver.findElement(By.xpath("/html/body/ui-view/div/div/a")).click();
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
		driver.findElement(By.xpath("/html/body/header/ul/li[3]/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/ui-view/div/div/a")).click();
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
		driver.findElement(By.xpath("/html/body/header/ul/li[4]/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/ui-view/div[1]/div/a")).click();
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
		driver.findElement(By.xpath("/html/body/header/ul/li[4]/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/ui-view/button")).click();
		Thread.sleep(1000);
		WebElement nameElement = driver.findElement(By.id("ingredientName"));
		nameElement.sendKeys("test");
		WebElement costElement = driver.findElement(By.id("ingredientCost"));
		costElement.sendKeys("2");
		WebElement measureElement = driver.findElement(By.id("ingredientMeasure"));
		measureElement.sendKeys("2");
		driver.findElement(By.xpath("/html/body/ui-view/form/div/div/button[1]")).click();
		Thread.sleep(1000);
		
		//Edit function
		driver.findElement(By.linkText("test")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/ui-view/div/div/button[1]")).click();
		Thread.sleep(1000);
		WebElement nameEdit = driver.findElement(By.id("ingredientName"));
		nameEdit.sendKeys("2");
		WebElement costEdit = driver.findElement(By.id("ingredientCost"));
		costEdit.sendKeys("2");
		WebElement measureEdit = driver.findElement(By.id("ingredientMeasure"));
		measureEdit.sendKeys("2");
		driver.findElement(By.xpath("/html/body/ui-view/form/div/div/button[1]")).click();
		Thread.sleep(1000);
		
	}
	
	/**
	 * Test that ensures Ingredient Add, Edit, and Delete act appropriately.
	 */
	@Test
	public void testBakedGoodHappyPath() throws InterruptedException {
		
		//Add function
		driver.get(testLocation);
		driver.findElement(By.xpath("/html/body/header/ul/li[3]/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/ui-view/button")).click();
		Thread.sleep(1000);
		WebElement nameElement = driver.findElement(By.id("bakedGoodName"));
		nameElement.sendKeys("test");
		WebElement costElement = driver.findElement(By.id("bakedGoodCost"));
		costElement.sendKeys("2");
		new Select(driver.findElement(By.name("bakedGoodVendor"))).selectByVisibleText("Hinkleman Bagels");
		new Select(driver.findElement(By.name("bakedGoodAllergen"))).selectByVisibleText("Peanuts");
		new Select(driver.findElement(By.name("bakedGoodCategory"))).selectByVisibleText("Bagels");
		driver.findElement(By.xpath("/html/body/ui-view/form/div/div/button[1]")).click();
		Thread.sleep(1000);
		
		//Edit function
		driver.findElement(By.linkText("test")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/ui-view/div/div/button[1]")).click();
		Thread.sleep(1000);
		WebElement nameEdit = driver.findElement(By.id("bakedGoodName"));
		nameEdit.sendKeys("2");
		driver.findElement(By.xpath("/html/body/ui-view/form/div/div/button[1]")).click();
		Thread.sleep(1000);
		
		//Delete function
		driver.findElement(By.linkText("test2")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/ui-view/div/div/button[2]")).click();
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
		driver.findElement(By.xpath("/html/body/ui-view/button")).click();
		Thread.sleep(1000);
		WebElement nameElement = driver.findElement(By.id("recipeName"));
		nameElement.sendKeys("test");
		WebElement costElement = driver.findElement(By.id("recipeInstructions"));
		costElement.sendKeys("testable");
		new Select(driver.findElement(By.name("ingredients"))).selectByVisibleText("Small Milk");
		driver.findElement(By.xpath("/html/body/ui-view/form/div[3]/div[1]/button")).click();
		driver.findElement(By.xpath("/html/body/ui-view/form/div[1]/div/button[1]")).click();
		Thread.sleep(2000);
		
		//Edit function
		driver.findElement(By.linkText("test")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/ui-view/div/div/button[1]")).click();
		Thread.sleep(1000);
		WebElement nameEdit = driver.findElement(By.id("recipeName"));
		nameEdit.sendKeys("2");
		driver.findElement(By.xpath("/html/body/ui-view/form/div[1]/div/button[1]")).click();
		Thread.sleep(1000);
		
		//Delete function
		driver.findElement(By.linkText("test2")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/ui-view/div/div/button[3]")).click();
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
