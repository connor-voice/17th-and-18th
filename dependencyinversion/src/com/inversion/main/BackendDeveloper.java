package com.inversion.main;

import com.inversion.interfaces.Developer;

public class BackendDeveloper implements Developer {
   

	@Override
	public void doDevelop() {
		// TODO Auto-generated method stub
		writeJava();
		
	}
	
	 public void writeJava() {
	        System.out.println("C# is just Microsoft Java anyway.");
	    }
}
