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
        int ceil = Integer.MAX_VALUE;
        int floor = Integer.MIN_VALUE;
        while(l<=h){
            int m = (l + h) / 2;
            
            if(arr[m] > data){
                h = m - 1;
                ceil = arr[m];
            } else if(arr[m] < data){
                l = m + 1;
                floor = arr[m];
            } else {
                ceil = arr[m];
                floor = arr[m];
                break;
            }
        }
        
        System.out.println("Ceil: " + ceil);
        System.out.println("Floor: " + floor);
    }
}
