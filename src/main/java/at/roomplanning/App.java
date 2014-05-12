package at.roomplanning;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import at.roomplanning.entities.Employee;
import at.roomplanning.entities.Employee_Role;
import at.roomplanning.entities.Performance;
import at.roomplanning.entities.Performance_RehearsalType;
import at.roomplanning.entities.Rehearsal;
import at.roomplanning.entities.RehearsalType;
import at.roomplanning.entities.Role;
import at.roomplanning.entities.Room;

/**
 * http://stackoverflow.com/questions/5127129/mapping-many-to-many-association-
 * table-with-extra-columns
 * 
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!!");
		/*
		 * Configuration configuration = new Configuration();
		 * configuration.configure(); ServiceRegistry serviceRegistry = new
		 * ServiceRegistryBuilder
		 * ().applySettings(configuration.getProperties()).
		 * buildServiceRegistry(); SessionFactory sessionFactory =
		 * configuration.buildSessionFactory(serviceRegistry);
		 */
		
		
		// ------------------------------------------------------------- Der
		// Teil ist FERTIG

		// Rehearsal types for Correpetition2premiere
		RehearsalType correpetition = new RehearsalType();
		correpetition.setType(RehearsalType.Type.KORREPETITIONSPROBE);
		correpetition.setDuration(20);
		correpetition.setPrevious(null);

		RehearsalType ensemble = new RehearsalType();
		ensemble.setType(RehearsalType.Type.ENSEMBLEPROBE);
		ensemble.getPrevious().add(correpetition);
		correpetition.setNext(ensemble);

		RehearsalType scenes = new RehearsalType();
		scenes.setType(RehearsalType.Type.SZENISCHEPROBE);
		scenes.getPrevious().add(ensemble);
		ensemble.setNext(scenes);

		RehearsalType chor = new RehearsalType();
		chor.setType(RehearsalType.Type.CHORALLEINPROBE);
		chor.setPrevious(null);

		RehearsalType orchester_alone = new RehearsalType();
		orchester_alone.setType(RehearsalType.Type.ORCHESTERALLEINPROBE);
		orchester_alone.setPrevious(null);

		RehearsalType stage = new RehearsalType();
		stage.setType(RehearsalType.Type.BUEHNENPROBE);
		stage.getPrevious().add(scenes);
		stage.getPrevious().add(chor);
		stage.getPrevious().add(orchester_alone);
		chor.setNext(stage);
		orchester_alone.setNext(stage);
		scenes.setNext(stage);

		RehearsalType piano = new RehearsalType();
		piano.setType(RehearsalType.Type.KLAVIERPROBE);
		piano.getPrevious().add(stage);
		stage.setNext(piano);

		RehearsalType orchesterMain = new RehearsalType();
		orchesterMain.setType(RehearsalType.Type.ORCHESTERHAUPTPROBE);
		orchesterMain.getPrevious().add(piano);
		piano.setNext(orchesterMain);

		RehearsalType general = new RehearsalType();
		general.setType(RehearsalType.Type.GENERALPROBE);
		general.getPrevious().add(orchesterMain);
		orchesterMain.setNext(general);

		RehearsalType premiere = new RehearsalType();
		premiere.setType(RehearsalType.Type.PREMIERE);
		premiere.getPrevious().add(general);
		premiere.setNext(null);
		general.setNext(premiere);

		// ------------------------------------------------------------- Der
		// Teil ist FERTIG ENDE
		
		
		
		
		

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
		WolfgangBankl.setFirstName("Wolfgang");
		WolfgangBankl.setFamilyName("Bankl");
		calendar.set(1979, 10, 5);
		WolfgangBankl.setBirthDate(calendar.getTime());

		Employee EditaGruberova = new Employee();
		EditaGruberova.setFirstName("Edita");
		EditaGruberova.setFamilyName("Gruberova");
		calendar.set(1961, 10, 5);
		EditaGruberova.setBirthDate(calendar.getTime());

		Employee PlacidoDomingo = new Employee();
		PlacidoDomingo.setFirstName("Placido");
		PlacidoDomingo.setFamilyName("Domingo");
		calendar.set(1960, 10, 5);
		PlacidoDomingo.setBirthDate(calendar.getTime());

		Employee GuentherGroissboeck = new Employee();
		GuentherGroissboeck.setFirstName("Guenther");
		GuentherGroissboeck.setFamilyName("Groissboeck");
		calendar.set(1972, 10, 5);
		GuentherGroissboeck.setBirthDate(calendar.getTime());

		Employee HerwigPecoraro = new Employee();
		HerwigPecoraro.setFirstName("Herwig");
		HerwigPecoraro.setFamilyName("Pecoraro");
		calendar.set(1960, 10, 5);
		HerwigPecoraro.setBirthDate(calendar.getTime());

		Employee AnitaHartig = new Employee();
		AnitaHartig.setFirstName("Anita");
		AnitaHartig.setFamilyName("Hartig");
		calendar.set(1970, 10, 5);
		AnitaHartig.setBirthDate(calendar.getTime());

		Employee StephanieHoutzeel = new Employee();
		StephanieHoutzeel.setFirstName("Stephanie");
		StephanieHoutzeel.setFamilyName("Houtzeel");
		calendar.set(1972, 10, 5);
		StephanieHoutzeel.setBirthDate(calendar.getTime());

		Employee AdamPlachetka = new Employee();
		AdamPlachetka.setFirstName("Adam");
		AdamPlachetka.setFamilyName("Plachetka");
		calendar.set(1969, 10, 5);
		AdamPlachetka.setBirthDate(calendar.getTime());

		Employee ValentinaNafornita = new Employee();
		ValentinaNafornita.setFirstName("Valentina");
		ValentinaNafornita.setFamilyName("Nafornita");
		calendar.set(1987, 10, 5);
		ValentinaNafornita.setBirthDate(calendar.getTime());

		// Rolle/Funktion erstellen

		// Role/Saenger
		Role tenor = new Role();
		tenor.setName("Tenor");

		Role Bariton = new Role();
		Bariton.setName("Bariton");

		Role Bass = new Role();
		Bass.setName("Bass");

		Role Sopran = new Role();
		Sopran.setName("Sopran");

		Role Alt = new Role();
		Alt.setName("Alt");

		// Zuweisung Rolle <-> Mitarbeiter
		Employee_Role jonasKaufmann_tenor = new Employee_Role();
		jonasKaufmann_tenor.setEmployee(jonasKaufmann);
		jonasKaufmann_tenor.setRole(tenor);
		jonasKaufmann_tenor.setEvaluation(1);
		Employee_Role jonasKaufmann_Bariton = new Employee_Role();
		jonasKaufmann_Bariton.setEmployee(jonasKaufmann);
		jonasKaufmann_Bariton.setRole(Bariton);
		jonasKaufmann_Bariton.setEvaluation(3);
		jonasKaufmann.getEmployeeroles().add(jonasKaufmann_Bariton);
		jonasKaufmann.getEmployeeroles().add(jonasKaufmann_tenor);
		tenor.getEmployeeRoles().add(jonasKaufmann_tenor);

		Bariton.getEmployeeRoles().add(jonasKaufmann_Bariton);

		Employee_Role neilShicoff_Bariton = new Employee_Role();
		neilShicoff_Bariton.setEmployee(NeilShicoff);
		neilShicoff_Bariton.setRole(Bariton);
		neilShicoff_Bariton.setEvaluation(1);
		NeilShicoff.getEmployeeroles().add(neilShicoff_Bariton);
		Bariton.getEmployeeRoles().add(neilShicoff_Bariton);

		Employee_Role EditaGruberova_Sopran = new Employee_Role();
		EditaGruberova_Sopran.setEmployee(EditaGruberova);
		EditaGruberova_Sopran.setRole(Sopran);
		EditaGruberova_Sopran.setEvaluation(1);
		EditaGruberova.getEmployeeroles().add(EditaGruberova_Sopran);
		Sopran.getEmployeeRoles().add(EditaGruberova_Sopran);

		Employee_Role PlacidoDomingo_Tenor = new Employee_Role();
		PlacidoDomingo_Tenor.setEmployee(PlacidoDomingo);
		PlacidoDomingo_Tenor.setRole(tenor);
		PlacidoDomingo_Tenor.setEvaluation(1);
		PlacidoDomingo.getEmployeeroles().add(PlacidoDomingo_Tenor);
		tenor.getEmployeeRoles().add(PlacidoDomingo_Tenor);

		Employee_Role GuentherGroissboeck_Bass = new Employee_Role();
		GuentherGroissboeck_Bass.setEmployee(GuentherGroissboeck);
		GuentherGroissboeck_Bass.setRole(Bass);
		GuentherGroissboeck_Bass.setEvaluation(2);
		GuentherGroissboeck.getEmployeeroles().add(GuentherGroissboeck_Bass);
		Bass.getEmployeeRoles().add(GuentherGroissboeck_Bass);

		Employee_Role HerwigPecoraro_Tenor = new Employee_Role();
		HerwigPecoraro_Tenor.setEmployee(HerwigPecoraro);
		HerwigPecoraro_Tenor.setRole(tenor);
		HerwigPecoraro_Tenor.setEvaluation(2);
		HerwigPecoraro.getEmployeeroles().add(HerwigPecoraro_Tenor);
		tenor.getEmployeeRoles().add(HerwigPecoraro_Tenor);

		Employee_Role AnitaHartig_Alt = new Employee_Role();
		AnitaHartig_Alt.setEmployee(AnitaHartig);
		AnitaHartig_Alt.setRole(Alt);
		AnitaHartig_Alt.setEvaluation(2);
		AnitaHartig.getEmployeeroles().add(AnitaHartig_Alt);
		Alt.getEmployeeRoles().add(AnitaHartig_Alt);

		/*
		 * EmployeeRole AnitaHartig_Alt = new EmployeeRole();
		 * AnitaHartig_Alt.setEmployee(AnitaHartig);
		 * AnitaHartig_Alt.setRole(Alt); AnitaHartig_Alt.setEvaluation(2);
		 * AnitaHartig.getEmployeeroles().add(AnitaHartig_Alt);
		 * Alt.getEmployeeRoles().add(AnitaHartig_Alt);
		 */

		Employee_Role StephanieHoutzeel_Sopran = new Employee_Role();
		StephanieHoutzeel_Sopran.setEmployee(AnitaHartig);
		StephanieHoutzeel_Sopran.setRole(Sopran);
		StephanieHoutzeel_Sopran.setEvaluation(1);
		StephanieHoutzeel.getEmployeeroles().add(StephanieHoutzeel_Sopran);
		Sopran.getEmployeeRoles().add(StephanieHoutzeel_Sopran);

		Employee_Role AdamPlachetka_Bass = new Employee_Role();
		AdamPlachetka_Bass.setEmployee(AdamPlachetka);
		AdamPlachetka_Bass.setRole(Bass);
		AdamPlachetka_Bass.setEvaluation(2);
		AdamPlachetka.getEmployeeroles().add(AdamPlachetka_Bass);
		Bass.getEmployeeRoles().add(AdamPlachetka_Bass);

		Employee_Role ValentinaNafornita_Sopran = new Employee_Role();
		ValentinaNafornita_Sopran.setEmployee(ValentinaNafornita);
		ValentinaNafornita_Sopran.setRole(Bass);
		ValentinaNafornita_Sopran.setEvaluation(1);
		ValentinaNafornita.getEmployeeroles().add(ValentinaNafornita_Sopran);
		Sopran.getEmployeeRoles().add(ValentinaNafornita_Sopran);

		
		// Musiker erstellen
		
		Employee_Role JosefReif_Horn1 = new Employee_Role();
		JosefReif_Horn1.setEmployee(JosefReif);
		JosefReif_Horn1.setRole(Horn1);
		JosefReif_Horn1.setEvaluation(1);
		JosefReif_Horn1.getEmployeeroles().add(JosefReif_Horn1);
		Horn1.getEmployeeRoles().add(JosefReif_Horn1);
		
		
		
		
		
		// Aufführung erstellen
		Performance performance_salome = new Performance();
		performance_salome.setName("Salome");
		calendar.set(2014, 10, 8, 20, 0, 0);
		performance_salome.setDate(calendar.getTime());
		performance_salome
				.setPerformanceType(at.roomplanning.entities.Performance.Type.NEUINSZENIERUNG);
		
		Performance_RehearsalType salome_correpetition = new Performance_RehearsalType();
		salome_correpetition.setCount(10);
		salome_correpetition.setPerformance(performance_salome);
		salome_correpetition.setRehearsalType(correpetition);
		
		

		// Aufführung dem Mitarbeiter zuweisen, und
		// umgekehrt
		jonasKaufmann.getPerformances().add(performance_salome);
		performance_salome.getEmployees().add(jonasKaufmann);



		// Räume erstellen
		Room room1 = new Room();
		room1.setName("Korrepetitionsraum");
		room1.setLocation("1010 Wien..");
		room1.getRehearsalTypes().add(correpetition);

		Room room2 = new Room();
		room2.setName("Eduard Wächter Probebühne");
		room2.setLocation("1010 Wien");
		room2.getRehearsalTypes().add(scenes);

		// Proben erstellen
		Rehearsal rehearsal1 = new Rehearsal();
		calendar.set(2014, 05, 4); // datum erzeugen
		rehearsal1.setDuration(120); // dauer in minuten
		rehearsal1.setDate(calendar.getTime()); // datum setzen
		rehearsal1.setPerformance(performance_salome); // aufführungen setzen
		rehearsal1.setRoom(room1); // raum zuweisen für die probe
		rehearsal1.setRehearsalType(correpetition); // typ zuweisen
		performance_salome.getRehearsals().add(rehearsal1); // setze probe zur
															// aufweisung
		rehearsal1.setPerformance(performance_salome); // setze aufführung für
														// die probe

		Rehearsal rehearsal2 = new Rehearsal();
		calendar.set(2014, 05, 9);
		rehearsal2.setDate(calendar.getTime());
		rehearsal2.setPerformance(performance_salome);
		rehearsal2.setRoom(room2);
		rehearsal2.setRehearsalType(ensemble);
		performance_salome.getRehearsals().add(rehearsal2);
		rehearsal2.setPerformance(performance_salome);

		// proben den räumen zuordnen
		room1.getRehearsals().add(rehearsal1);
		room2.getRehearsals().add(rehearsal2);

		// probetypen die proben hinzufügen
		ensemble.getRehearsals().add(rehearsal2);
		correpetition.getRehearsals().add(rehearsal1);
		
	

		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory("at.roomplanning");
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();
		


		entityManager.getTransaction().begin();
		entityManager.persist(jonasKaufmann);
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
		entityManager.persist(JosefReif);

		entityManager.persist(tenor);
		entityManager.persist(Bariton);
		entityManager.persist(Bass);
		entityManager.persist(Sopran);
		entityManager.persist(Alt);
		entityManager.persist(Horn1);

		entityManager.persist(jonasKaufmann_tenor);
		entityManager.persist(jonasKaufmann_Bariton);
		entityManager.persist(neilShicoff_Bariton);
		entityManager.persist(EditaGruberova_Sopran);
		entityManager.persist(PlacidoDomingo_Tenor);
		entityManager.persist(GuentherGroissboeck_Bass);
		entityManager.persist(GuentherGroissboeck_Bass);
		entityManager.persist(HerwigPecoraro_Tenor);
		entityManager.persist(AnitaHartig_Alt);
		entityManager.persist(StephanieHoutzeel_Sopran);
		entityManager.persist(AdamPlachetka_Bass);
		entityManager.persist(ValentinaNafornita_Sopran);
		entityManager.persist(JosefReif_Horn1);


		
		entityManager.persist(correpetition);
		entityManager.persist(ensemble);
		entityManager.persist(orchester_alone);
		entityManager.persist(chor);
		entityManager.persist(stage);
		entityManager.persist(scenes);
		entityManager.persist(piano);
		entityManager.persist(general);
		entityManager.persist(premiere);
		entityManager.persist(room1);
		entityManager.persist(room2);
		entityManager.persist(rehearsal1);
		entityManager.persist(rehearsal2);
		
		
		entityManager.persist(salome_correpetition);
		entityManager.persist(performance_salome);
		
		entityManager.getTransaction().commit();
		
		
		/**
		 * Select all Employees with their Roles/Functions
		 */

		Query query = entityManager.createQuery("SELECT e FROM Employee e");
		@SuppressWarnings("unchecked")
		ArrayList<Employee> result = (ArrayList<Employee>) query
				.getResultList();
		for (Employee e : result) {
			System.out.println("Name = " + e.getFirstName() + " "
					+ e.getFamilyName() + ":" + e.getEmployeeroles().size());
			for (Employee_Role er : e.getEmployeeroles()) {
				System.out.println("Role: " + er.getRole().getName());
			}
		}
		
		
		/**
		 * TODO: Select process for performance "salome"
		 * TODO: Kill table performancetype??? if fixed for program we 
		 * will not need this table
		 */
		

		query = entityManager
				.createQuery("Select t FROM RehearsalType t WHERE t.type = :processStart");
		query.setParameter("processStart",
				RehearsalType.Type.KORREPETITIONSPROBE);
		@SuppressWarnings("unchecked")
		ArrayList<RehearsalType> res = (ArrayList<RehearsalType>) query
				.getResultList();
		RehearsalType start = (res.size() > 0) ? res.get(0) : null;
		if (start != null) {
			while (start.getNext() != null) {
				String name = start.getType().name();
				System.out.println(name);
				if (start.getPrevious() != null
						&& start.getPrevious().size() > 1) {
					for (RehearsalType tmp : start.getPrevious()) {
						if (tmp.getType().name().equals(name)) {
							continue;
						}
						System.out.println(tmp.getType().name());
					}
				}
				start = start.getNext();
			}
		}

		entityManager.close();

		try {
			System.out.println("Type something to finish application.");
			BufferedReader bufferRead = new BufferedReader(
					new InputStreamReader(System.in));
			String s = bufferRead.readLine();

			System.out.println("Closing...");
			entityManagerFactory.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// entityManagerFactory.close();

		/*
		 * Session s = sessionFactory.openSession(); s.beginTransaction();
		 * s.save(emp); s.getTransaction().commit(); s.close();
		 */
	}
}
