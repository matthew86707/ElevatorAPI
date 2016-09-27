package com.mcs.program;

import com.mcs.exceptions.DoorsOpenInShaftException;
import com.mcs.exceptions.NoSuchFloorException;
import com.mcs.exceptions.SentToSameFloorException;
import com.mcs.main.Elevator;
import com.mcs.main.ElevatorManager;
import com.mcs.main.Floor;

public class ElevatorProgramFunctions {
	
	public static void setTravelToFloor(Elevator e, Floor f){
		if(e.y > f.floorY){
			e.directionOfTravel = 1;
		}else if(e.y < f.floorY){
			e.directionOfTravel = -1;
		}else{
			try {
				throw new SentToSameFloorException();
			} catch (SentToSameFloorException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	public static Floor getFloorByID(int id){
		try{
		return ElevatorManager.Floors[id];
		}catch(Exception e){
			try {
				throw new NoSuchFloorException();
			} catch (NoSuchFloorException e1) {
				e1.printStackTrace();
			}
		}
		return null;
	}
	
	public static Elevator getElevatorByID(int id){
		return ElevatorManager.elevators[id];
	}
	
	public static void openDoors(Elevator e){
		if(ElevatorManager.floorLocations.get(e.y) == null){
			try {
				throw new DoorsOpenInShaftException();
			} catch (DoorsOpenInShaftException e1) {
				e1.printStackTrace();
			}
		}
		e.openDoors();
	}

}
