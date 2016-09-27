package com.mcs.simulation;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

import javax.swing.Timer;


public class SimTimer{
	
	public static Timer timer;
	
	public static float time;
	
	private static void updateTime(){
		RuntimeMXBean mxBean = ManagementFactory.getRuntimeMXBean();
		System.out.println(mxBean.getUptime());
		time = mxBean.getUptime();
	}
	
	public static void getDeltaTime(){
		
	}
	
	public static void start(){

	}

}
