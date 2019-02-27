import java.util.*;
import java.io.*;
import java.util.Scanner;
public class Maze{

	private char[][] maze;
	private booelan animate;

  	public Maze(String filename) throws FileNotFoundException{
        //instead of a try/catch, you can throw the FileNotFoundException.
        //This is generally bad behavior
 
        File text = new File(filename);
        // can be a path like: "/full/path/to/file.txt" or "../data/file.txt"
        
        //inf stands for the input file
        Scanner inf = new Scanner(text);
        int w = 0;
        int l = 0;
        while(inf.hasNextLine()){
            String line = inf.nextLine();
            l = line.length();
            w++;
        }
        char[][] maze = new char[w][l];
        Scanner bob = new Scanner(text);
        int row = 0;
        while(bob.hasNextLine()){
            String line = bob.nextLine();
            for(int i = 0; i < line.length(); i++){
                maze[row][i] = line.charAt(i);
            }
            row++;
        }
    }   
}
