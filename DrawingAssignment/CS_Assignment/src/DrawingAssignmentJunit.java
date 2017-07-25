import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.assignment.controller.DrawingController;

/**
 * @author User
 * This class is used to test assignmnet
 */
public class DrawingAssignmentJunit {

	@Test
	public void testDrawOtherShapeWithotCanvas() {
		String[] junitInput = new String[1];
		junitInput[0] = "L 1 2 6 2";
		try{
			draw(junitInput);
			Assert.assertTrue(false);
		}catch (RuntimeException e) {
			Assert.assertTrue(true);
		}
	}
	@Test
	public void testBlankInput() {
		String[] junitInput = new String[1];
		try{
			draw(junitInput);
			Assert.assertTrue(false);
		}catch (RuntimeException e) {
			Assert.assertTrue(true);
		}
	}
	@Test
	public void testNullInput() {
		try{
			draw(null);
			Assert.assertTrue(false);
		}catch (RuntimeException e) {
			Assert.assertTrue(true);
		}
	}
	@Test
	public void testDrawBeyondCanvasSize() {
		String[] junitInput = new String[2];
		junitInput[0] = "C 20 4";
		junitInput[1] = "L 1 2 22 2";
		try{
			draw(junitInput);
			Assert.assertTrue(false);
		}catch (RuntimeException e) {
			Assert.assertTrue(true);
		}

	}
	@Test
	public void testNonNumericInputForCanvas() {
		String[] junitInput = new String[1];
		junitInput[0] = "C x y";
		try{
			draw(junitInput);
			Assert.assertTrue(false);
		}catch (RuntimeException e) {
			Assert.assertTrue(true);
		}

	}
	@Test
	public void testNonNumericInputForLine() {
		String[] junitInput = new String[2];
		junitInput[0] = "C 20 4";
		junitInput[1] = "L x 2 6 2";
		try{
			draw(junitInput);
			Assert.assertTrue(false);
		}catch (RuntimeException e) {
			Assert.assertTrue(true);
		}

	}
	@Test
	public void testNonNumericInputForRectangle() {
		String[] junitInput = new String[2];
		junitInput[0] = "C 20 4";
		junitInput[1] = "R x 2 6 2";
		try{
			draw(junitInput);
			Assert.assertTrue(false);
		}catch (RuntimeException e) {
			Assert.assertTrue(true);
		}

	}
	@Test
	public void testInvalidInputForRectangle() {
		String[] junitInput = new String[2];
		junitInput[0] = "C 20 4";
		junitInput[1] = "R 14 1 -18 3";
		try{
			draw(junitInput);
			Assert.assertTrue(false);
		}catch (RuntimeException e) {
			Assert.assertTrue(true);
		}

	}
	@Test
	public void testInvalidInputForLine() {
		String[] junitInput = new String[2];
		junitInput[0] = "C 20 4";
		junitInput[1] = "R 14 1 -18 3";
		try{
			draw(junitInput);
			Assert.assertTrue(false);
		}catch (RuntimeException e) {
			Assert.assertTrue(true);
		}

	}
	@Test
	public void testNonNumericInputForBucket() {
		String[] junitInput = new String[2];
		junitInput[0] = "C 20 4";
		junitInput[1] = "B x 2 c";
		try{
			draw(junitInput);
			Assert.assertTrue(false);
		}catch (RuntimeException e) {
			Assert.assertTrue(true);
		}

	}
	@Test
	public void testPostiveExecution() {
		String[] junitInput = new String[5];
		junitInput[0] = "C 20 4";
		junitInput[1] = "L 1 2 6 2";
		junitInput[2] = "L 6 3 6 4";
		junitInput[3] = "R 14 1 18 3";
		junitInput[4] = "B 10 3 o";
		BufferedReader brOutput = null;
		FileReader froutput= null;
		BufferedReader brinput = null;
		FileReader frinput= null;

		try {
			draw(junitInput);
			froutput = new FileReader("output.txt");
			brOutput = new BufferedReader(froutput);
			frinput = new FileReader("input.txt");
			brinput = new BufferedReader(froutput);

			String outputcurrentline;
			String inputcurrentline;

			brOutput = new BufferedReader(froutput);
			brinput = new BufferedReader(frinput);

			while ((outputcurrentline = brOutput.readLine()) != null && (inputcurrentline = brinput.readLine()) != null) {
				Assert.assertTrue(outputcurrentline.equals(inputcurrentline));
			}

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (brOutput != null)
				{
					brOutput.close();
					brinput.close();
				}
				if (froutput != null)
				{
					froutput.close();
					frinput.close();
				}
			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}

	}
 private void draw(String[] junitInput)
 {
	 DrawingController controller = new DrawingController();
	 controller.setLogType("File");
		for(String s : junitInput)
		{
			controller.execute(s);
		}
		controller.releaseResource();

 }
}
