1) The source code is place in CS_Assignment project
2) All validations are in place for input
3) DrawingController.java is input acceptor and it is single entry point to run assignment. It has main method to start.
   Output result is printed in both console as well as File (output.txt under CS_Assignment directory)
4) DrawingAssignmentJunit is used as Junit test. In this I have used file comparision for output.txt and input.txt 
   (input.txt contains input provided in assignment). It requires to add junit.jar in classpath.
5) Compilation error may occurrs due to dependency Junit jar. Please add junit.jar as library and update .classpath file accordingly.