package com.mcs.program;

import com.mcs.main.Elevator;

public interface ElevatorProgram {
	public void onElevatorArrive(Elevator elevator, int floor);
	public void onButtonPress(int floor);
	public void onInnerButtonPress(Elevator elevator, int requestedFloor);
	public void onDoorsClosed(Elevator elevator);
	public void onElevatorAwake(Elevator elevator);
	public void onStart();
	
	
}


