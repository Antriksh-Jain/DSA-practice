import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < arr.length; i++){
            arr[i] = scn.nextInt();
        }
        
        for(int i = 0; i < arr.length - 1; i++){
            int mi = i;
            
            for(int j = i + 1; j < arr.length; j++){
                if(arr[j] < arr[mi]){
                    mi = j;
                }
            }
            
            int temp = arr[i];
            arr[i] = arr[mi];
            arr[mi] = temp;
        }
        
        for(int val: arr){
            System.out.print(val + " ");
        }
    }
}
