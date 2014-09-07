package at.roomplanning;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * http://stackoverflow.com/questions/5127129/mapping-many-to-many-association-
 * table-with-extra-columns
 * 
 */
public class App {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("at.roomplanning");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		try {
			System.out.println("Type something to finish application.");
			BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
			bufferRead.readLine();

			System.out.println("Closing...");
			entityManager.close();
			entityManagerFactory.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
