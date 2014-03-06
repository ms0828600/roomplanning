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
import at.roomplanning.entities.Rehearsal;
import at.roomplanning.entities.RehearsalType;
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
		
		// Rehearsal types for Correpetition2premiere
		RehearsalType correpetition = new RehearsalType();
		correpetition.setName("Korrepetitionsprobe");
		correpetition.setNumber(3);
		correpetition.setPrevious(null);
		
		RehearsalType ensemble = new RehearsalType();
		ensemble.setName("Ensembleprobe");
		ensemble.setNumber(2);
		ensemble.getPrevious().add(correpetition);
		correpetition.setNext(ensemble);
		
		RehearsalType scenes = new RehearsalType();
		scenes.setName("Szenische Proben");
		scenes.setNumber(2);
		scenes.getPrevious().add(ensemble);
		ensemble.setNext(scenes);
		
		RehearsalType chor = new RehearsalType();
		chor.setName("Chor allein Probe");
		chor.setNumber(2);
		chor.setPrevious(null);
		
		RehearsalType orchester_alone = new RehearsalType();
		orchester_alone.setName("Orchester allein Probe");
		orchester_alone.setNumber(2);
		orchester_alone.setPrevious(null);
		
		
		RehearsalType stage = new RehearsalType();
		stage.setName("Bühnenprobe");
		stage.setNumber(3);
		stage.getPrevious().add(scenes);
		stage.getPrevious().add(chor);
		stage.getPrevious().add(orchester_alone);
		chor.setNext(stage);
		orchester_alone.setNext(stage);
		scenes.setNext(stage);
		
		RehearsalType piano = new RehearsalType();
		piano.setName("Klavierprobe");
		piano.setNumber(1);
		piano.getPrevious().add(stage);
		stage.setNext(piano);
		
		RehearsalType orchesterMain = new RehearsalType();
		orchesterMain.setName("Orchesterhauptprobe");
		orchesterMain.setNumber(1);
		orchesterMain.getPrevious().add(piano);
		piano.setNext(orchesterMain);
		
		RehearsalType general = new RehearsalType();
		general.setName("Generalprobe");
		general.setNumber(2);
		general.getPrevious().add(orchesterMain);
		orchesterMain.setNext(general);
		
		RehearsalType premiere = new RehearsalType();
		premiere.setName("Premiere");
		premiere.setNumber(1);
		premiere.getPrevious().add(general);
		premiere.setNext(null);
		general.setNext(premiere);
		
		
		
		entityManager.getTransaction().begin();
		entityManager.persist( emp );
		entityManager.persist( drummer );
		entityManager.persist( singer );
		entityManager.persist( emp_drummer );
		entityManager.persist( emp_singer );
		
		entityManager.persist( correpetition );
		entityManager.persist( ensemble );
		entityManager.persist( orchester_alone );
		entityManager.persist( chor );
		entityManager.persist( stage );
		entityManager.persist( scenes );
		entityManager.persist( piano );
		entityManager.persist( general );
		entityManager.persist( premiere );
		
		
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
