import java.util.*;

public class Main{
    public static int quickSelect(int[] arr, int lo, int hi, int k){
        int pivot = arr[hi];
        int pi = partition(arr, pivot, lo, hi);
        
        if(k > pi){
            return quickSelect(arr, pi + 1, hi, k);
        } else if(k < pi){
            return quickSelect(arr, lo, pi - 1, k);
        } else {
            return pivot;
        }
    }
    
    public static int partition(int[] arr, int pivot, int lo, int hi){
        int i = lo, j = lo;
        
        while(i < arr.length){
            if(arr[i] > pivot){
                i++;
            } else {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                
                i++;
                j++;
            }
        }
        
        //index of pivot in the array
        return j - 1;
    }
    
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < arr.length; i++){
            arr[i] = scn.nextInt();
        }
        
        int k = scn.nextInt();
        
        System.out.println(quickSelect(arr, 0, arr.length - 1, k - 1));
    }
}
