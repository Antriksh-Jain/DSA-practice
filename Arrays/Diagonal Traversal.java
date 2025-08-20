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
        
        for(int g = 0; g<arr.length; g++){
            for(int i = 0, j = g; j < arr.length; i++, j++){
                System.out.println(arr[i][j]);
            }
        }
    }
}
