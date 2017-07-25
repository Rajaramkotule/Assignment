package com.assignment.service;

import java.util.Map;
/**
 * @author User
 * This class is used to draw shape
 */
public abstract class DrawingService {
	
	private Map<Integer, String[]> previousPattern;
	public abstract void validateAndPopulateAttributes(String[] attributes);
	private ILoggerService loggerService;
	
	public String getPattern()
	{
		return "x";
	}
	public void draw() 
	{
		for(int i : previousPattern.keySet())
		{
			String[] row = previousPattern.get(i);
			for (int j = 0; j < row.length; j++) {
				if(row[j] != null)
				{
					if(loggerService != null)
					{
						loggerService.log(row[j]);
					}else
					{
						System.out.print(row[j]);
					}
				}
			}
			if(loggerService != null)
			{
				loggerService.log("\n");
			}else
			{
				System.out.print("\n");
			}
		}
	}

	public Map<Integer, String[]> getPreviousPattern() {
		return previousPattern;
	}

	public void setPreviousPattern(Map<Integer, String[]> previousPattern) {
		this.previousPattern = previousPattern;
	}
	public ILoggerService getLoggerService() {
		return loggerService;
	}
	public void setLoggerService(ILoggerService loggerService) {
		this.loggerService = loggerService;
	}

}
