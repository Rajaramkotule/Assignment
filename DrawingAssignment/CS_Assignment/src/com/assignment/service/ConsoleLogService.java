package com.assignment.service;
/**
 * @author User
 * This class is used to log output in console
 */
public class ConsoleLogService implements ILoggerService {

	@Override
	public void log(String content) {
		System.out.print(content);
	}

	@Override
	public void closeResource() {
		// TODO Auto-generated method stub
		
	}

}
