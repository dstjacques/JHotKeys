/**
 * 
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
 * This interface provides methods that should be implemented 
 * by a class that will register and unregister hotkeys as well as 
 * manage a listener for reacting to hotkeys on some operating system(s). 
 */
public interface JHotKeyController
{
   public void registerHotKey(int id, int modifier, int key);
   public void unregisterHotKey(int id);
   public void addHotKeyListener(JHotKeyListener l);
}

