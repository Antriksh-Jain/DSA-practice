import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int cp = countPathsTabulation(n);
        System.out.println(cp);
    }
    
    public static int countPaths(int n){
        if(n == 0){
            return 1;
        } else if(n < 0){
            return 0;
        }
        int nm1 = countPaths(n - 1);
        int nm2 = countPaths(n - 2);
        int nm3 = countPaths(n - 3);
        int cp = nm1 + nm2 + nm3;
        
        return cp;
    }
    
    public static int countPathsTabulation(int n){
        int[] cp = new int[n + 1];
        cp[0] = 1;
        for(int i = 1; i<cp.length; i++){
            if(i == 1){
                cp[i] = cp[i - 1];
            } else if(i == 2){
                cp[i] = cp[i - 1] + cp[i - 2];
            } else {
                cp[i] = cp[i - 1] + cp[i - 2] + cp[i - 3];
            }
        }
        
        return cp[n];
    }
}
