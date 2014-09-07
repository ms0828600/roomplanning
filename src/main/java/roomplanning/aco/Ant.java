package roomplanning.aco;

import java.util.ArrayList;

import lombok.Data;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import roomplanning.aco.data.Selection;
import roomplanning.db.model.Employee;

@Service
@Data
public class Ant {
	/**
	 * Stores the capabilities of the ant:
	 * 
	 * For instance:
	 * 1 = violinist
	 * 2 = tenor
	 * 
	 * so the value ends up being 1 | 2 = 3
	 * 
	 * This gets used for the food source selection.
	 * After specializing for a specific task the other bits gets
	 * dropped. So if the ant specializes to be a tenor it ends up
	 * with the value of 2.
	 * 
	 */
	private Long functionCaps;
	
	private int generation;
	private Employee employee;

	/**
	 * Stores the path this ant has chosen
	 */
	private ArrayList<Selection> path;
	
	@Bean(name="Ant")
	@Scope("prototype")
	/**
	 * Creates a new Ant instance. Scope is prototype
	 * because we have different ants (default is singleton).
	 * @return
	 */
	public Ant getAnt() {
		return new Ant();
	}
}
