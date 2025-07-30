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
        System.out.println(maxOfArray(arr, 0));
    }
    
    static int maxOfArray(int[] arr, int idx){
        if(idx == arr.length - 1){
            return arr[idx];
        }
        int ip1m = maxOfArray(arr, idx+1);
        int i = arr[idx];
        return Math.max(i, ip1m);
    }
}
