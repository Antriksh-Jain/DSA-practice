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
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            map.put(x[i], rev[i]);
        }
        
        int[] dp = new int[m + 1];
        dp[0] = 0;
        for(int i = 1; i <= m; i++){
            if(map.containsKey(i) == false){
                dp[i] = dp[i - 1];
            } else {
                int boardNotInstalled = dp[i - 1];
                int boardInstalled = map.get(i);
                if(i >= t + 1){
                    boardInstalled += dp[i - t - 1];
                }
                
                dp[i] = Math.max(boardInstalled, boardNotInstalled);
            }
        }
        
        System.out.println(dp[m]);
    }
}
