package com.inversion.main.runner;

import com.inversion.main.BackendDeveloper;
import com.inversion.main.FrontendDeveloper;
import com.inversion.main.Project;

public class Runner {

	public static void main(String[] args) {
		
		BackendDeveloper back = new BackendDeveloper();
		FrontendDeveloper front = new FrontendDeveloper();
		Project proj = new Project();
		
		proj.implement(back);
		proj.implement(front);
		
	}
	
}
