
import com.dstjacques.jhotkeys.JHotKeys;
import com.dstjacques.jhotkeys.JHotKeyListener;

public class GlobalHotKeyExample
{

   public static void main(String[] args)
   {
      // Initialize an object with global hotkey support
      // and tell it where the "lib" folder with native
      // libraries are
      JHotKeys hotkeys = new JHotKeys("../lib");

      // Global hotkey on pressing 'A'
      hotkeys.registerHotKey(0, 0, (int)'A');
      // Global hotkey on pressing 'WIN_KEY' + 'B'
      hotkeys.registerHotKey(1, 8, (int)'B');

      JHotKeyListener hotkeyListener = new JHotKeyListener(){
         public void onHotKey(int id) {
            if(id == 0)
            {
               System.out.println("You pressed 'A'");
            }
            else if(id == 1)
            {
               System.out.println("You pressed 'WIN_KEY' + 'B'");
            }
         }
      };

      hotkeys.addHotKeyListener(hotkeyListener);

   }
}
