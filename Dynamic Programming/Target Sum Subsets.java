import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        int[] arr = new int[n];
        scn.nextLine();
        String str = scn.nextLine();
        
        for(int i = 0; i < arr.length; i++){
            arr[i] = Integer.parseInt(str.split(" ")[i]);
        }
        
        int tar = scn.nextInt();
        
        boolean[][] dp = new boolean[n + 1][tar + 1];
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                if(i == 0 && j == 0){
                    dp[i][j] = true;
                } else if(i == 0){
                    dp[i][j] = false;
                } else if(j == 0){
                    dp[i][j] = true;
                } else {
                    if(dp[i - 1][j] == true || (arr[i - 1] <= j && dp[i - 1][j - arr[i-1]] == true)){
                        dp[i][j] = true;
                    }
                }
            }
        }
        
        System.out.println(dp[arr.length][tar]);
    }
}
