package at.roomplanning;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.metamodel.Type.PersistenceType;

import at.roomplanning.entities.Employee;
import at.roomplanning.entities.EmployeeRole;
import at.roomplanning.entities.Performance;
import at.roomplanning.entities.PerformanceType;
import at.roomplanning.entities.Role;

/**
 * http://stackoverflow.com/questions/5127129/mapping-many-to-many-association-table-with-extra-columns
 * 
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		/*Configuration configuration = new Configuration();
		configuration.configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
*/
		
		
		// employee
		Employee emp = new Employee();
		emp.setFirstName("Martin");
		emp.setFamilyName("Schliefellner");
		Calendar calendar = GregorianCalendar.getInstance();
		calendar.set(1988, 10, 4);
		emp.setBirthDate(calendar.getTime());
		
		// roles
		Role drummer = new Role();
		drummer.setName("Drummer");
		
		Role singer = new Role();
		singer.setName("Singer");		
		
		// set roles
		EmployeeRole emp_drummer = new EmployeeRole();
		emp_drummer.setEmployee(emp);
		emp_drummer.setRole(drummer);

		EmployeeRole emp_singer = new EmployeeRole();
		emp_singer.setEmployee(emp);
		emp_singer.setRole(singer);	
		
		emp.getEmployeeroles().add(emp_drummer);
		emp.getEmployeeroles().add(emp_singer);
		
		drummer.getEmployeeRoles().add(emp_drummer);
		singer.getEmployeeRoles().add(emp_singer);
		
		// performance
		Performance performance = new Performance();
		performance.setName("Carmen");
		calendar.set(2014, 10, 4, 20, 0, 0);
		performance.setDate(calendar.getTime());
		
		emp.getPerformances().add(performance);
		performance.getEmployees().add(emp);
		
		// performance type
		PerformanceType perfType = new PerformanceType();
		perfType.setType(PerformanceType.Type.CORREPETITION2PREMIERE);
		perfType.getPerformances().add(performance);
		performance.setPerformanceType(perfType);
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory( "at.roomplanning" );
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist( emp );
		entityManager.persist( drummer );
		entityManager.persist( singer );
		entityManager.persist( emp_drummer );
		entityManager.persist( emp_singer );
		entityManager.getTransaction().commit();
		
		Query query = entityManager.createQuery("SELECT e FROM Employee e");
		@SuppressWarnings("unchecked")
		ArrayList<Employee> result = (ArrayList<Employee>) query.getResultList();
		for (Employee e : result) {
			System.out.println("Name = " + e.getFirstName() + " " + e.getFamilyName() + ":" + e.getEmployeeroles().size());
			for (EmployeeRole er : e.getEmployeeroles()) {
				System.out.println("Role: " + er.getRole().getName());
			}
		}
		
		entityManager.close();
		
		entityManagerFactory.close();
		
		/*
		Session s = sessionFactory.openSession();
		s.beginTransaction();
		s.save(emp);
		s.getTransaction().commit();
		s.close();*/
	}
}
