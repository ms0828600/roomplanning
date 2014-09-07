package roomplanning.testdata;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;

import roomplanning.db.entities.Employee;
import roomplanning.db.entities.Function;
import roomplanning.db.entities.PerformanceType;
import roomplanning.db.entities.Process;

public class TestData {
	
	private EntityManager entityManager;

	public TestData(EntityManager em) {
		this.entityManager = em;
	}

	public void insertRoles() {
		
		entityManager.getTransaction().begin();
		
		// Role/Saenger
		Function tenor = new Function();
		tenor.setName("Tenor");

		Function Bariton = new Function();
		Bariton.setName("Bariton");

		Function Bass = new Function();
		Bass.setName("Bass");

		Function Sopran = new Function();
		Sopran.setName("Sopran");

		Function Alt = new Function();
		Alt.setName("Alt");

		// Rolle/Funktion Orchestermusiker

		Function Horn1 = new Function();
		Alt.setName("Horn1");

		Function Horn2 = new Function();
		Alt.setName("Horn2");
		
		
		entityManager.persist(tenor);
		entityManager.persist(Bariton);
		entityManager.persist(Bass);
		entityManager.persist(Sopran);
		entityManager.persist(Alt);
		entityManager.persist(Horn1);
		entityManager.persist(Horn2);
		
		entityManager.getTransaction().commit();

	}

	public void insertEmployees() {

		entityManager.getTransaction().begin();		
		
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

		// Mitarbeiter Orchestermusiker

		Employee JosefReif = new Employee();
		JosefReif.setFirstName("Josef");
		JosefReif.setFamilyName("Reif");
		calendar.set(1987, 10, 5);
		JosefReif.setBirthDate(calendar.getTime());

		Employee ManuelHuber = new Employee();
		ManuelHuber.setFirstName("Manuel");
		ManuelHuber.setFamilyName("Huber");
		calendar.set(1987, 10, 5);
		ManuelHuber.setBirthDate(calendar.getTime());

		Employee RonaldJanezic = new Employee();
		RonaldJanezic.setFirstName("Ronald");
		JosefReif.setFamilyName("Janezic");
		calendar.set(1987, 10, 5);
		RonaldJanezic.setBirthDate(calendar.getTime());

		Employee WolfgangLintner = new Employee();
		WolfgangLintner.setFirstName("Wolfgang");
		WolfgangLintner.setFamilyName("Lintner");
		calendar.set(1987, 10, 5);
		WolfgangLintner.setBirthDate(calendar.getTime());

		Employee JanJankovic = new Employee();
		JanJankovic.setFirstName("Jan");
		JanJankovic.setFamilyName("Jankovic");
		calendar.set(1987, 10, 5);
		JanJankovic.setBirthDate(calendar.getTime());
		

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
		entityManager.persist(RonaldJanezic);
		entityManager.persist(ManuelHuber);
		entityManager.persist(WolfgangLintner);
		entityManager.persist(JanJankovic);
		entityManager.getTransaction().commit();
	}
	
