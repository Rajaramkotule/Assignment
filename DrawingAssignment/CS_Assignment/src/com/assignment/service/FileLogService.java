package com.assignment.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
/**
 * @author User
 * This class is used to log the output in file
 */
public class FileLogService implements ILoggerService {
	
	private BufferedWriter bw = null;
	PrintWriter writer;
	
	
	@Override
	public void log(String content) {
		try {

			if(bw == null)
			{
				File rep = new File("output.txt");
				bw = new BufferedWriter(new FileWriter(rep));
			}
		if(!content.equalsIgnoreCase("\n"))
				bw.write(content);
			else
				bw.newLine();

		} catch (IOException e) {

			e.printStackTrace();

		} finally {
			
		}

	}

		@Override
	public void closeResource() {

		try {

			if (bw != null)
				bw.close();

		} catch (IOException ex) {

			ex.printStackTrace();

		}
	}

}
