import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        
        int czeros = 1;
        int cones = 1;
        
        for(int i = 1; i<n; i++){
            int temp = czeros;
            czeros = cones;
            cones += temp;
        }
        
        System.out.println(czeros + cones);
    }
}
