import java.util.*;

public class Main{
    public static void sort012(int[] arr){
        int i = 0;
        int j = 0;
        int k = arr.length - 1;
        
        while(i <= k){
            if(arr[i] == 1){
                i++;
            } else if(arr[i] == 0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                
                i++;
                j++;
            } else if(arr[i] == 2){
                int temp = arr[i];
                arr[i] = arr[k];
                arr[k] = temp;
                
                k--;
            }
        }
    }
    
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < arr.length; i++){
            arr[i] = scn.nextInt();
        }
        
        sort012(arr);
        
        for(int val: arr){
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
