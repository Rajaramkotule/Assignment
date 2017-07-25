package com.assignment.service;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author User
 * This class is used to create canvas
 */
public class CanvasService extends DrawingService {
	
	private int width;
	private int height;

	public void validateAndPopulateAttributes(String[] attributes)
	{
		try
		{
		if(attributes == null || attributes.length != 2)
		{
			throw new RuntimeException("Invalid input");
		}
			
				width = Integer.valueOf(attributes[0]);
				height = Integer.valueOf(attributes[1]);
				if(width <=0 || height <=0)
				{
					throw new RuntimeException("Please enter non zero positive value for coordinates");
				}
				Map<Integer, String[]> previousPattern = getPreviousPattern();
				if(previousPattern == null)
				{
					previousPattern = new LinkedHashMap<Integer, String[]>();
					setPreviousPattern(previousPattern);
					String[] canvasHorizonatal = new String[width+2];
					for(int i = 0; i < width+2; i++)
					{
						canvasHorizonatal[i] = "-";
					}
					previousPattern.put(0, canvasHorizonatal);
					for(int i=1; i<= height; i++)
					{
						String[] rows = new String[width+2];
						rows[0] = "|";
						for(int j = 0; j < rows.length; j++)
						{
							if(j==0 || j==rows.length-1)
							{
								rows[j] = "|";
							}
							else
							rows[j] = " ";
						}
						
						previousPattern.put(i, rows);
					}
					previousPattern.put(height+1, canvasHorizonatal);
				}
				else
				{
					throw new RuntimeException("Canvas is already drawn !!");
				}
				
			}
			catch (RuntimeException e) {
				throw e;
			}
		}
}
