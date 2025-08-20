import java.util.Scanner;

public class Main{
    public static void display(int[] arr){
        for(int i = 0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
    
    public static void reverse(int[] arr){
        int li = 0;
        int ri = arr.length - 1;
        
        while(li<ri){
            int temp = arr[li];
            arr[li] = arr[ri];
            arr[ri] = temp;
            
            li++;
            ri--;
        }
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
        
        reverse(arr);
        display(arr);
    }
}
