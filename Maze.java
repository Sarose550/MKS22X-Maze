import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Maze{
  public static void main(String args[]) throws FileNotFoundException{
        //instead of a try/catch, you can throw the FileNotFoundException.
        //This is generally bad behavior
 
        File text = new File("Maze1.txt");
        // can be a path like: "/full/path/to/file.txt" or "../data/file.txt"
        
        //inf stands for the input file
        Scanner inf = new Scanner(text);
        int w = 0;
        int l = 0;
        while(inf.hasNextLine()){
            String line = inf.nextLine();
            l = line.length();
            w++;
            System.out.println(line);//hopefully you can do other things with the line
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
        for(int i = 0; i < w; i++){
            for(int j = 0; j < l; j++){
                System.out.print(maze[i][j]);
            }
            System.out.println();
        }
    }   
}
