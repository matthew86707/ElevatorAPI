package com.mcs.program;

import java.util.Random;

import com.mcs.main.Elevator;
import com.mcs.main.ElevatorManager;

public class MyProgram extends ElevatorProgramFunctions implements ElevatorProgram{
	
	public void sudoMain(){
		ElevatorProgramManager.runProgram(this);
		
	}

	@Override
	public void onElevatorArrive(Elevator elevator, int floor) {
		elevator.stop();
		elevator.openDoors();
		elevator.sleepFor(100);
	}

	@Override
	public void onButtonPress(int floor) {
		// TODO Auto-generated method stub
		//System.out.println("Button Was Pressed! On Floor : " + floor);
	}

	@Override
	public void onStart() {
		setTravelToFloor(getElevatorByID(1), getFloorByID(2));
		setTravelToFloor(getElevatorByID(0), getFloorByID(3));
		setTravelToFloor(getElevatorByID(2), getFloorByID(1));
		
	}

	@Override
	public void onInnerButtonPress(Elevator elevator, int requestedFloor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDoorsClosed(Elevator elevator) {
		setTravelToFloor(elevator, getFloorByID(new Random().nextInt(ElevatorManager.Floors.length)));
		
	}

	@Override
	public void onElevatorAwake(Elevator elevator) {
		elevator.closeDoors();
		
	}

}
