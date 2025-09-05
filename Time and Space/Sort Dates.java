import java.util.*;

public class Main{
    public static void sortDates(String[] arr){
        countSort(arr, 1000000, 100, 32); //days
        countSort(arr, 10000, 100, 13); //months
        countSort(arr, 1, 10000, 2026); //years
    }
    
    public static void countSort(String[] arr, int div, int mod, int range){
        int[] farr = new int[range];
        
        for(int i = 0; i < arr.length; i++){
            int idx = Integer.parseInt(arr[i], 10) / div % mod;
            farr[idx]++;
        }
        
        for(int i = 1; i < farr.length; i++){
            farr[i] += farr[i - 1];
        }
        
        String[] ans = new String[arr.length];
        
        for(int i = arr.length - 1; i >= 0; i--){
            int idx = farr[Integer.parseInt(arr[i], 10) / div % mod] - 1;
            ans[idx] = arr[i];
            farr[Integer.parseInt(arr[i], 10) / div % mod]--;
        }
        
        for(int i = 0; i < ans.length; i++){
            arr[i] = ans[i];
        }
    }
    
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        String[] arr = new String[n];
        scn.nextLine();
        for(int i = 0; i < arr.length; i++){
            arr[i] = scn.nextLine();
        }
        
        sortDates(arr);
        
        for(String val: arr){
            System.out.println(val + " ");
        }
        System.out.println();
    }
}
