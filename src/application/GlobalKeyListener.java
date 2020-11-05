package application;

import org.jnativehook.keyboard.*;

public class GlobalKeyListener implements NativeKeyListener {
	
	public boolean clicking = true;
	public int i = 0;
	
	public void nativeKeyPressed(NativeKeyEvent e) {
		
		if (e.getKeyCode() == NativeKeyEvent.VC_F9) {
			
			if (i == 0) {
				Clicker.startClicking();
				i = 1;
			}
		}
		
		if (e.getKeyCode() == NativeKeyEvent.VC_F10) {
			Clicker.stopClicking();
			i = 0;
		}
		
	}
	
	public void nativeKeyReleased(NativeKeyEvent arg0) {

	}
	
	public void nativeKeyTyped(NativeKeyEvent e) {
	}

}
