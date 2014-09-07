package roomplanning.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

/**
 * This class stores the play-type (e.g. ballet, opera, musical,...)
 *
 */
@Data
@Entity (name = "PlayType")
public class PlayType {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column (nullable = false)
	private String name;	
	
	@OneToMany (mappedBy = "playType")
	private Set<Play> playList;
	
}
