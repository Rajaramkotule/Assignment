package com.assignment.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;

import com.assignment.service.DrawingFactory;
import com.assignment.service.DrawingService;
import com.assignment.service.ILoggerService;
import com.assignment.service.LoggerFactory;
/**
 * @author User
 * This class is used to run assignment
 * Input is given through console
 */
public class DrawingController {
	private ILoggerService loggerService;
	Map<Integer, String[]> previousPattern;
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		BufferedReader br = null;
        
        try
        {
        	br = new BufferedReader(new InputStreamReader(System.in));
        	DrawingController controller = new DrawingController();
        	controller.setLogType("File");
			while(true)
			{
				
				 System.out.print("enter command: ");
				 String s = br.readLine();
				 controller.execute(s);
			}
        }
        catch(Exception e)
        {
        	System.out.println(e.getMessage());
        }
        finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

	}
	public void execute(String userInput)
	{
		if(userInput == null)
		 {
			throw new RuntimeException("Please enter valid input");
		 }
        String[] input = userInput.split(" ");
        
        if ("q".equalsIgnoreCase(input[0])) {
            System.out.println("Exit!");
            loggerService.closeResource();
            System.exit(0);
        }
       
		DrawingService drawingService = DrawingFactory.getDrawingService(input[0]);
		drawingService.setLoggerService(null);
		String[] attributes = Arrays.copyOfRange(input, 1, input.length);
		drawingService.setPreviousPattern(getPreviousPattern());
		drawingService.validateAndPopulateAttributes(attributes);
		drawingService.draw();
		drawingService.setLoggerService(loggerService);
		drawingService.draw();
		setPreviousPattern(drawingService.getPreviousPattern());
	}
	public void setLogType(String logType) {
		loggerService = LoggerFactory.getLogger(logType);
	}
	private Map<Integer, String[]> getPreviousPattern() {
		return previousPattern;
	}
	private void setPreviousPattern(Map<Integer, String[]> previousPattern) {
		this.previousPattern = previousPattern;
	}
	
	public void releaseResource()
	{
		if(loggerService != null)
		{
			loggerService.closeResource();
		}
	}
}
