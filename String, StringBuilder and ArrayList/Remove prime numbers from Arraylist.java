import java.util.*;

public class Main{
    public static void removePrime(ArrayList<Integer> al){
        for(int i = al.size() - 1; i >= 0; i--){
            if(isPrime(al.get(i))){
                al.remove(i);
            }
        }
    }
    
    public static boolean isPrime(int n){
        for(int i = 2; i * i <= n; i++){
            if(n % i == 0){
                return false;
            }
        }
        
        return true;
    }
    
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        ArrayList<Integer> al = new ArrayList<>();
        
        int n = scn.nextInt();
        for(int i = 0; i < n; i++){
            al.add(scn.nextInt());
        }
        
        removePrime(al);
        System.out.println(al);
    }
}
