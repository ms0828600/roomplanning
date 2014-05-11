package at.roomplanning.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity (name = "Performance_RehearsalType")
public class Performance_RehearsalType {
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Performance getPerformance() {
		return performance;
	}

	public void setPerformance(Performance performance) {
		this.performance = performance;
	}

	public RehearsalType getRehearsalType() {
		return rehearsalType;
	}

	public void setRehearsalType(RehearsalType rehearsalType) {
		this.rehearsalType = rehearsalType;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Performance performance;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private RehearsalType rehearsalType;
	
	private int count = 0;

}
