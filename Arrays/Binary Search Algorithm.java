import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        int[] arr = new int[n];
        scn.nextLine();
        String str = scn.nextLine();
        for(int i = 0; i<arr.length; i++){
            arr[i] = Integer.parseInt(str.split(" ")[i]);
        }
        int data = scn.nextInt();
        
        int l = 0;
        int h = arr.length - 1;
        while(l<=h){
            int m = (l + h) / 2;
            
            if(arr[m] > data){
                h = m - 1;
            } else if(arr[m] < data){
                l = m + 1;
            } else {
                System.out.println(m);
                return;
            }
        }
        
        System.out.println("Not Found");
    }
}
