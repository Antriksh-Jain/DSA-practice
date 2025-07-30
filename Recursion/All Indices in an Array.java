import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        scn.nextLine();
        String str = scn.nextLine();
        int[] arr = new int[n];
        for(int i = 0; i<n; i++){
            int val = Integer.parseInt(str.split(" ")[i]);
            arr[i] = val;
        }
        
        int d = scn.nextInt();
        
        int[] iArr = allIndices(arr, d, 0, 0);
        if(iArr.length == 0){
            System.out.println();
        } else {
            for(int i : iArr){
                System.out.println(i);
            }
        }
        
    }
    
    static int[] allIndices(int[] arr, int x, int idx, int fsf){
        if(idx == arr.length){
            return new int[fsf];
        }
        
        if(arr[idx] == x){
            int[] iArr = allIndices(arr, x, idx+1, fsf+1);
            iArr[fsf] = idx;
            return iArr;
        } else {
            int[] iArr = allIndices(arr, x, idx+1, fsf);
            return iArr;
        }
    }
}
