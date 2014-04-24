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
import at.roomplanning.entities.Room;

/**
 * http://stackoverflow.com/questions/5127129/mapping-many-to-many-association-table-with-extra-columns
 * 
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!!");
		/*Configuration configuration = new Configuration();
		configuration.configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
*/
		
		Calendar calendar = GregorianCalendar.getInstance();

		// Mitarbeiter anlegen
		Employee jonasKaufmann = new Employee();
		jonasKaufmann.setFirstName("Jonas");
		jonasKaufmann.setFamilyName("Kaufmann");
		calendar.set(1988, 10, 4);
		jonasKaufmann.setBirthDate(calendar.getTime());
		
		Employee NeilShicoff = new Employee();
		NeilShicoff.setFirstName("Neil");
		NeilShicoff.setFamilyName("Shicoff");
		calendar.set(1989, 05, 25);
		NeilShicoff.setBirthDate(calendar.getTime());
		
		Employee WolfgangBankl = new Employee();
		WolfgangBankl.setFirstName(Wolfgang);
		WolfgangBankl.setFamilyName(Bankl);
		calendar.set(1979, 10, 5);
		WolfgangBankl.setBirthDate(calendar.getTime());
		
		Employee EditaGruberova = new Employee();
		EditaGruberova.setFirstName(Edita);
		EditaGruberova.setFamilyName(Gruberova);
		calendar.set(1961,  10, 5);
		EditaGruberova.setBirthDate(calendar.getTime());
		
		Employee PlacidoDomingo = new Employee();
		PlacidoDomingo.setFirstName(Placido);
		PlacidoDomingo.setFamilyName(Domingo);
		calendar.set(1960,  10, 5);
		PlacidoDomingo.setBirthDate(calendar.getTime());
		
		Employee GuentherGroissboeck = new Employee();
		GuentherGroissboeck.setFirstName(Guenther);
		GuentherGroissboeck.setFamilyName(Groissboeck);
		calendar.set(1972, 10,5);
		GuentherGroissboeck.setBirthDate(calendar.getTime());
		
		Employee HerwigPecoraro = new Employee();
		HerwigPecoraro.setfirstName(Herwig);
		HerwigPecoraro.setFamilyName(Pecoraro);
		calendar.set(1960,  10,5);
		HerwigPecoraro.setBirthDate(calendar.getTime());
		
		Employee AnitaHartig = new Employee();
		AnitaHartig.setfirstName(Anita);
		AnitaHartig.setFamilyName(Hartig);
		calendar.set(1970,  10,5);
		AnitaHartig.setBirthDate(calendar.getTime());
		
		Employee StephanieHoutzeel = new Employee();
		StephanieHoutzeel.setFirstName(Stephanie);
		StephanieHoutzeel.setFamilyName(Houtzeel);
		calendar.set(1972,10,5);
		StephanieHoutzeel.setBirthDate(calendar.getTime());
		
		Employee AdamPlachetka = new Employee();
		AdamPlachetka.setFirstName(Adam);
		AdamPlachetka.setFamilyName(Plachetka);
		calendar.set(1969, 10,5);
		AdamPlachetka.setBirthDate(calendar.getTime());
		
		Employee ValentinaNafornita = new Employee();
		ValentinaNafornita.setFirstName(Valentina);
		ValentinaNafornita.setFamilyName(Nafornita);
		calendar.set(1987,  10,5);
		ValentinaNafornita.setBirthDate(calendar.getTime());
		
		
		
		
		
		
		
		
		
		
		
		
		// Rolle/Funktion erstellen
		Role tenor = new Role();
		tenor.setName("Tenor");
		
		Role Bariton = new Role();
		Bariton.setName("Bariton");
		
		Role Bass = new Role()
		Bass.setName("Bass");
		
		Role Sopran = new Role();
		Sopran.setName("Sopran");
		
		Role Alt = new Role();
		Alt.setName("Alt");
		
		
		
		
	
		
		// Zuweisung Rolle <-> Mitarbeiter
		EmployeeRole jonasKaufmann_tenor = new EmployeeRole();
		jonasKaufmann_tenor.setEmployee(jonasKaufmann);
		jonasKaufmann_tenor.setRole(tenor);
		jonasKaufmann_tenor.setEvaluation(1);
		EmployeeRole jonasKaufmann_Bariton= new EmployeeRole();
		jonasKaufmann_Bariton.setEmployee(jonasKaufmann);
		jonasKaufmann_Bariton.setRole(Bariton);
		jonasKaufmann_Bariton.setEvaluation(3);
		jonasKaufmann.getEmployeeroles().add(jonasKaufmann_Bariton);
		jonasKaufmann.getEmployeeroles().add(jonasKaufmann_tenor);
		tenor.getEmployeeRoles().add(jonasKaufmann_tenor);
		
		Bariton.getEmployeeRoles().add(jonasKaufmann_Bariton);
		
		EmployeeRole neilShicoff_Bariton = new EmployeeRole();
		neilShicoff_Bariton.setEmployee(NeilShicoff);
		neilShicoff_Bariton.setRole(Bariton);
		neilShicoff_Bariton.setEvaluation(1);
		NeilShicoff.getEmployeeroles().add(neilShicoff_Bariton);
		Bariton.getEmployeeRoles().add(neilShicoff_Bariton);
		
		EmployeeRole EditaGruberova = new EmployeeRole();
		EditaGruberova_Sopran.setEmployee(EditaGruberova);
		EditaGruberova_Sopran.setRole(Sopran);
		EditaGruberova.settEvaluation(1);
		EditaGruberova.getEmployeerole().add(EditaGruberova_Sopran);
		Sopran.getEmployeeRoles().add(EditaGruberova);
		

		// Aufführung erstellen
		Performance performance = new Performance();
		performance.setName("Salome");
		calendar.set(2014, 10, 4, 20, 0, 0);
		performance.setDate(calendar.getTime());
		
		// Aufführung dem Mitarbeiter zuweisen, und
		// umgekehrt
		jonasKaufmann.getPerformances().add(performance);
		performance.getEmployees().add(jonasKaufmann);
		
		//------------------------------------------------------------- Der Teil ist FERTIG
		PerformanceType perfType = new PerformanceType();
		perfType.setType(PerformanceType.Type.CORREPETITION2PREMIERE);
		perfType.getPerformances().add(performance);
		performance.setPerformanceType(perfType);
		

		// Rehearsal types for Correpetition2premiere
		RehearsalType correpetition = new RehearsalType();
		correpetition.setName("Korrepetitionsprobe");
		correpetition.setNumber(10);
		correpetition.setPrevious(null);
		
		RehearsalType ensemble = new RehearsalType();
		ensemble.setName("Ensembleprobe");
		ensemble.setNumber(1);
		ensemble.getPrevious().add(correpetition);
		correpetition.setNext(ensemble);
		
		RehearsalType scenes = new RehearsalType();
		scenes.setName("Szenische Proben");
		scenes.setNumber(20);
		scenes.getPrevious().add(ensemble);
		ensemble.setNext(scenes);
		
		RehearsalType chor = new RehearsalType();
		chor.setName("Chor allein Probe");
		chor.setNumber(4);
		chor.setPrevious(null);
		
		RehearsalType orchester_alone = new RehearsalType();
		orchester_alone.setName("Orchester allein Probe");
		orchester_alone.setNumber(4);
		orchester_alone.setPrevious(null);
		
		
		RehearsalType stage = new RehearsalType();
		stage.setName("Bühnenprobe");
		stage.setNumber(8);
		stage.getPrevious().add(scenes);
		stage.getPrevious().add(chor);
		stage.getPrevious().add(orchester_alone);
		chor.setNext(stage);
		orchester_alone.setNext(stage);
		scenes.setNext(stage);
		
		RehearsalType piano = new RehearsalType();
		piano.setName("Klavierprobe");
		piano.setNumber(4);
		piano.getPrevious().add(stage);
		stage.setNext(piano);
		
		RehearsalType orchesterMain = new RehearsalType();
		orchesterMain.setName("Orchesterhauptprobe");
		orchesterMain.setNumber(2);
		orchesterMain.getPrevious().add(piano);
		piano.setNext(orchesterMain);
		
		RehearsalType general = new RehearsalType();
		general.setName("Generalprobe");
		general.setNumber(1);
		general.getPrevious().add(orchesterMain);
		orchesterMain.setNext(general);
		
		RehearsalType premiere = new RehearsalType();
		premiere.setName("Premiere");
		premiere.setNumber(1);
		premiere.getPrevious().add(general);
		premiere.setNext(null);
		general.setNext(premiere);
		
		//------------------------------------------------------------- Der Teil ist FERTIG ENDE
		
				
		// Räume erstellen
		Room room1 = new Room();
		room1.setName("Korrepetitionsraum");
		room1.setLocation("1010 Wien..");
		room1.getRehearsalTypes().add(correpetition);

		
		Room room2 = new Room();
		room2.setName("Eduard Wächter Probebühne");
		room2.setLocation("1010 Wien");
		room2.getRehearsalTypes().add(scenes);
		
		Room room3 = new Room();
		//...
		
		
		// Proben erstellen
		Rehearsal rehearsal1 = new Rehearsal();
		calendar.set(2014, 05, 4); // datum erzeugen
		rehearsal1.setDuration(120); // dauer in minuten
		rehearsal1.setDate(calendar.getTime()); // datum setzen
		rehearsal1.setPerformance(performance); // aufführungen setzen
		rehearsal1.setRoom(room1); // raum zuweisen für die probe
		rehearsal1.setRehearsalType(correpetition); // typ zuweisen
		performance.getRehearsals().add(rehearsal1);  // setze probe zur aufweisung
		rehearsal1.setPerformance(performance); // setze aufführung für die probe
		
		Rehearsal rehearsal2 = new Rehearsal();
		calendar.set(2014, 05, 9);
		rehearsal2.setDate(calendar.getTime());
		rehearsal2.setPerformance(performance);
		rehearsal2.setRoom(room2);
		rehearsal2.setRehearsalType(ensemble);
		performance.getRehearsals().add(rehearsal2);	
		rehearsal2.setPerformance(performance);
		
		// proben den räumen zuordnen
		room1.getRehearsals().add(rehearsal1);
		room2.getRehearsals().add(rehearsal2);
		
		// probetypen die proben hinzufügen
		ensemble.getRehearsals().add(rehearsal2);
		correpetition.getRehearsals().add(rehearsal1);

		
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory( "at.roomplanning" );
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		
		
		entityManager.getTransaction().begin();
		entityManager.persist( jonasKaufmann );
		entityManager.persist(NeilShicoff);
		entityManager.persist(WolfgangBankl);
		entityManager.persist(EditaGruberova);
		entityManager.persist(PlacidoDomingo);
		entityManager.persist(GuentherGroissboeck);
		entityManager.persist(HerwigPecoraro);
		entityManager.persist(AnitaHartig);
		entityManager.persist(StephanieHoutzeel);
		entityManager.persist(AdamPlachetka);
		entityManager.persist(ValentinaNafornita);
		
		
		
		
		entityManager.persist( tenor );
		entityManager.persist(Bariton);
		
		entityManager.persist( jonasKaufmann_tenor );
		entityManager.persist(jonasKaufmann_Bariton);
		entityManager.persist( neilShicoff_Bariton );
		
		entityManager.persist( correpetition );
		entityManager.persist( ensemble );
		entityManager.persist( orchester_alone );
		entityManager.persist( chor );
		entityManager.persist( stage );
		entityManager.persist( scenes );
		entityManager.persist( piano );
		entityManager.persist( general );
		entityManager.persist( premiere );
		entityManager.persist(performance);
		entityManager.persist(room1);
		entityManager.persist(room2);
		entityManager.persist(rehearsal1);
		entityManager.persist(rehearsal2);
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
		
		
		query = entityManager.createQuery("Select t FROM RehearsalType t WHERE t.name = 'Korrepetitionsprobe'");
		@SuppressWarnings("unchecked")
		ArrayList<RehearsalType> res = (ArrayList<RehearsalType>) query.getResultList();
		RehearsalType start = (res.size() > 0) ? res.get(0) : null;
		if ( start != null) {
			while (start.getNext() != null) {
				String name = start.getName();
				System.out.println(name);
				if (start.getPrevious() != null && start.getPrevious().size() > 1) {
					for (RehearsalType tmp : start.getPrevious()) {
						if (tmp.getName().equals(name)) {
							continue;
						}
						System.out.println(tmp.getName());
					}
				}
				start = start.getNext();
			}
		}
		
		entityManager.close();
		
		//entityManagerFactory.close();
		
		/*
		Session s = sessionFactory.openSession();
		s.beginTransaction();
		s.save(emp);
		s.getTransaction().commit();
		s.close();*/
	}
}
