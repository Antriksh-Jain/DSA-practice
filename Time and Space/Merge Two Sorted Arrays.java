import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n1 = scn.nextInt();
        int[] arr1 = new int[n1];
        for(int i = 0; i < arr1.length; i++){
            arr1[i] = scn.nextInt();
        }
        
        int n2 = scn.nextInt();
        int[] arr2 = new int[n2];
        for(int i = 0; i < arr2.length; i++){
            arr2[i] = scn.nextInt();
        }
        
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
        
        for(int val: res){
            System.out.print(val + " ");
        }
    }
}
