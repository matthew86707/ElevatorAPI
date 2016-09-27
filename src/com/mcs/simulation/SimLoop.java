package com.mcs.simulation;

import java.util.TimerTask;

import com.mcs.graphics.Window;
import com.mcs.main.ElevatorManager;
import com.mcs.program.ElevatorProgramManager;

public class SimLoop extends TimerTask{
	
	public void run(){
		ElevatorProgramManager.updateProgram();
		updateGraphics();
		UpdateElevators.updateAll();
	}
	
	public void updateGraphics(){
		Window.graphicsPanel.repaint();
	}

}
