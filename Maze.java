import java.util.*;
import java.io.*;
import java.util.Scanner;
public class Maze{

    private char[][] maze;
    private boolean animate;
    private int width;
    private int length;
    private int startx;
    private int starty;

    public Maze(String filename) throws FileNotFoundException{
        try{
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
                        starty = i;
                        startx = row;
                    }
                }
                row++;
            }
        }catch(FileNotFoundException ex){
            throw new FileNotFoundException("I can't find that file.");
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
        for(int i = -1; i <= 1; i++){
            for(int j = -1; j <= 1; j++){
                if(i * i != j * j){
                    if(maze[x + i][y + j] == 'E') return 1;
                    if(maze[x + i][y + j] == ' '){
                        maze[x + i][y + j] = '@';
                        int k = this.solveH(x + i, y + j);
                        if(k != -1) return 1 + k;
                        maze[x + i][y + j] = '.';
                    }
                }
            }
        }
        return -1;
    }
}
