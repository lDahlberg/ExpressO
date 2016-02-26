Welcome to the Express-O Application. We appreciate your purchase, and we look forward to your continued use of
this application now and well into the future. 

In order to properly set up the Express-O Application, you will need to follow a few important steps. 

1.	You will need to download the application through git @ https://github.com/lDahlberg/ExpressO.git

2.	Import Express-O into Eclipse (or your IDE of choice) 
	as a new Maven project. (File -> Import -> Exiting Maven Projects) Navigate to your chosen root directory
	and then hit the Finish Button.

3.	You will need to create a database in postGres (we recommend using pgAdmin III), titled final-project. If you have
	already created such a database, you can go Express-O's application properties in Eclipse under 
	src -> main -> resources -> application.properties and change the "final-project" destination at the end of:
	spring.datasource.url=jdbc\:postgresql\://localhost\:5432/final-project
	to your database of choice.

	IMPORTANT! If you are not using on a localhost, you will need to change the above to the ip address of the
	server on which Express-O will run. If you do not know the IP, open a Command Prompt and type ipconfig/all 
	on the server. 


4.	You will need to first run Express-O as it will populate the database tables automatically. To do so, in Eclipse, 
	go to src/main/java/lukedahlbergfinal.lukedahlbergfinal.springboot and right-click on the ExpressORunner. 
	Choose Run As -> Java Application. 

5.	First, close your Express-O session in Eclipse. Then open PGAdmin III if you haven't already and right click on the 
	final-project database (if you have not renamed it), and connect. Next, open an SQL Query, go to Open 
	and then navigate to the ExpressO.sql in the file folder of ExpressO. Run this file to populate the database.

6. 	Restart the Express-O App as in Step 4, wait for it to finish, then open a web browser, such as Chrome, and 
	navigate to localhost:8080. This will direct you to the Recipe Main Page. From this point, you can navigate through
	the three tabs, add ingredients, baked goods, or recipes, edit them, or delete recipes/baked goods. We hope you find this
	useful and we look forward to hearing your suggestions for improvement.

-The Express-O Development Team.