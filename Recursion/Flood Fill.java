import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        scn.nextLine();
        
        int[][] arr = new int[n][m];
        for(int i = 0; i<n; i++){
            String r = scn.nextLine();
            for(int j = 0; j<m; j++){
                int val = Integer.parseInt(r.split(" ")[j]);
                arr[i][j] = val;
            }
        }
        
        boolean[][] visited = new boolean[n][m];
        floodFill(arr, 0, 0, "", visited);
        
    }
    
    static void floodFill(int[][] maze, int row, int col, String psf, boolean[][] visited){
        if(row<0 || col<0 || row == maze.length || col == maze[0].length || visited[row][col] == true || maze[row][col] == 1){
            return;
        } 
        
        if(row == maze.length - 1 && col == maze[0].length - 1){
            System.out.println(psf);
            return;
        }
        
        visited[row][col] = true;
        floodFill(maze, row - 1, col, psf + "t", visited);
        floodFill(maze, row, col - 1, psf + "l", visited);
        floodFill(maze, row + 1, col, psf + "d", visited);
        floodFill(maze, row, col + 1, psf + "r", visited);
        visited[row][col] = false;
    }
}
