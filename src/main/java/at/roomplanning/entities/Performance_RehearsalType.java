package at.roomplanning.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity (name = "Performance_RehearsalType")
public class Performance_RehearsalType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Performance performance;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private RehearsalType rehearsalType;
	
	private int count = 0;

}
