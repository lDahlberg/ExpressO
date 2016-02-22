package lukedahlbergfinal.lukedahlbergfinal.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;

/**
 * This Application allows the owner of a local coffee shop to create, view, update, and delete
 * both coffee drink recipes and baked goods.
 * @author ldahlberg
 *
 */
@SpringBootApplication
@ComponentScan(basePackages="lukedahlbergfinal.lukedahlbergfinal.controllers")
@EntityScan(basePackages="lukedahlbergfinal.lukedahlbergfinal.entities")
public class ExpressORunner 
{
    public static void main( String[] args ){
    	
    	SpringApplication.run(ExpressORunner.class);
    	
    }
}
