import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        
        int[] prices = new int[n];
        for(int i = 0; i<prices.length; i++){
            prices[i] = scn.nextInt();
        }
        
        int lsf = Integer.MAX_VALUE;
        int op = 0;
        int pt = 0;
        
        for(int i = 0; i<prices.length; i++){
            if(prices[i] < lsf){
                lsf = prices[i];
            }
            
            pt = prices[i] - lsf;
            
            if(pt > op){
                op = pt;
            }
        }
        
        System.out.println(op);
    }
}
