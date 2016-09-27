package com.mcs.main;

import java.util.HashMap;

public class ElevatorManager {
	
	public static Floor[] Floors;
	public static Elevator[] elevators;
	public static HashMap<Integer, Floor> floorLocations = new HashMap<Integer, Floor>();
	
	public static void fillFloorHashmap(){
		for(Floor f : Floors){
			floorLocations.put(f.floorY, f);
		}
	}

}
