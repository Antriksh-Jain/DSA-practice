import java.util.*;

public class Main{
    public static void countSort(int[] arr, int min, int max){
        int range = max - min + 1;
        int[] farr = new int[range];
        
        for(int i = 0; i < arr.length; i++){
            int idx = arr[i] - min;
            farr[idx]++;
        }
        
        for(int i = 1; i < farr.length; i++){
            farr[i] += farr[i - 1];
        }
        
        int[] ans = new int[arr.length];
        
        for(int i = arr.length - 1; i >= 0; i--){
            int idx = farr[arr[i] - min] - 1;
            ans[idx] = arr[i];
            farr[arr[i] - min]--;
        }
        
        for(int i = 0; i < ans.length; i++){
            arr[i] = ans[i];
        }
    }
    
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        int[] arr = new int[n];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length; i++){
            arr[i] = scn.nextInt();
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        
        countSort(arr, min, max);
        
        for(int val: arr){
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
