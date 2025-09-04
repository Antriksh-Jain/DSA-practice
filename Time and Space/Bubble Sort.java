import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < arr.length; i++){
            arr[i] = scn.nextInt();
        }
        
        for(int itr = 1; itr < arr.length; itr++){
            for(int j = 0; j < arr.length - itr; j++){
                if(arr[j + 1] < arr[j]){
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        
        for(int val: arr){
            System.out.print(val + " ");
        }
    }
}
