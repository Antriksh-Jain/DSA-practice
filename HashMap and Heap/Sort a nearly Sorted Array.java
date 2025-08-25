import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        int[] arr = new int[n];
        scn.nextLine();
        String str = scn.nextLine();
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(str.split(" ")[i]);
        }
        
        int k = scn.nextInt();
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i<=k; i++){
            pq.add(arr[i]);
        }
        
        for(int i = k+1; i<arr.length; i++){
            System.out.println(pq.remove());
            pq.add(arr[i]);
        }
        
        while(pq.size() > 0){
            System.out.println(pq.remove());
        }
    }
}
