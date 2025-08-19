import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n1 = scn.nextInt();
        int m1 = scn.nextInt();
        int[][] arr1 = new int[n1][m1];
        scn.nextLine();
        for(int i = 0; i<arr1.length; i++){
            String str1 = scn.nextLine();
            for(int j = 0; j<arr1[0].length; j++){
                arr1[i][j] = Integer.parseInt(str1.split(" ")[j]);
            }
        }
        
        int n2 = scn.nextInt();
        int m2 = scn.nextInt();
        int[][] arr2 = new int[n2][m2];
        scn.nextLine();
        for(int i = 0; i<arr2.length; i++){
            String str2 = scn.nextLine();
            for(int j = 0; j<arr2[0].length; j++){
                arr2[i][j] = Integer.parseInt(str2.split(" ")[j]);
            }
        }
        
        if(arr1[0].length != arr2.length){
            System.out.println("Invalid Input");
            return;
        }
        
        int[][] prd = new int[n1][m2];
        for(int i = 0; i<prd.length; i++){
            for(int j = 0; j<prd[0].length; j++){
                for(int k = 0; k<m1; k++){
                    prd[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        
        for(int i = 0; i<prd.length; i++){
            for(int j = 0; j<prd[0].length; j++){
                System.out.print(prd[i][j] + " ");
            }
            System.out.println();
        }
        
    }
}
