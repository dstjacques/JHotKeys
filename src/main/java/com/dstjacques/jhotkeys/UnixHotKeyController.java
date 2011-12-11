/**
 * Copyright (c) 2011 Daniel St.Jacques
 *
 * This file is part of JHotKeys.
 *
 * JHotKeys is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * JHotKeys is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with JHotKeys.  If not, see <http://www.gnu.org/licenses/>.
 */


package com.dstjacques.jhotkeys;

import java.awt.event.KeyEvent;
import java.io.File;
import jxgrabkey.HotkeyConflictException;
import jxgrabkey.HotkeyListener;
import jxgrabkey.JXGrabKey;

/**
 * This class provides the ability to register, unregister, and
 * react to global hotkeys on Unix-like operating systems using
 * the JXGrabKey library.
 */
public class UnixHotKeyController implements JHotKeyController
{
   HotkeyListener hl;
   public UnixHotKeyController(String libPath)
   {
      // Use JXGrabKey library
      try
      {
         System.load(new File(libPath + System.getProperty("file.separator") + "unix/lib/libJXGrabKey.so").getCanonicalPath());
         JXGrabKey.getInstance();
      }
      catch(Exception e)
      {
         System.out.println(e.getMessage());
      }
   }

   public void registerHotKey(int id, int modifier, int key)
   {
      try
      {
         JXGrabKey.getInstance().registerAwtHotkey(id, modifier, key);
      }
      catch(HotkeyConflictException e)
      {
         System.out.println(e.getMessage());
      }
   }

   public void unregisterHotKey(int id)
   {
      JXGrabKey.getInstance().unregisterHotKey(id);
   }

   public void addHotKeyListener(final JHotKeyListener oskl)
   {
      this.hl = new HotkeyListener()
      {
         public void onHotkey(int id) {
            oskl.onHotKey(id);
         }
      };

      JXGrabKey.getInstance().addHotkeyListener(hl);
   }

}