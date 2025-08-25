import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        int[] arr = new int[n];
        scn.nextLine();
        String str = scn.nextLine();
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(str.split(" ")[i]);
        }
        
        HashMap<Integer, Boolean> map = new HashMap<>();
        for(int val: arr){
            map.put(val, true);
        }
        
        for(int val: arr){
            if(map.containsKey(val - 1)){
                //gives us starting point
                map.put(val, false);
            }
        }
        
        int ml = 0;
        int sp = 0;
        for(int val: arr){
            if(map.get(val)){
                int tl = 1;
                int tsp = val;
                
                while(map.containsKey(val + tl)){
                    tl++;
                }
                
                if(ml < tl){
                    ml = tl;
                    sp = tsp;
                }
            }
        }
        
        for(int i = 0; i<ml; i++){
            System.out.println(sp + i);
        }
    }
}
