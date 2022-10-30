/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package robotgame;

/**
 *
 * @author Reddogg
 */
public class Robot {
    
    private int xLocation;
    private int yLocation;
    private char payload;
    private final long robotNumber;
    static int numberOfRobots = 0;
    public static char[][] grid = new char[26][26];
    
    Robot(){
        xLocation = 0;
        yLocation = 0;
        payload = ' ';
        numberOfRobots++;
        robotNumber = numberOfRobots;
        grid[xLocation][yLocation] = (char)(robotNumber+48);
        System.out.println("\nRobot " + robotNumber + " is at " + "(" + xLocation + ", " 
            + yLocation + ")");
    } //default constructor

    Robot(int x, int y, char payload){
        xLocation = x;
        yLocation = y;
        this.payload = payload;
        numberOfRobots++;
        robotNumber = numberOfRobots;
        if (xLocation >= 0 && xLocation < grid.length) {
            grid[xLocation][yLocation] = (char)(robotNumber+48);
            System.out.println("\nRobot " + robotNumber + " (" + xLocation 
                + ", " + yLocation + ") is at " + "(" + xLocation + ", " 
                + yLocation + ")");
        }
    } // constructor with three parameters
    
    // get and set methods for each private data member
    public int getXLocation(){return xLocation;}
    public int getYLocation(){return yLocation;}
    public int getPayload(){return payload;}
    public void setXLocation(int x){
        xLocation = x;
    }
    public void setYLocation(int y){
        yLocation = y;
    }
    public void setPayload(char payload){
        this.payload = payload;
    }
    
    // instruct Robot to pick up anything at the location lx, ly
    public boolean pickup(int lx, int ly) {

        // move to location pickup
	if (xLocation != lx && yLocation != ly) {
            grid[xLocation][yLocation] = ' ';
            MoveTo(lx, ly);
            System.out.println("\tarrived... \n\tready to load....\n");
	}

	// verify if there is a char load at location, then load
	if (grid[lx][ly] == ' ')
            System.out.println("No load at this location.");
	else {
            System.out.print("\tcargo is ");
                if (this.payload != ' ')
                    System.out.print("full. Please unload cargo first.");
                else {
                    System.out.print("loading...");
                    payload = grid[lx][ly];
                    grid[yLocation][xLocation] = ' ';
                    System.out.println("\n\tLoad complete.");
                    System.out.println("\tRobot cargo is " + payload);
                    return true;
                }
	}
	return false;
    }
    public boolean dropOff(int lx, int ly) {

	// verify location
	if (xLocation != lx && yLocation != ly) {
            System.out.println("\nRobot " + robotNumber + ") is not at " + "(" + xLocation + ", " 
                + yLocation + ")");
            return false;
        }
	// verify cargo at location empty
	if(grid[xLocation][yLocation] != ' ' && payload != ' '){
            System.out.print("\tUnloading cargo...\n");
            grid[xLocation][yLocation] = payload;
            System.out.println("\tgrid has " + grid[xLocation][yLocation]);
            payload = ' ';
            System.out.print("\n------------Dropoff success!------------\n\n");
        }
	else{
		System.out.println("grid has " + grid[xLocation][yLocation]);
		System.out.print("There is no space for this cargo in Grid. Please move somewhere else.\n");
	}
	return false;
    }
    public void moveRight(){
        int oldLX = xLocation;
        int oldLY = yLocation;
        char temp = grid[xLocation+1][yLocation];
        
        if (xLocation >= 0 && xLocation < grid.length) 
	{
            // moves robot one space at a time to new location
                xLocation++;  
            System.out.println("\tmoving right...  (" 
                + xLocation + ", " + yLocation + ")");
            if(grid[xLocation][yLocation] == ' '){
                grid[xLocation][yLocation] = (char)(robotNumber+48);
            }
            if(grid[xLocation-1][yLocation] == (char)(robotNumber+48)){
                grid[xLocation-1][yLocation] = ' ';
            }   
        }
        else {
            System.out.println("Right boundary reached." + 
            "\n------------------------------------------\n");
        }
    }

