package application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.ibm.javametrics.spring", "application.resources", 
								"application.health", "application"})
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

}
