import java.util.*;

public class Main{
    public static int[] mergeSort(int[] arr, int lo, int hi){
        if(lo == hi){
            int[] ba = new int[1];
            ba[0] = arr[lo];
            return ba;
        }
        
        int mid = (lo + hi) / 2;
        int[] fsh = mergeSort(arr, lo, mid);
        int[] ssh = mergeSort(arr, mid + 1, hi);
        int[] fsa = mergeTwoSortedArrays(fsh, ssh);
        
        return fsa;
    }
    
    public static int[] mergeTwoSortedArrays(int[] arr1, int[] arr2){
        int[] res = new int[arr1.length + arr2.length];
        
        int i = 0;
        int j = 0;
        int k = 0;
        
        while(i < arr1.length && j < arr2.length){
            if(arr1[i] < arr2[j]){
                res[k] = arr1[i];
                i++;
                k++;
            } else if(arr2[j] < arr1[i]){
                res[k] = arr2[j];
                j++;
                k++;
            }
        }
        
        while(i < arr1.length){
            res[k] = arr1[i];
            i++;
            k++;
        }
        
        while(j < arr2.length){
            res[k] = arr2[j];
            j++;
            k++;
        }
        
        return res;
    }
    
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < arr.length; i++){
            arr[i] = scn.nextInt();
        }
        
        int[] sortedArray = mergeSort(arr, 0, arr.length - 1);
        
        for(int val: sortedArray){
            System.out.print(val + " ");
        }
    }
}
