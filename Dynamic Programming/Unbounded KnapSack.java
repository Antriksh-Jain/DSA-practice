import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] vals = new int[n];
        int[] wts = new int[n];
        
        scn.nextLine();
        String val = scn.nextLine();
        for(int i = 0; i<vals.length; i++){
            vals[i] = Integer.parseInt(val.split(" ")[i]);
        }
        
        String wt = scn.nextLine();
        for(int i = 0; i<wts.length; i++){
            wts[i] = Integer.parseInt(wt.split(" ")[i]);
        }
        
        int cap = scn.nextInt();
        
        int[] dp = new int[cap + 1];
        dp[0] = 0;
        
        for(int c = 1; c<dp.length; c++){
            int max = Integer.MIN_VALUE;
            for(int i = 0; i<n; i++){
                if(wts[i] <= c){
                    int rBagWt = dp[c - wts[i]];
                    if(rBagWt + vals[i] > max){
                        max = rBagWt + vals[i];
                    }
                }
            }
            
            dp[c] = max;
        }
        
        System.out.println(dp[cap]);
    }
}
