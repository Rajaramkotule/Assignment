package com.assignment.service;
/**
 * @author User
 * This class is used to get type of shape
 */
public class DrawingFactory {
	
	public static DrawingService getDrawingService(String drwaingType){
		if("C".equals(drwaingType))
		{
			return new CanvasService();
		}
		else if("R".equals(drwaingType))
		{
			return new RectangleService();
		}
		else if("L".equals(drwaingType))
		{
			return new LineService();
		}
		else if("B".equals(drwaingType))
		{
			return new BucketFillService();
		}
		throw new RuntimeException("Invalid Input");
	}

}
