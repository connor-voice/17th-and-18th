package com.inversion.main;

import com.inversion.interfaces.Developer;

public class FrontendDeveloper implements Developer {
    

	@Override
	public void doDevelop() {
		// TODO Auto-generated method stub
		writeJavaScript();
	}
	
	public void writeJavaScript(){
        System.out.println("JavaScript is used everywhere anyway.");
    }
}