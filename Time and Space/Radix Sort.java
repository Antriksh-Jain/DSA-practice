import java.util.*;

public class Main{
    public static void radixSort(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int val: arr){
            max = Math.max(max, val);
        }
        
        int exp = 1;
        while(exp <= max){
            countSort(arr, exp);
            exp *= 10;
        }
    }
    
    public static void countSort(int[] arr, int exp){
        int[] farr = new int[10];
        
        for(int i = 0; i < arr.length; i++){
            int idx = arr[i] / exp % 10;
            farr[idx]++;
        }
        
        for(int i = 1; i < farr.length; i++){
            farr[i] += farr[i - 1];
        }
        
        int[] ans = new int[arr.length];
        
        for(int i = arr.length - 1; i >= 0; i--){
            int idx = farr[arr[i] / exp % 10] - 1;
            ans[idx] = arr[i];
            farr[arr[i] / exp % 10]--;
        }
        
        for(int i = 0; i < ans.length; i++){
            arr[i] = ans[i];
        }
    }
    
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < arr.length; i++){
            arr[i] = scn.nextInt();
        }
        
        radixSort(arr);
        
        for(int val: arr){
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
