import java.util.Scanner;
import java.util.ArrayList;

public class Main{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        ArrayList<String> res = getKPC(str);
        System.out.println(res);
    }
    
    static String[] codes = {".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};
    static ArrayList<String> getKPC(String str){
        if(str.length()==0){
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }
        char ch = str.charAt(0);
        int idx = ch - '0';
        String ss = str.substring(1);
        ArrayList<String> rres = getKPC(ss);
        ArrayList<String> res = new ArrayList<>();
        
        for(int i = 0; i<codes[idx].length(); i++){
            char c = codes[idx].charAt(i);
            for(String j : rres){
                res.add(c + j);
            }
        }
        
        return res;
    }
}
