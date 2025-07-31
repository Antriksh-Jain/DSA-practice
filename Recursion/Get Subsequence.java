import java.util.Scanner;
import java.util.ArrayList;

public class Main{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        ArrayList<String> res = gss(str);
        System.out.println(res);
    }
    
    static ArrayList<String> gss(String str){
        if(str.length()==0){
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }
        char ch = str.charAt(0);
        String ss = str.substring(1);
        ArrayList<String> rres = gss(ss);
        ArrayList<String> res = new ArrayList<>();
        
        for(String val : rres){
            res.add("" + val);
        }
        for(String val : rres){
            res.add(ch + val);
        }
        return res;
    }
}
