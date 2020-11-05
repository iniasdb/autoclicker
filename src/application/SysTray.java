package application;

import java.awt.AWTException;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;

import javax.swing.ImageIcon;

public class SysTray {
	
	public static int button = InputEvent.BUTTON1_MASK;
	
	public static void addIcon() {
			
			final PopupMenu popup = new PopupMenu();
	        
			//final TrayIcon trayIcon = new TrayIcon(new ImageIcon(SysTray.class.getResource("images/bulb.gif")).getImage());
			//InputStream input = classLoader.getResourceAsStream("image.jpg");
	        final TrayIcon trayIcon = new TrayIcon(new ImageIcon(SysTray.class.getResource("bulb.gif")).getImage());
	        final SystemTray tray = SystemTray.getSystemTray();
	        
	        // Create a popup menu components
	        Menu knoppen = new Menu("Knop kiezen");
	        MenuItem rechter = new MenuItem("Rechter Knop");
	        MenuItem linker = new MenuItem("linker");
	        MenuItem exit = new MenuItem("exit");
	        
	        //Add components to popup menu
	        popup.add(knoppen);
	        knoppen.add(linker);
	        knoppen.add(rechter);
	        popup.addSeparator();
	        popup.add(exit);
	         
	        trayIcon.setPopupMenu(popup);
	                
	        try {
	            tray.add(trayIcon);
	        } catch (AWTException e) {
	            System.out.println("TrayIcon could not be added.");
	            return;
	        }
	        
	        trayIcon.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	System.out.println("ja manne");
	            }
	        });
	        
	        linker.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		System.out.println("linker");
	        		button = InputEvent.BUTTON1_MASK;
	        	}
	        });
	        
	        rechter.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		System.out.println("rechter");
	        		button = InputEvent.BUTTON3_MASK;
	        	}
	        });
	        
	        exit.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		System.out.println("exit");
	        		tray.remove(trayIcon);
	        		System.exit(0);
	        	}
	        });
		}
}
