import java.util.Scanner;

public class Main{
    public static void display(int[] arr){
        for(int i = 0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
    
    public static int[] inverse(int[] arr){
        int[] inv = new int[arr.length];
        
        for(int i = 0; i<arr.length; i++){
            int v = arr[i];
            inv[v] = i;
        }
        
        return inv;
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
        
        int[] inv = inverse(arr);
        display(inv);
    }
}
