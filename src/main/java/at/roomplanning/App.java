package at.roomplanning;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import at.roomplanning.entities.Employee;
import at.roomplanning.entities.Employee_Role;
import at.roomplanning.entities.Performance;
import at.roomplanning.entities.PerformanceType;
import at.roomplanning.entities.Performance_Process;
import at.roomplanning.entities.Rehearsal;
import at.roomplanning.entities.Process;
import at.roomplanning.entities.Role;
import at.roomplanning.entities.Room;
import at.roomplanning.testdata.TestData;

/**
 * http://stackoverflow.com/questions/5127129/mapping-many-to-many-association-
 * table-with-extra-columns
 * 
 */
public class App {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory("at.roomplanning");
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();
		TestData testData = new TestData(entityManager);
		testData.insertProcessAndPerformanceTypes();
		;

		Calendar calendar = GregorianCalendar.getInstance();
		Performance performance_salome = new Performance();
		performance_salome.setName("Salome");
		calendar.set(2014, 10, 8, 20, 0, 0);
		performance_salome.setDate(calendar.getTime());

		Query query = entityManager
				.createQuery("SELECT p FROM PerformanceType p WHERE p.name='REPERTOIRE'");
		// System.out.println((PerformanceType) query.getResultList().get(0));
		performance_salome.setPerformanceType((PerformanceType) query
				.getResultList().get(0));

		Process start = performance_salome.getPerformanceType()
				.getProcessStart();

		int i = 10;
		while (start.getNext() != null) {
			Performance_Process pf = new Performance_Process();
			pf.setPerformance(performance_salome);
			pf.setProcessEntry(start);
			pf.setCount(i--);
			performance_salome.getProcessEntries().add(pf);
			start = start.getNext();
		}

		start = performance_salome.getPerformanceType().getProcessStart();

		ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<String, Integer>();
		for (Performance_Process tmp : performance_salome.getProcessEntries()) {
			map.put(tmp.getProcessEntry().getName(), tmp.getCount());
		}
		while (start.getNext() != null) {
			System.out.println(performance_salome.getName() + ": "
					+ start.getName() + " mit " + map.get(start.getName())
					+ " Proben");
			start = start.getNext();
		}

		try {
			System.out.println("Type something to finish application.");
			BufferedReader bufferRead = new BufferedReader(
					new InputStreamReader(System.in));
			String s = bufferRead.readLine();

			System.out.println("Closing...");
			entityManager.close();
			entityManagerFactory.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		/*
		 * query = entityManager .createQuery("Select p FROM Process p");
		 * 
		 * @SuppressWarnings("unchecked") ArrayList<Process> res =
		 * (ArrayList<Process>) query .getResultList(); Process start =
		 * (res.size() > 0) ? res.get(0) : null; if (start != null) { while
		 * (start.getNext() != null) { String name = start.getName();
		 * System.out.println(name); if (start.getPrevious() != null &&
		 * start.getPrevious().size() > 1) { for (Process tmp :
		 * start.getPrevious()) { if (tmp.getName().equals(name)) { continue; }
		 * System.out.println(tmp.getName()); } } start = start.getNext(); } }
		 * 
		 * 
		 * 
		 * try { System.out.println("Type something to finish application.");
		 * BufferedReader bufferRead = new BufferedReader( new
		 * InputStreamReader(System.in)); String s = bufferRead.readLine();
		 * 
		 * System.out.println("Closing..."); entityManager.close();
		 * entityManagerFactory.close(); } catch (IOException e) {
		 * e.printStackTrace(); } }
		 * 
		 * 
		 * /** Select all Employees with their Roles/Functions
		 */

		/*
		 * Query query = entityManager.createQuery("SELECT e FROM Employee e");
		 * 
		 * @SuppressWarnings("unchecked") ArrayList<Employee> result =
		 * (ArrayList<Employee>) query .getResultList(); for (Employee e :
		 * result) { System.out.println("Name = " + e.getFirstName() + " " +
		 * e.getFamilyName() + ":" + e.getEmployeeroles().size()); for
		 * (Employee_Role er : e.getEmployeeroles()) {
		 * System.out.println("Role: " + er.getRole().getName()); } }
		 */
	}

}
