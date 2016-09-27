package com.mcs.simulation;

import java.io.ObjectInputStream.GetField;
import java.util.Random;

import com.mcs.main.Elevator;
import com.mcs.main.ElevatorManager;
import com.mcs.program.ElevatorProgramFunctions;
import com.mcs.program.ElevatorProgramManager;

public class UpdateElevators {

	
	public static void updateAll(){
		for(Elevator e : ElevatorManager.elevators){
			if(e.sleeping){
				e.cyclesElapsed++;
				if(e.cyclesToSleep < e.cyclesElapsed){
					e.sleeping = false;
					ElevatorProgramManager.mainProgram.onElevatorAwake(e);
				}
			}
			if(!(e.directionOfTravel == 0)){
				
				switch(e.directionOfTravel){
				case -1:
					e.y++;
					break;
				case 1:
					e.y--;
					break;
				
			}
			}
		
			
			if(ElevatorManager.floorLocations.get(e.y) != null){
				if(e.directionOfTravel != 0){
					e.directionOfTravel = 0;
					ElevatorProgramManager.mainProgram.onElevatorArrive(e, ElevatorManager.floorLocations.get(e.y).floorID);
					//e.directionOfTravel = 0;
				}
			
			}
			if(e.directionOfTravel == 0){
				if(ElevatorManager.floorLocations.get(e.y).guests > 0){
					if(e.doorsOpen){
						System.out.println("Floor emptying with " + ElevatorManager.floorLocations.get(e.y).guests);
				ElevatorManager.floorLocations.get(e.y).guests--;
				ElevatorProgramManager.mainProgram.onInnerButtonPress(e, new Random().nextInt(ElevatorManager.Floors.length));
					}
				}
			}
		
			
		}
	}
	
}
