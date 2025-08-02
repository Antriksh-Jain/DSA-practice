import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        scn.nextLine();
        int[] arr = new int[n];
        String an = scn.nextLine();
        for(int i = 0; i<arr.length; i++){
            int val = Integer.parseInt(an.split(" ")[i]);
            arr[i] = val;
        }
        
        int tar = scn.nextInt();
        printTargetSumSubsets(arr, 0, "", 0, tar);
    }
    
    static void printTargetSumSubsets(int[] arr, int idx, String set, int sos, int tar){
        if(idx == arr.length){
            if(sos == tar){
                System.out.println(set + ".");
            }
            return;
        }
        
        printTargetSumSubsets(arr, idx + 1, set + arr[idx] + ", ", sos + arr[idx], tar);
        printTargetSumSubsets(arr, idx + 1, set, sos, tar);
    }
}
