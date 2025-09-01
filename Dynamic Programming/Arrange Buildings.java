import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int cb = 1;
        int cs = 1;
        
        for(int i = 2; i<=n; i++){
            int temp = cb;
            cb = cs;
            cs += temp;
        }
        
        int total = cb + cs;
        total *= total;
        System.out.println(total);
    }
}
