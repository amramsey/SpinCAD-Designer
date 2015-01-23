/* SpinCAD Designer - DSP Development Tool for the Spin FV-1 
 * slow_gearTest.java
 * Copyright (C) 2015 - Gary Worsham 
 * Based on ElmGen by Andrew Kilpatrick 
 * 
 *   This program is free software: you can redistribute it and/or modify 
 *   it under the terms of the GNU General Public License as published by 
 *   the Free Software Foundation, either version 3 of the License, or 
 *   (at your option) any later version. 
 * 
 *   This program is distributed in the hope that it will be useful, 
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of 
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the 
 *   GNU General Public License for more details. 
 * 
 *   You should have received a copy of the GNU General Public License 
 *   along with this program.  If not, see <http://www.gnu.org/licenses/>. 
 *     
 */ 
 
package com.holycityaudio.SpinCAD.test;

import com.holycityaudio.SpinCAD.SpinCADFrame;
import com.holycityaudio.SpinCAD.SpinCADPanel;
import com.holycityaudio.SpinCAD.SpinCADPin;
import com.holycityaudio.SpinCAD.CADBlocks.*;

public class slow_gearTest {
	public slow_gearTest(SpinCADFrame f) {
		System.out.println("Start of slow_gearCADBlock unit test..." + "\n");

		SpinCADPanel p = new SpinCADPanel(f);
		InputCADBlock i = new InputCADBlock(225, 10);
		OutputCADBlock o = new OutputCADBlock(225, 290);
		slow_gearCADBlock m = new slow_gearCADBlock(225, 210);
f.dropBlock(p, m);	

f.getModel().sortAlignGen();
System.out.println("slow_gearCADBlock test passed with no connections!");
f.getModel().newModel();
// now do "all control connections"
f.dropBlock(p, i);	
f.dropBlock(p, m);	
f.dropBlock(p, o);	
{
	SpinCADPin p1 = i.getPin("Output 1");
	SpinCADPin p2 = m.getPin("Input_Left");
	p2.setConnection(i, p1);
}
{
	SpinCADPin p1 = o.getPin("Input 1");
	SpinCADPin p2 = m.getPin("Audio_Output_1");
	p2.setConnection(o, p1);
}
{
	SpinCADPin p1 = o.getPin("Input 2");
	SpinCADPin p2 = m.getPin("Ramp");
	p2.setConnection(o, p1);
}
{
	Pot0CADBlock pot0 = new Pot0CADBlock(25, 150 + 40 * 1);
	f.dropBlock(p, pot0);
	SpinCADPin p1 = pot0.getPin("Output 1");
	SpinCADPin p2 = m.getPin("Attack");
	p2.setConnection(pot0, p1);
}
f.getModel().sortAlignGen();
System.out.println("slow_gearCADBlock test passed with all control connections!");

f.getModel().newModel();	

// end of test code
	System.out.println("End of slow_gearCADBlock unit test" + "\n");
	}
}