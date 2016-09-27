package com.mcs.main;

import com.mcs.exceptions.NoSuchFloorException;

public class Elevator {
	
	//graphics
	public int x;
	public int y;
	
	public int doorOffset = 0;
	
	public boolean doorsOpen = false;
	public boolean stopped = false;
	
	//sim
	int ID;
	public int directionOfTravel;	
	
	public boolean sleeping = false;
	
	public int cyclesToSleep;
	public int cyclesElapsed;
	
	
	public void openDoors(){
		doorsOpen = true;
	}
	
	public void closeDoors(){
		doorsOpen = false;
	}
	
	public void sleepFor(int cycles){
		sleeping = true;
		cyclesElapsed = 0;
		cyclesToSleep = cycles;
	}
	
	public void stop(){
		directionOfTravel = 0;
	}
	
	public Elevator(int ID, int floor){
		this.ID = ID;
		try{
		this.y = ElevatorManager.Floors[floor].floorY;
		}catch (Exception e){
			try {
				throw new NoSuchFloorException();
			} catch (NoSuchFloorException e1) {
				e1.printStackTrace();
			}
		}
		this.x = 300 + ID * 300;
	}
	
	public int getID(){
		return this.ID;
	}

}
