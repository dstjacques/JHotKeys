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

/**
 * JHotKeys provides the ability to register global hotkeys across multiple
 * operating systems by wrapping around several OS specific libraries and
 * making use of the right one at runtime.
 */
public class JHotKeys
{
   public JHotKeyController control;

   public JHotKeys(String libPath)
   {
      String os = System.getProperty("os.name").toLowerCase();

      if(os.indexOf("win") > -1)
      {
         this.control = new WindowsHotKeyController(libPath);
      }
      else if(os.indexOf("nux") > -1 || os.indexOf("nix") > -1)
      {
         this.control = new UnixHotKeyController(libPath);
      }
      else
      {
         System.out.println("Operating system not supported");
         this.control = null;
      }
   }

   public void registerHotKey(int id, int modifier, int key)
   {
      this.control.registerHotKey(id, modifier, key);
   }

   public void unregisterHotKey(int id)
   {
      this.control.unregisterHotKey(id);
   }

   public void addHotKeyListener(JHotKeyListener l)
   {
      this.control.addHotKeyListener(l);
   }

}