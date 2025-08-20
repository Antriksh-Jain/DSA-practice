import java.util.Scanner;

public class Main{
    public static void display(int[] arr){
        for(int i = 0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
    
    public static void reverse(int[] arr, int li, int ri){
        while(li<ri){
            int temp = arr[li];
            arr[li] = arr[ri];
            arr[ri] = temp;
            
            li++;
            ri--;
        }
    }
    
    public static void rotate(int[] arr, int r){
        r = r % arr.length;
        if(r < 0){
            r += arr.length;
        }
        
        reverse(arr, 0, arr.length - r -1);
        reverse(arr, arr.length - r, arr.length - 1);
        reverse(arr, 0, arr.length - 1);
    }
    
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        int[] arr = new int[n];
        scn.nextLine();
        String str = scn.nextLine();
        for(int i = 0; i<arr.length; i++){
            arr[i] = Integer.parseInt(str.split(" ")[i]);
        }
        int r = scn.nextInt();
        
        rotate(arr, r);
        display(arr);
    }
}
