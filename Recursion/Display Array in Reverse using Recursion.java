import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        scn.nextLine();
        String str = scn.nextLine();
        int[] arr = new int[n];
        for(int i = 0; i<n; i++){
            int val = Integer.parseInt(str.split(" ")[i]);
            arr[i] = val;
        }
        displayArrReverse(arr, 0);
    }
    
    static void displayArrReverse(int[] arr, int idx){
        if(idx == arr.length){
            return;
        }
        displayArrReverse(arr, idx+1);
        System.out.println(arr[idx]);
    }
}
