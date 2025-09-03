import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        
        int[] prices = new int[n];
        for(int i = 0; i<prices.length; i++){
            prices[i] = scn.nextInt();
        }
        
        int bsp = -prices[0];
        int ssp = 0;
        int csp = 0;
        
        for(int i = 1; i<prices.length; i++){
            int nbsp = 0;
            int nssp = 0;
            int ncsp = 0;
            
            if(csp - prices[i] > bsp){
                nbsp = csp - prices[i];
            } else {
                nbsp = bsp;
            }
            
            if(bsp + prices[i] > ssp){
                nssp = bsp + prices[i];
            } else {
                nssp = ssp;
            }
            
            if(ssp > csp){
                ncsp = ssp;
            } else {
                ncsp = csp;
            }
            
            bsp = nbsp;
            ssp = nssp;
            csp = ncsp;
        }
        
        System.out.println(ssp);
    }
}
