package com.assignment.service;
/**
 * @author User
 * This class is used to get logger object
 */
public class LoggerFactory {
	
	public static ILoggerService getLogger(String typeOfLogger)
	{
		
		if("File".equalsIgnoreCase(typeOfLogger))
		{
			return new FileLogService();
		}
		return new ConsoleLogService();
	}

}
