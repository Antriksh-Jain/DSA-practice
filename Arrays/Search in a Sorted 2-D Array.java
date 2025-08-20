import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        int[][] arr = new int[n][n];
        scn.nextLine();
        for(int i = 0; i<arr.length; i++){
            String str = scn.nextLine();
            for(int j = 0; j<arr.length; j++){
                arr[i][j] = Integer.parseInt(str.split(" ")[j]);
            }
        }
        int x = scn.nextInt();
        
        int i = 0;
        int j = arr[0].length - 1;
        while(i<arr.length && j>=0){
            if(arr[i][j] == x){
                System.out.println(i + ", " + j);
                return;
            } else if(arr[i][j] < x){
                i++;
            } else {
                j--;
            }
        }
        
        System.out.println("Not Found");
    }
}
