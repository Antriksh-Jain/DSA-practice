import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        
        int[] arr = new int[n];
        
        for(int i = 0; i<arr.length; i++){
            arr[i] = scn.nextInt();
        }
        
        int lsf = arr[0];
        int mpt = 0;
        int[] dpl = new int[arr.length];
        
        for(int i = 1; i<arr.length; i++){
            if(arr[i] < lsf){
                lsf = arr[i];
            }
            
            mpt = arr[i] - lsf;
            
            if(mpt > dpl[i - 1]){
                dpl[i] = mpt;
            } else {
                dpl[i] = dpl[i - 1];
            }
        }
        
        int msf = arr[arr.length - 1];
        int mpb = 0;
        int[] dpr = new int[arr.length];
        
        for(int i = arr.length - 2; i >= 0; i--){
            if(arr[i] > msf){
                msf = arr[i];
            }
            
            mpb = msf - arr[i];
            
            if(mpb > dpr[i + 1]){
                dpr[i] = mpb;
            } else {
                dpr[i] = dpr[i + 1];
            }
        }
        
        int op = 0;
        for(int i = 0; i<dpr.length; i++){
            if(dpr[i] + dpl[i] > op){
                op = dpr[i] + dpl[i];
            }
        }
        
        System.out.println(op);
    }
}
