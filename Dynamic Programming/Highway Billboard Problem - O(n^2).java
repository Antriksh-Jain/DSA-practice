import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        
        int m = scn.nextInt();
        
        int n = scn.nextInt();
        int[] x = new int[n];
        
        for(int i = 0; i < x.length; i++){
            x[i] = scn.nextInt();
        }
        
        int[] rev = new int[n];
        for(int i = 0; i < rev.length; i++){
            rev[i] = scn.nextInt();
        }
        
        int t = scn.nextInt();
        
        int[] dp = new int[x.length];
        dp[0] = rev[0];
        int ans = 0;
        
        for(int i = 1; i < dp.length; i++){
            int max = 0;
            
            for(int j = 0; j < i; j++){
                int dist = x[i] - x[j];
                
                if(dist > t){
                    max = Math.max(max, dp[j]);
                }
            }
            
            dp[i] = max + rev[i];
            ans = Math.max(ans, dp[i]);
        }
        
        System.out.println(ans);
    }
}
