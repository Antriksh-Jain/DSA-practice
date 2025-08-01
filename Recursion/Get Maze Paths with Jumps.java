import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        printMazePaths(1, 1, n, m, "");
    }
    
    static void printMazePaths(int sr, int sc, int dr, int dc, String psf){
        if(sr == dr && sc == dc){
            System.out.println(psf);
            return;
        }
        
        for(int i = 1; i<=dc-sc; i++){
            printMazePaths(sr, sc+i, dr, dc, psf + "h" + i);
        }
        for(int i = 1; i<=dr-sr; i++){
            printMazePaths(sr+i, sc, dr, dc, psf + "v" + i);
        }
        for(int i = 1; i<=dc-sc && i<=dr-sr; i++){
            printMazePaths(sr+i, sc+i, dr, dc, psf + "d" + i);
        }
    }
}
