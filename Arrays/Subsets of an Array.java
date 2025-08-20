import java.util.Scanner;

public class Main{
    public static void subSets(int[] arr){
        int limit = (int) Math.pow(2, arr.length);
        
        for(int i = 0; i<limit; i++){
            String set = "";
            int temp = i;
            
            for(int j = arr.length-1; j>=0; j--){
                int r = temp % 2;
                temp = temp / 2;
                
                if(r == 0){
                    set = "- " + set;
                } else {
                    set = arr[j] + " " + set;
                }
            }
            
            System.out.println(set);
        }
    }
    
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        int[] arr = new int[n];
        scn.nextLine();
        String str = scn.nextLine();
        for(int i = 0; i<arr.length; i++){
            arr[i] = Integer.parseInt(str.split(" ")[i]);
        }
        
        subSets(arr);
    }
}
