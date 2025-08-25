import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        
        int n1 = scn.nextInt();
        int[] arr1 = new int[n1];
        scn.nextLine();
        String str1 = scn.nextLine();
        for(int i = 0; i<n1; i++){
            arr1[i] = Integer.parseInt(str1.split(" ")[i]);
        }
        
        int n2 = scn.nextInt();
        int[] arr2 = new int[n2];
        scn.nextLine();
        String str2 = scn.nextLine();
        for(int i = 0; i<n2; i++){
            arr2[i] = Integer.parseInt(str2.split(" ")[i]);
        }
        
        HashMap<Integer, Integer> fmap = new HashMap<>();
        for(int val: arr1){
            if(fmap.containsKey(val)){
                fmap.put(val, fmap.get(val) + 1);
            } else {
                fmap.put(val, 1);
            }
        }
        
        for(int val: arr2){
            if(fmap.containsKey(val)){
                System.out.println(val);
                fmap.remove(val);
            }
        }
    }
}