    public void moveLeft(){
        int oldLX = xLocation;
        int oldLY = yLocation;
        if (xLocation >= 0 && xLocation < grid.length) 
	{
            //moves robot one space at a time to new location
            xLocation--;    
            System.out.println("\tmoving left...  (" 
                + xLocation + ", " + yLocation + ")");
            if(grid[xLocation][yLocation] == ' '){
                grid[xLocation][yLocation] = (char)(robotNumber+48);
            }
            if(grid[xLocation+1][yLocation] == (char)(robotNumber+48)){
                grid[xLocation+1][yLocation] = ' ';
            }
        }
        else {
            System.out.println("Left boundary reached." + 
            "\n------------------------------------------\n");
        }
    }
    public void moveUp(){
        int oldLX = xLocation;
        int oldLY = yLocation;
        if (xLocation >= 0 && xLocation < grid.length) 
	{
            //moves robot one space at a time to new location
                yLocation--;   
            System.out.println("\tmoving up...  (" 
                + xLocation + ", " + yLocation + ")");
            if(grid[xLocation][yLocation] == ' '){
                grid[xLocation][yLocation] = (char)(robotNumber+48);
            }
            if(grid[xLocation][yLocation+1] == (char)(robotNumber+48)){
                grid[xLocation][yLocation+1] = ' ';
            }
        }
        else {
            System.out.println("Top boundary reached." + 
            "\n------------------------------------------\n");
        }
    }
    public void moveDown(){
        int oldLX = xLocation;
        int oldLY = yLocation;
        if (xLocation >= 0 && xLocation < grid.length) 
	{
            // moves robot one space at a time to new location
                yLocation++;   
            System.out.println("\tmoving down...  (" 
                + xLocation + ", " + yLocation + ")");
            if(grid[xLocation][yLocation] == ' '){
                grid[xLocation][yLocation] = (char)(robotNumber+48);
            }
            if(grid[xLocation][yLocation-1] == (char)(robotNumber+48)){
                grid[xLocation][yLocation-1] = ' ';
            }
        }
        else {
            System.out.println("Bottom boundary reached." + 
            "\n------------------------------------------\n");
        }
    }

    public boolean MoveTo(int lx, int ly) {
        int oldLX = xLocation;
        int oldLY = yLocation;

	// check if location is on grid, otherwise return false
	if (lx >= 0 && lx < grid.length && ly >= 0 && ly < grid.length) {
            System.out.println("\nRobot " + robotNumber + " (" + xLocation 
                + ", " + yLocation + ") is moving to " + "(" + lx + ", " 
                + ly + ")");
            // robot moving to the location
            if (yLocation < ly) {
                for (int i = yLocation; i < ly; i++) {
                    moveDown();
                }
            }
            if (yLocation > ly) {
                for (int i = yLocation; i > ly; i--) {
                    moveUp();
                }
            }
            if (xLocation < lx) {
                for (int i = xLocation; i < lx; i++) {
                    moveRight();
                }
            }
            if (xLocation > lx) {
                for (int i = xLocation; i > lx; i--) {
                    moveLeft();
                }
            }
            
            if(grid[xLocation][yLocation] == ' '){
                grid[lx][ly] = (char)(robotNumber+48);

            }
            if(grid[oldLX][oldLX] != ' ')
                return true;
            else{
                grid[oldLX][oldLY] = ' ';
                return true;
            }
	}
	else {
		System.out.println("This location is not on the grid. Try again." + 
		"\n------------------------------------------\n");
		return false;
	}
    }
    
    public static void print2D() {
	
	// print 'Robot Game' board
	System.out.print("\n---------------");
	System.out.print("\t\t\tRobot Game" + "-------------------\n   ") ;
	for (int label = 0; label < grid.length; label++){
            if(label >= 10){
                    System.out.print(" "+ label);
            }
            else{
                System.out.print("  "+ label);
            }
        }
        System.out.println();
            
	for (int row = 0; row < grid.length; row++) {
                if(row >= 10){
                    System.out.print(" "+ row);
                }
                else{
                    System.out.print("  "+ row);
                }
		for (int col = 0; col < grid.length; col++) {
                    System.out.print("  " + grid[col][row]); // print each cell in grid structure
		}
		System.out.println();
            }
        System.out.print("   ");
	for (int label = 0; label < grid.length; label++){
            if(label >= 10){
                System.out.print(" "+ label);
            }
            else{
                System.out.print("  "+ label);
            }
        }
        System.out.println();
    }
}
