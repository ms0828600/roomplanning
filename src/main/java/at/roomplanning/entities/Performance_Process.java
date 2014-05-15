package at.roomplanning.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

/**
 * This class is the relation between a performance and the process-chain.
 * It stores how many iterations a performance needs of each type of the
 * process chain.
 *
 */
@Data
@Entity (name = "Performance_Process")
public class Performance_Process {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Performance performance;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Process processEntry;
	
	private int count = 0;

}
