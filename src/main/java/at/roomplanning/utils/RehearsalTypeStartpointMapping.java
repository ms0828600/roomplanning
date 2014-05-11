package at.roomplanning.utils;

import java.util.concurrent.ConcurrentHashMap;

import at.roomplanning.entities.Performance;
import at.roomplanning.entities.Performance.Type;
import at.roomplanning.entities.RehearsalType;

public class RehearsalTypeStartpointMapping {


	public static ConcurrentHashMap<Performance.Type, RehearsalType.Type> performanceMapping_StartPoint = new ConcurrentHashMap<Performance.Type, RehearsalType.Type>();
	
	public RehearsalTypeStartpointMapping() {
		RehearsalTypeStartpointMapping.performanceMapping_StartPoint.put(Type.NEUINSZENIERUNG, RehearsalType.Type.KORREPETITIONSPROBE);
	}

	
}
