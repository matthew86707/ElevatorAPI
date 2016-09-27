package com.mcs.simulation;

import java.util.Timer;
import java.util.TimerTask;

import com.mcs.main.Elevator;
import com.mcs.main.ElevatorManager;
import com.mcs.main.Floor;

public class MainSim implements Runnable{
	@Override
	public void run() {
		initFloors();
		initElevators();
		startSimLoop();
	}
	public static void initElevators(){
		ElevatorManager.elevators = new Elevator[3];
		ElevatorManager.elevators[0] = new Elevator(0, 2);
		ElevatorManager.elevators[1] = new Elevator(1, 1);
		ElevatorManager.elevators[2] = new Elevator(2, 3);
	}
	public static void initFloors(){
		ElevatorManager.Floors = new Floor[7];
		ElevatorManager.Floors[0] = new Floor(0, 100);
		ElevatorManager.Floors[1] = new Floor(1, 200);
		ElevatorManager.Floors[2] = new Floor(2, 300);
		ElevatorManager.Floors[3] = new Floor(3, 400);
		ElevatorManager.Floors[4] = new Floor(4, 500);
		ElevatorManager.Floors[5] = new Floor(5, 600);
		ElevatorManager.Floors[6] = new Floor(6, 700);
		
		ElevatorManager.fillFloorHashmap();
	}
	
	public static void startSimLoop(){
		Timer timer = new Timer();
		timer.schedule(new SimLoop(), 60L, 60L);
		
	}
}

