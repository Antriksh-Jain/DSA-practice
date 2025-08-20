import java.util.Scanner;

public class Main{
    public static void subArray(int[] arr){
        for(int i = 0; i<arr.length; i++){
            String str = "";
            for(int j = i; j<arr.length; j++){
                str += arr[j] + " ";
                System.out.println(str);
            }
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
        
        subArray(arr);
    }
}
