package application;

import java.awt.AWTException;
import java.awt.Robot;

public class Clicker extends Thread{
	
	public static int i;
	public static boolean clicking = false;
	public static Thread thread;

	public void run() {
		
		Robot robot;
		
		try {
			robot = new Robot();
			
			while (clicking = true) {
				//sleep for .2 seconds before each click
				Thread.sleep(200);
				robot.mousePress(SysTray.button);
				robot.mouseRelease(SysTray.button);
				i++;
				System.out.println(i);
			}
			
		} catch (AWTException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void startClicking() {
	
		i = 0;
		thread = new Clicker();
		thread.start();

	}
	
	public static void stopClicking() {
		thread.interrupt();
	}
	
}
