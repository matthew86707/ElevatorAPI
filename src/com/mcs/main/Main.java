package com.mcs.main;

import com.mcs.graphics.Window;
import com.mcs.program.MyProgram;
import com.mcs.simulation.MainSim;

public class Main {
	
	static Window main;

	public static void main(String[] args) {
		
		
		main = new Window();
		Thread sim = new Thread (new MainSim());
		sim.start();
		new MyProgram().sudoMain();
		
	}

}
