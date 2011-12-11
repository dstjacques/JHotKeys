import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.JOptionPane;

import jxgrabkey.HotkeyConflictException;
import jxgrabkey.HotkeyListener;
import jxgrabkey.JXGrabKey;

public class JXGrabKeyTest {

	private static final int MY_HOTKEY_INDEX = 1;
	private static boolean hotkeyEventReceived = false;
	
	public static void main(String[] args) throws Exception {
		//Load JXGrabKey lib
		System.load(new File("lib/libJXGrabKey.so").getCanonicalPath());
		
		//Enable Debug Output
		JXGrabKey.setDebugOutput(true);
		
		//Register some Hotkey
		try{
			//int key = KeyEvent.VK_K, mask = KeyEvent.CTRL_MASK | KeyEvent.ALT_MASK | KeyEvent.SHIFT_MASK;
			int key = KeyEvent.VK_F2, mask = KeyEvent.ALT_MASK; //Conflicts on GNOME
			
			JXGrabKey.getInstance().registerAwtHotkey(MY_HOTKEY_INDEX, mask, key);
		}catch(HotkeyConflictException e){
			JOptionPane.showMessageDialog(null, e.getMessage(), e.getClass().getName(), JOptionPane.ERROR_MESSAGE);
			
			JXGrabKey.getInstance().cleanUp(); //Automatically unregisters Hotkeys and Listeners
			//Alternatively, just unregister the key causing this or leave it as it is 
			//the key may not be grabbed at all or may not respond when numlock, capslock or scrollock is on
			return;
		}
				
		//Implement HotkeyListener
		HotkeyListener hotkeyListener = new jxgrabkey.HotkeyListener(){
			public void onHotkey(int hotkey_idx) {
				if (hotkey_idx != MY_HOTKEY_INDEX)
					return;
				hotkeyEventReceived = true;
			}
        };
        
        //Add HotkeyListener
		JXGrabKey.getInstance().addHotkeyListener(hotkeyListener);
		
		//Wait for Hotkey Event
		while(!hotkeyEventReceived){
			Thread.sleep(1000);
		}
		
		// Shutdown JXGrabKey
		JXGrabKey.getInstance().unregisterHotKey(MY_HOTKEY_INDEX); //Optional
		JXGrabKey.getInstance().removeHotkeyListener(hotkeyListener); //Optional
		JXGrabKey.getInstance().cleanUp();
	}
}
