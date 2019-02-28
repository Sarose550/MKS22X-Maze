import java.util.*;
import java.io.*;
import java.util.Scanner;
public class Maze{

	private char[][] maze;
	private booelan animate;
	private int width;
	private int length;
	private int startx;
	private int starty;

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
        width = w;
        length = l;
        maze = new char[w][l];
        Scanner bob = new Scanner(text);
        int row = 0;
        while(bob.hasNextLine()){
            String line = bob.nextLine();
            for(int i = 0; i < line.length(); i++){
                maze[row][i] = line.charAt(i);
                if(maze[row][i] == 'S'){
                	startx = i;
                	starty = row;
                }
            }
            row++;
        }
    }

    public String toString(){
    	String result = "";
    	for(int i = 0; i < width; i++){
    		for(int j = 0; j < length; j++){
    			result += maze[i][j];
    		}
    		result += "\n";
    	}
    	return result;
    }

    public void setAnimate(boolean b){
        animate = b;
    }

    public int solve(){
    	return this.solveH(startx, starty);
    }

    public int solveH(int x, int y){
    	for(int i = -1; i <= 1; i += 2){
    		for(int j = -1; j <= 1; j+=2){
    			if(maze[x][y] == 'E') return 0;
    			if(maze[x][y] == ' '){
    				maze[x][y] = '@';
    				int k = this.solveH(x + i, y + j);
    				if(k != -1) return 1 + k;
    				maze[x][y] = '.';
    			}
    		}
    	}
    	return -1;
    }
}
