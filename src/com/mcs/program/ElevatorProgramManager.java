package com.mcs.program;

import java.util.Random;

import com.mcs.main.ElevatorManager;

public class ElevatorProgramManager {
	
	public static ElevatorProgram mainProgram;
	
	public static int PROGRAM_START_DELAY = 1000;
	
	public static void runProgram(ElevatorProgram e){
		mainProgram = e;
		try {
			Thread.sleep(PROGRAM_START_DELAY);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		mainProgram.onStart();
	}
	
	public static void updateProgram(){
		if(Math.random() > 0.5f){
			int floorPressed = new Random().nextInt(ElevatorManager.Floors.length);
			mainProgram.onButtonPress(floorPressed);
			ElevatorManager.Floors[floorPressed].guests++;
		}
	}

}