	public void insertProcessAndPerformanceTypes() {
		
		entityManager.getTransaction().begin();	
		
		
		// Rehearsal types for Correpetition2premiere
		Process correpetition = new Process();
		correpetition.setName("KORREPETITIONSPROBE");
		correpetition.setDuration(20);
		correpetition.setPrevious(null);

		Process ensemble = new Process();
		ensemble.setName("ENSEMBLEPROBE");
		ensemble.getPrevious().add(correpetition);
		correpetition.setNext(ensemble);

		Process scenes = new Process();
		scenes.setName("SZENISCHEPROBE");
		scenes.getPrevious().add(ensemble);
		ensemble.setNext(scenes);

		Process chor = new Process();
		chor.setName("CHORALLEINPROBE");
		chor.setPrevious(null);

		Process orchester_alone = new Process();
		orchester_alone.setName("ORCHESTERALLEINPROBE");
		orchester_alone.setPrevious(null);

		Process stage = new Process();
		stage.setName("BUEHNENPROBE");
		stage.getPrevious().add(scenes);
		stage.getPrevious().add(chor);
		stage.getPrevious().add(orchester_alone);
		chor.setNext(stage);
		orchester_alone.setNext(stage);
		scenes.setNext(stage);

		Process piano = new Process();
		piano.setName("KLAVIERPROBE");
		piano.getPrevious().add(stage);
		stage.setNext(piano);

		Process orchesterMain = new Process();
		orchesterMain.setName("ORCHESTERHAUPTPROBE");
		orchesterMain.getPrevious().add(piano);
		piano.setNext(orchesterMain);

		Process general = new Process();
		general.setName("GENERALPROBE");
		general.getPrevious().add(orchesterMain);
		orchesterMain.setNext(general);

		Process premiere = new Process();
		premiere.setName("PREMIERE");
		premiere.getPrevious().add(general);
		premiere.setNext(null);
		general.setNext(premiere);
		
		PerformanceType neuinszenierung = new PerformanceType();
		neuinszenierung.setName("NEUINSZENIERUNG");
		neuinszenierung.setProcessStart(correpetition);
		
		PerformanceType wiederaufnahme = new PerformanceType();
		wiederaufnahme.setName("WIEDERAUFNAHME");
		wiederaufnahme.setProcessStart(scenes);
		
		PerformanceType repertoire = new PerformanceType();
		repertoire.setName("REPERTOIRE");
		repertoire.setProcessStart(stage);
		
		PerformanceType standard = new PerformanceType();
		standard.setName("STANDARD");
		standard.setProcessStart(null);
	
		entityManager.persist(correpetition);
		entityManager.persist(ensemble);
		entityManager.persist(orchester_alone);
		entityManager.persist(chor);
		entityManager.persist(stage);
		entityManager.persist(scenes);
		entityManager.persist(piano);
		entityManager.persist(general);
		entityManager.persist(premiere);
		
		entityManager.persist(neuinszenierung);
		entityManager.persist(wiederaufnahme);
		entityManager.persist(repertoire);
		entityManager.persist(standard);
		
		entityManager.getTransaction().commit();
		System.out.println("Insert process ready.");
		
	}
	
	

	/*
	
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

	
	  EmployeeRole AnitaHartig_Alt = new EmployeeRole();
	  AnitaHartig_Alt.setEmployee(AnitaHartig);
	  AnitaHartig_Alt.setRole(Alt); AnitaHartig_Alt.setEvaluation(2);
	 AnitaHartig.getEmployeeroles().add(AnitaHartig_Alt);
	 Alt.getEmployeeRoles().add(AnitaHartig_Alt);
	 

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

	
	// Musiker Simmen zuweisen
	
	Employee_Role JosefReif_Horn1 = new Employee_Role();
	JosefReif_Horn1.setEmployee(JosefReif);
	JosefReif_Horn1.setRole(Horn1);
	JosefReif_Horn1.setEvaluation(1);
	Horn1.getEmployeeRoles().add(JosefReif_Horn1);
	JosefReif.getEmployeeroles().add(JosefReif_Horn1);
	
	Employee_Role RonaldJanezic_Horn1 = new Employee_Role();
	RonaldJanezic_Horn1.setEmployee(RonaldJanezic);
	RonaldJanezic_Horn1.setRole(Horn1);
	RonaldJanezic_Horn1.setEvaluation(1);
	RonaldJanezic.getEmployeeroles().add(RonaldJanezic_Horn1);
	Horn1.getEmployeeRoles().add(RonaldJanezic_Horn1);	
	
	Employee_Role ManuelHuber_Horn1 = new Employee_Role();
	ManuelHuber_Horn1 .setEmployee(JanJankovic);
	ManuelHuber_Horn1 .setRole(Horn1);
	ManuelHuber_Horn1 .setEvaluation(1);
	ManuelHuber.getEmployeeroles().add(ManuelHuber_Horn1);
	Horn1.getEmployeeRoles().add(ManuelHuber_Horn1 );	
	
	Employee_Role WolfgangLintner_Horn2 = new Employee_Role();
	WolfgangLintner_Horn2 .setEmployee(JanJankovic);
	WolfgangLintner_Horn2 .setRole(Horn1);
	WolfgangLintner_Horn2 .setEvaluation(1);
	WolfgangLintner.getEmployeeroles().add(WolfgangLintner_Horn2);
	Horn2.getEmployeeRoles().add(WolfgangLintner_Horn2 );
	
	Employee_Role JanJankovic_Horn2 = new Employee_Role();
	JanJankovic_Horn2 .setEmployee(JanJankovic);
	JanJankovic_Horn2 .setRole(Horn1);
	JanJankovic_Horn2 .setEvaluation(1);
	JanJankovic.getEmployeeroles().add(JanJankovic_Horn2);
	Horn2.getEmployeeRoles().add(JanJankovic_Horn2 );
	
	
	
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
	*/
	

}
