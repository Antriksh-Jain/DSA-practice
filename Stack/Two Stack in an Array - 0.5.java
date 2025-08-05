import java.util.Scanner;

public class Main{
    public static class TwoStack {
        int[] data;
        int tos1;
        int tos2;
        
        public TwoStack(int cap){
            data = new int[cap];
            tos1 = 0;
            tos2 = 0;
        }
        
        int size1(){
            return tos1;
        }
        
        int size2(){
            return tos2;
        }
        
        void push1(int val){
            if(size1() + size2() == data.length){
                System.out.println("Stack Overflow");
            } else {
                data[tos1] = val;
                tos1++;
            }
        }
        
        void push2(int val){
            if(size1() + size2() == data.length){
                System.out.println("Stack Overflow");
            } else {
                int idx = (data.length-1) - tos2;
                data[idx] = val;
                tos2++;
            }
        }
        
        int pop1(){
            if(size1() == 0){
                System.out.println("Stack Underflow");
                return -1;
            } else {
                tos1--;
                return data[tos1];
            }
        }
        
        int pop2(){
            if(size2() == 0){
                System.out.println("Stack Underflow");
                return -1;
            } else {
                tos2--;
                int idx = (data.length-1) - tos2;
                return data[idx];
            }
        }
        
        int top1(){
            if(size1() == 0){
                System.out.println("Stack Underflow");
                return -1;
            } else {
                return data[tos1-1];
            }
        }
        
        int top2(){
            if(size2() == 0){
                System.out.println("Stack Underflow");
                return -1;
            } else {
                int idx = data.length - tos2;
                return data[idx];
            }
        }
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        scn.nextLine();
        
        TwoStack ts = new TwoStack(n);
        
        String str = scn.nextLine();
        while(str.equals("exit")==false){
            if(str.equals("size1")){
                System.out.println(ts.size1());
            } else if(str.startsWith("push1")){
                int val = Integer.parseInt(str.split(" ")[1]);
                ts.push1(val);
            } else if(str.equals("pop1")){
                System.out.println(ts.pop1());
            } else if(str.equals("top1")){
                System.out.println(ts.top1());
            } else if(str.equals("size2")){
                System.out.println(ts.size2());
            } else if(str.startsWith("push2")){
                int val = Integer.parseInt(str.split(" ")[1]);
                ts.push2(val);
            } else if(str.equals("pop2")){
                System.out.println(ts.pop2());
            } else if(str.equals("top2")){
                System.out.println(ts.top2());
            }
            
            str = scn.nextLine();
        }
    }
}
