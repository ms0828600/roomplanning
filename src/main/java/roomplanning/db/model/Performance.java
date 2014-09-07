package roomplanning.db.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * This class stores all information about a performance.
 * Each performance relates to a play (e.g. an opera or ballet).
 * Additionally each performance has a type like a standard performance,
 * repertoire,...
 *
 */


@Data
@EqualsAndHashCode(exclude={"processEntries"})
@Entity(name = "Performance")
public class Performance {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;
	
	@ManyToOne
	private Play play;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Employee> employees;
	
	@ManyToOne
	private Room room;

	@OneToOne
	private PerformanceType performanceType;
	
	@OneToMany (cascade = CascadeType.ALL, mappedBy = "processEntry")
	private Set<Performance_Process> processEntries;		
	

	@OneToMany (cascade = CascadeType.ALL, mappedBy = "performance")
	private Set<Rehearsal> rehearsals;
	
	@OneToMany (cascade = CascadeType.ALL, mappedBy = "processEntry")
	private Set<Performance_Process> rehearsalTypes;	
	
	public Performance() {
		this.employees = new HashSet<Employee>();
		this.setRehearsals(new HashSet<Rehearsal>());
		this.processEntries = new HashSet<Performance_Process>();
	}

}
