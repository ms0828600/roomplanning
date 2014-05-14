package at.roomplanning.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity (name = "Performance_Process")
public class Performance_Process {
	
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

	public Process getProcessEntry() {
		return processEntry;
	}

	public void setProcessEntry(Process processEntry) {
		this.processEntry = processEntry;
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
	private Process processEntry;
	
	private int count = 0;

}
