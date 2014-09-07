package roomplanning.db.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;

/**
 * This class stores the type of performances like 
 * repertoire, standard etc.
 * The @processStart attribute stores, where the process-chain
 * for this performance-type starts
 */
@Data
@Entity(name ="PerformanceType")
public class PerformanceType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String name;

	@OneToOne
	private Process processStart;
	
	@OneToMany (mappedBy = "performanceType")
	private Set<Performance> performances;

}
