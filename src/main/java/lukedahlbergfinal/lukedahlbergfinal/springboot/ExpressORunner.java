package lukedahlbergfinal.lukedahlbergfinal.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;

import lukedahlbergfinal.lukedahlbergfinal.entities.BakedGood;

/**
 * This Application allows the owner of a local coffee shop to create, view, update, and delete
 * both coffee drink recipes and baked goods.
 * @author ldahlberg
 *
 */
@SpringBootApplication
@EntityScan(basePackageClasses=BakedGood.class)
public class ExpressORunner 
{
    public static void main( String[] args ){
    	
    	SpringApplication.run(ExpressORunner.class);
    	
    }
}
