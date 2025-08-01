import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        printKPC(str, "");
    }
    static String[] codes = {".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};
    static void printKPC(String ques, String ans){
        if(ques.length()==0){
            System.out.println(ans);
            return;
        }
        
        char ch = ques.charAt(0);
        int idx = ch - '0';
        String ros = ques.substring(1);
        String codeidx = codes[idx];
        for(int i = 0; i<codeidx.length(); i++){
            char c = codeidx.charAt(i);
            printKPC(ros, ans + c);
        }
    }
}
