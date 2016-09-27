package com.mcs.graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends JFrame{
	
	public static JPanel graphicsPanel;
	
	public Window(){
		setSize(1280, 720);
		setVisible(true);
		setTitle("Simulation");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		graphicsPanel = new GraphicsPanel();
		this.add(graphicsPanel);
	}

}
