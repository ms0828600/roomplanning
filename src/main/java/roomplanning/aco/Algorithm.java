package roomplanning.aco;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import roomplanning.aco.data.FoodSource;
import roomplanning.db.dao.FunctionRepository;
import roomplanning.db.model.Employee;
import roomplanning.db.model.Employee_Function;
import roomplanning.db.model.Function;
import roomplanning.db.model.Process;

@Service
public class Algorithm implements InitializingBean {
	
	@Autowired
	private ApplicationContext appContext;
	
	@Autowired
	private FunctionRepository functionRepository;
	private HashMap<Long, Long> functionMasks;
	
	@Override
	/**
	 * Called when the service gets created
	 */
	public void afterPropertiesSet() throws Exception {
		/* Build a bit mask for each function */
		Sort sort = new Sort(Sort.Direction.ASC, "id");
		List<Function> functions  = (List<Function>) functionRepository.findAll(sort);
		for(int i = 0; i < functions.size(); i++) {
			functionMasks.put(functions.get(i).getId(), 1L << i);
		}
	}
	
	/**
	 * Creates a new ant for the given employee and generation
	 * 
	 * @param employee
	 * @param generation
	 * @return
	 */
	public Ant buildAnt(Employee employee, int generation) {
		Ant ant = (Ant) appContext.getBean("Ant");
		ant.setFunctionCaps(getEmployeeCapabilities(employee));
		ant.setEmployee(employee);
		ant.setGeneration(generation);
		
		return ant;
	}

	/**
	 * Builds a food source for a given process:
	 * 
	 * 1) It computes a mask based on the roles
	 * 2) The food amount equals the number of needed roles
     *
	 * @param process
	 * @return
	 */
	public FoodSource buildFoodSource(Process process) {
		HashMap<Long, Integer> food = new HashMap<>();
		Long caps = 0L; 
		for (Function func : process.getFunctions()) {
			Long currentValue = functionMasks.get(func.getId());
			caps |= currentValue;
			if (food.containsKey(currentValue)) {
				food.put(currentValue, food.get(currentValue) + 1);
			}
			else {
				food.put(currentValue, 1);
			}
		}

		return new FoodSource(process, food, caps);
	}
	
	/**
	 * Computes the function mask for a given employee
	 * 
	 * @param employee
	 * @return
	 */
	private Long getEmployeeCapabilities(Employee employee) {
		Long caps = 0L;
		for (Employee_Function func : employee.getEmployeefunctions()) {
			caps |= functionMasks.get(func.getFunction().getId());
		}
		return caps;
	}
	
}
