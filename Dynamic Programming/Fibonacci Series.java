import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.println(fibMemoized(n, new int[n + 1]));
    }
    
    public static int fib(int n){
        if(n == 0 || n == 1){
            return n;
        }
        
        int fibnm1 = fib(n - 1);
        int fibnm2 = fib(n - 2);
        int fib = fibnm1 + fibnm2;
        
        return fib;
    }
    
    public static int fibMemoized(int n, int[] qb){
        if(n == 0 || n == 1){
            return n;
        }
        
        if(qb[n] != 0){
            return qb[n];
        }
        
        int fibnm1 = fibMemoized(n - 1, qb);
        int fibnm2 = fibMemoized(n - 2, qb);
        int fib = fibnm1 + fibnm2;
        
        qb[n] = fib;
        return fib;
    }
}
