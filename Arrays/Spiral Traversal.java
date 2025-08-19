import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];
        scn.nextLine();
        for(int i = 0; i<arr.length; i++){
            String str = scn.nextLine();
            for(int j = 0; j<arr[0].length; j++){
                arr[i][j] = Integer.parseInt(str.split(" ")[j]);
            }
        }
        
        int minr = 0;
        int minc = 0;
        int maxr = arr.length - 1;
        int maxc = arr[0].length - 1;
        int tne = n*m;
        int c = 0;
        while(c < tne){
            //left wall
            for(int i = minr, j = minc; i <= maxr && c < tne; i++){
                System.out.println(arr[i][j]);
                c++;
            }
            minc++;
            
            //bottom wall
            for(int i = maxr, j = minc; j <= maxc && c < tne; j++){
                System.out.println(arr[i][j]);
                c++;
            }
            maxr--;
            
            //right wall
            for(int i = maxr, j = maxc; i >= minr && c < tne; i--){
                System.out.println(arr[i][j]);
                c++;
            }
            maxc--;
            
            //top wall
            for(int i = minr, j = maxc; j >= minc && c < tne; j--){
                System.out.println(arr[i][j]);
                c++;
            }
            minr++;
        }
    }
}
