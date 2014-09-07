package roomplanning;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import roomplanning.db.dao.EmployeeRepository;

/**
 * http://stackoverflow.com/questions/5127129/mapping-many-to-many-association-
 * table-with-extra-columns
 * 
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan({"roomplanning"})
public class App implements CommandLineRunner {
	
	@Autowired
	private EntityManager entityManager;
	
	@Autowired 
	EmployeeRepository repo;
	
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	public void run(String... arg0) throws Exception {

		try {
			System.out.println("Type something to finish application.");
			BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
			bufferRead.readLine();

			System.out.println("Closing...");
			entityManager.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
