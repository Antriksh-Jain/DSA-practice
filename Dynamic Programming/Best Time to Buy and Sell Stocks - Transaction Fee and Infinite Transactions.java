import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        
        int[] prices = new int[n];
        for(int i = 0; i<prices.length; i++){
            prices[i] = scn.nextInt();
        }
        
        int fee = scn.nextInt();
        
        int bsp = -prices[0];
        int ssp = 0;
        
        for(int i = 1; i < prices.length; i++){
            int nbsp = 0;
            int nssp = 0;
            
            if(ssp - prices[i] > bsp){
                nbsp = ssp - prices[i];
            } else {
                nbsp = bsp;
            }
            
            if(bsp + prices[i] - fee > ssp){
                nssp = bsp + prices[i] - fee;
            } else {
                nssp = ssp;
            }
            
            bsp = nbsp;
            ssp = nssp;
        }
        
        System.out.println(ssp);
    }
}
