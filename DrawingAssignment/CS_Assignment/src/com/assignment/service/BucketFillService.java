package com.assignment.service;

import java.util.Map;

/**
 * @author User
 * This class is used to create Bucket fill
 */

public class BucketFillService extends DrawingService {
	private int x;
	private int y;
	private String color;

	@Override
	public void validateAndPopulateAttributes(String[] attributes) {
		try {
			if(attributes == null || attributes.length != 3)
			{
				throw new RuntimeException("Invalid input");
			}
			x = Integer.valueOf(attributes[0]);
			y = Integer.valueOf(attributes[1]);
			color = attributes[2];
			if(x <=0 || y <=0 )
			{
				throw new RuntimeException("Please enter non zero positive value for coordinates");
			}
			if(getPreviousPattern() == null || getPreviousPattern().isEmpty())
			{
				throw new RuntimeException("Please draw canvas first");
				
			}
			if( y>getPreviousPattern().size() || x > (getPreviousPattern().get(0).length-3))
			{
				throw new RuntimeException("Please enter proper value for coordinates, it might beyond canvas size");
			}
			fillColor(x, y);
			
		} catch (RuntimeException e) {
			throw e;
		}
	}
	
	private void fillColor(int x, int y)
	{
		Map<Integer, String[]> previousPattern = getPreviousPattern();
		if(x < 0 || y < 0 || x > previousPattern.get(0).length-2 || y > previousPattern.size()-2)
			return;
		if(x-1 > -1 && previousPattern.get(y)[x-1].equals(" "))
		{
			previousPattern.get(y)[x-1] = color;
			fillColor(x-1, y);
		}
		if(y-1 > 0 && previousPattern.get(y-1)[x].equals(" "))
		{
			previousPattern.get(y-1)[x] = color;
			fillColor(x, y-1);
		}
		if(x+1 <= previousPattern.get(0).length-2 && previousPattern.get(y)[x+1].equals(" "))
		{
			previousPattern.get(y)[x+1] = color;
			fillColor(x+1, y);
		}
		if(y+1 <= previousPattern.size()-2 && previousPattern.get(y+1)[x].equals(" "))
		{
			previousPattern.get(y+1)[x] = color;
			fillColor(x, y+1);
		}
	}

}
