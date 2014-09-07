package roomplanning.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

/**
 * This class stores the name of the opera or ballett
 * @author martin
 *
 */
@Data
@Entity (name = "Play")
public class Play {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column (nullable = false)
	private String name;	
	
	// aufbauzeit für das stück
	private int maintanence_hours;

	@ManyToOne
	private PlayType playType;
	
	@OneToMany (mappedBy = "play")
	private Set<Performance> performances;
	
}
