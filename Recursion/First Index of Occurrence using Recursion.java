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
        
        int d = scn.nextInt();
        
        System.out.println(firstIndex(arr, 0, d));
    }
    
    static int firstIndex(int[] arr, int idx, int x){
        if(idx == arr.length){
            return -1;
        }
        
        if(arr[idx] == x){
            return idx;
        } else {
            int fisa = firstIndex(arr, idx+1, x);
            return fisa;
        }
    }
}
