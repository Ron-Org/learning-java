package com.itbulls.learnit.javacore.exam.template.menu.impl;

import java.util.List;

import com.itbulls.learnit.javacore.exam.template.configs.ApplicationContext;
import com.itbulls.learnit.javacore.exam.template.enteties.User;
import com.itbulls.learnit.javacore.exam.template.menu.Menu;
import com.itbulls.learnit.javacore.exam.template.services.UserManagementService;
import com.itbulls.learnit.javacore.exam.template.services.impl.DefaultUserManagementService;

public class CustomerListMenu implements Menu {

	private ApplicationContext context;
	private UserManagementService userManagementService;
	
	{
		userManagementService = DefaultUserManagementService.getInstance();
		context = ApplicationContext.getInstance();
	}
	
	@Override
	public void start() {
		printMenuHeader();
		List<User> users = userManagementService.getUsers();
		
		if (users == null || users.size() == 0) {
			System.out.println("Unfortunately, there are no customers.");
		} else {
			for (User user : users) {
				System.out.println(user);
			}
		}
		context.getMainMenu().start();
	}

	@Override
	public void printMenuHeader() {
		System.out.println("***** USERS *****");		
	}

}
