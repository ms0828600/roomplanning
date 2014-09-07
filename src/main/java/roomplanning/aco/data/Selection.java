package roomplanning.aco.data;

import roomplanning.db.model.Process;
import lombok.Data;

@Data
public class Selection {
	private Process process;
	
	private int day;
	private Daytime dayTime;
	
	private Long roleMask;
}
