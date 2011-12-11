/*
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

import java.io.File;
import com.melloware.jintellitype.HotkeyListener;
import com.melloware.jintellitype.IntellitypeListener;
import com.melloware.jintellitype.JIntellitype;

/**
 * This class provides the ability to register, unregister, and 
 * react to global hotkeys on Windows operating systems using
 * the JIntellitype library.
 */
public class WindowsHotKeyController implements JHotKeyController
{
   HotkeyListener hl;

   public WindowsHotKeyController(String libPath)
   {
      // Use JIntellitype library
      try
      {
         JIntellitype.getInstance();
      }
      catch(Exception e)
      {
         System.out.println(e.getMessage());
      }
   }

   public void registerHotKey(int id, int modifier, int key)
   {
      JIntellitype.getInstance().registerHotKey(id, modifier, key);
   }

   public void unregisterHotKey(int id)
   {
      JIntellitype.getInstance().unregisterHotKey(id);
   }

   public void addHotKeyListener(final JHotKeyListener oskl)
   {
      this.hl = new HotkeyListener()
      {
         public void onHotKey(int id) {
            oskl.onHotKey(id);
         }
      };

      JIntellitype.getInstance().addHotKeyListener(hl);
   }

}