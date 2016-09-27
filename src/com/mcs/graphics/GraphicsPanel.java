package com.mcs.graphics;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import com.mcs.main.Elevator;
import com.mcs.main.ElevatorManager;
import com.mcs.main.Floor;
import com.mcs.program.ElevatorProgramManager;

public class GraphicsPanel extends JPanel{
	
	protected void paintComponent(Graphics g) {
	    super.paintComponent(g);  
	    
	    //Draw Sky
	    g.setColor(Colors.COLOR_SKY);
	    g.fillRect(0, 0, this.getWidth(), this.getHeight());
	    
	    //Draw Walls
	    g.setColor(Colors.RED);
	    for(int i = 0; i < ElevatorManager.elevators.length; i++){
	    	
	    	if(i - 1 < 0){
	    		 g.fillRect(ElevatorManager.elevators[i].x - 100, 0, 100, getHeight());
	    	}else{
	    	if(i + 1 >= ElevatorManager.elevators.length){
	    		g.fillRect(ElevatorManager.elevators[i].x + 20, 0, 100, getHeight());
	    	}
	    		 g.fillRect(ElevatorManager.elevators[i].x - 280, 0, 280, getHeight());
	    	}
	    }
	    
	    //Draw Floors
	    g.setColor(Colors.FLOOR_WOOD);
	    for(Floor level : ElevatorManager.Floors){
	    	g.fillRect(0, level.floorY, this.getWidth(), 6);
	    }
	    
	    //Draw Guest Number At Floors
	    g.setColor(Color.WHITE);
	    for(Floor f : ElevatorManager.Floors){
	    g.drawString(f.guests + "", 0, f.floorY);
	    }
	    
	    //Draw Elevators
	    
	   
	    for(Elevator e : ElevatorManager.elevators){
	    	 g.setColor(Colors.ELEVATOR);
	    	g.fillRect(e.x, e.y - 30, 20, 30);
	    	//Draw doors
	    	if(e.doorsOpen){
	    		if(e.doorOffset < 10){
	    			e.doorOffset++;
	    		}
	    	}
	    	if(!(e.doorsOpen)){
	    		if(e.doorOffset == 1){
	    			ElevatorProgramManager.mainProgram.onDoorsClosed(e);
	    		}
	    		if(e.doorOffset > 0){
	    			e.doorOffset--;
	    		}
	    	}
	    	g.setColor(new Color(200, 40, 40));
	    	g.fillRect(e.x - e.doorOffset, e.y - 30, 10, 30);
	    	g.fillRect(e.x + e.doorOffset + 10, e.y - 30, 10, 30);
	    }
	    
	  
	    
	  }

}
