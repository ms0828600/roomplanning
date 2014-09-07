package roomplanning.aco.data;

import java.util.HashMap;

import lombok.Data;
import roomplanning.db.model.Process;

@Data
public class FoodSource {
	private double pheromone;
	
	/**
	 * Stores which kind of ant is allowed to eat here
	 */
	private Long functionMask;
	
	/**
	 * Stores the available food
	 */
	private HashMap<Long, Integer> food;
	
	/**
	 * Stores the process this food source represents
	 */
	private Process process;

	/**
	 * Stores the daytime of this food source
	 */
	private int day;
	private Daytime dayTime;
	
	public FoodSource(Process process, HashMap<Long, Integer> food, Long functionMask) {
		this.process = process;
		this.food = food;
		this.functionMask = functionMask;
	}
}
