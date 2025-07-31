import java.util.Scanner;
import java.util.ArrayList;

public class Main{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        ArrayList<String> paths = getMazePathsJump(1, 1, n, m);
        System.out.println(paths);
    }
    
    static ArrayList<String> getMazePathsJump(int sr, int sc, int dr, int dc){
        if(sc == dc && sr == dr){
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }
        ArrayList<String> paths = new ArrayList<>();
        for(int ms = 1; ms<=dc-sc; ms++){
            ArrayList<String> hpaths = getMazePathsJump(sr, sc + ms, dr, dc);
            for(String hpath : hpaths){
                paths.add("h" + ms + hpath);
            }
        }
        for(int ms = 1; ms<=dr-sr; ms++){
            ArrayList<String> vpaths = getMazePathsJump(sr + ms, sc, dr, dc);
            for(String vpath : vpaths){
                paths.add("v" + ms + vpath);
            }
        }
        for(int ms = 1; ms<=dc-sc && ms<=dr-sr; ms++){
            ArrayList<String> dpaths = getMazePathsJump(sr + ms, sc + ms, dr, dc);
            for(String dpath : dpaths){
                paths.add("d" + ms + dpath);
            }
        }
        
        return paths;
    }
}
