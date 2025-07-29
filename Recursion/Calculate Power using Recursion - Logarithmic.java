import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int x = scn.nextInt();
        int n = scn.nextInt();
        System.out.println(power(x, n));
    }
    
    static int power(int x, int n){
        if(n==0){
            return 1;
        }
        int xnb2 = power(x, n/2);
        int xn = xnb2 * xnb2;
        
        if(n % 2 == 1){
            xn *= x;
        }
        return xn;
    }
}
