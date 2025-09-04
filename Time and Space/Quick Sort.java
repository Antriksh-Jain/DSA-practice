import java.util.*;

public class Main{
    public static void quickSort(int[] arr, int lo, int hi){
        if(lo >= hi){
            return;
        }
        
        int pi = partition(arr, arr[hi], lo, hi);
        quickSort(arr, lo, pi - 1);
        quickSort(arr, pi + 1, hi);
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
        
        quickSort(arr, 0, arr.length - 1);
        
        for(int val: arr){
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
