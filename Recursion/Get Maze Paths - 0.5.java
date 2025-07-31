import java.util.Scanner;
import java.util.ArrayList;

public class Main{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        ArrayList<String> paths = getMazePaths(1, 1, n, m);
        System.out.println(paths);
    }
    
    static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc){
        if(dr<sr || dc<sc){
            ArrayList<String> bres = new ArrayList<>();
            return bres;
        } else if(dr==sr && dc==sc){
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }
        
        ArrayList<String> paths1r = getMazePaths(1, 1, dr-1, dc);
        ArrayList<String> paths1c = getMazePaths(1, 1, dr, dc-1);
        ArrayList<String> paths = new ArrayList<>();
        for(String path: paths1r){
            paths.add("h" + path);
        }
        for(String path: paths1c){
            paths.add("v" + path);
        }
        return paths;
    }
}
