package com.assignment.service;

/**
 * @author User
 * This class is used to create line
 */
public class LineService extends DrawingService {
	private int x1;
	private int y1;
	private int x2;
	private int y2;

	@Override
	public void validateAndPopulateAttributes(String[] attributes) {
		try {
			if(attributes == null || attributes.length != 4)
			{
				throw new RuntimeException("Invalid input");
			}
			x1 = Integer.valueOf(attributes[0]);
			y1 = Integer.valueOf(attributes[1]);
			x2 = Integer.valueOf(attributes[2]);
			y2 = Integer.valueOf(attributes[3]);
			if(x1 <=0 || x2 <=0 || y1 <=0 || y2 <=0)
			{
				throw new RuntimeException("Please enter non zero positive value for coordinates");
			}
			if(getPreviousPattern() == null || getPreviousPattern().isEmpty())
			{
				throw new RuntimeException("Please draw canvas first");
				
			}
			if(y1>y2 || y2>getPreviousPattern().size() || x1>x2 || x2 > (getPreviousPattern().get(0).length-3))
			{
				throw new RuntimeException("Please enter proper value for coordinates, it might beyond canvas size or not followed in correct order");
			}
			if(x1 != x2 && y1 != y2)
			{
				
				throw new RuntimeException("Only horizontal or vertical line can be drawn at this moment, please enter proper value for coordinates");
			}
			for(int i=y1; i<=y2; i++)
			{
				String pattern = " ";
				if(y1==y2)
				{
					pattern = getPattern();
				}
				String[] row = getPreviousPattern().get(i);
				
				row[x1] = getPattern();
				row[x2] = getPattern();
				for(int j = x1+1; j<= x2-1; j++)
				{
					row[j] = pattern;
				}
				
			}
		} catch (RuntimeException e) {
			throw e;
		}
	}

}
