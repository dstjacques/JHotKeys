JHotKeys is a Java wrapper around the JIntellitype and JXGrabKey libraries which utilize JNI on their respective platforms.

Using it lets any Java application define global hotkeys that will work on Windows, Linux, and other Unix-like platforms.

License
-------
GNU LGPLv3. See COPYING and COPYING.LESSER for more information.

Included Dependencies
------------
Binaries of the dependent libraries JIntellitype and JXGrabKey are already included in lib/windows and lib/unix in completely unmodified form.

This is done for convenience to make getting up and running easier. You are welcome to build newer versions of these if so desired and replace the older version in its respective folder.

Their source code is open and readily available via their respective websites.

- JIntellitype (http://melloware.com/products/jintellitype) - The Apache Software License, Version 2.0
- JXGrabKey (http://sourceforge.net/projects/jxgrabkey) - GNU Library or "Lesser" General Public License version 3.0 (LGPLv3)

How to build JHotKeys
---------------------
The JHotKeys source and the included example can all be built by using the makefile provided in this directory.

`make`

How to use JHotKeys
-------------------
Place the lib folder somewhere in your application's directory structure

The lib folder should contain JHotKeys.jar (if not you have to build it from source) and its subdirectories should have the wrapped libraries for Windows (JIntellitype) and Linux (JXGrabKey).

Use the following imports.

``` java
import com.dstjacques.jhotkeys.JHotKeys;
import com.dstjacques.jhotkeys.JHotKeyListener;
```

Create a JHotKeys object specifying where the lib folder is located with regards to the current path.

``` java
JHotKeys hotkeys = new JHotKeys(PATH_TO_LIB);
```

Register a global hotkey for the 'A' key without any modifiers.

``` java
hotkeys.registerHotKey(0, 0, (int)'A');
```

Implement a key listener with actions that will occur when the hotkeys you define are used.

``` java
      JHotKeyListener hotkeyListener = new JHotKeyListener(){
         public void onHotKey(int id) {
            if(id == 0)
            {
               System.out.println("You pressed 'A'");
            }
         }
      };
```

Add the key listener.

``` java
      hotkeys.addHotKeyListener(hotkeyListener);
```

For a concrete example see examples/GlobalHotKeyExample.java.


