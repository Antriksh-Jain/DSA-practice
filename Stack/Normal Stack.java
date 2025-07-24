import java.util.Scanner;
public class Main{
    public static class NormalStack{
        int tos;
        int[] data;
        
        public NormalStack(int n){
            data = new int[n];
            tos=-1;
        }
        
        void display(){
            for(int i = tos; i>=0; i--){
                System.out.print(data[i] + " ");
            }
            System.out.println();
        }
        
        void push(int val){
            if(tos==data.length-1){
                System.out.println("Stack Overflow");
            } else {
                tos++;
                data[tos] = val;
            }
        }
        
        int top(){
            if(tos==-1){
                System.out.println("Stack Underflow");
                return -1;
            } else {
                int v = data[tos];
                return v;
            }
        }
        
        int pop(){
            if(tos==-1){
                System.out.println("Stack Underflow");
                return -1;
            } else {
                int v = data[tos];
                tos--;
                return v;
            }
        }
        
        int size(){
            return tos+1;
        }
    }
    
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        scn.nextLine();
        
        NormalStack ns = new NormalStack(n);
        while(true){
            
            String inp = scn.nextLine();
            
            
            
            if(inp.equals("display")){
                ns.display();
            } else if(inp.contains("push")){
                int val = Integer.parseInt(inp.replaceAll("[\\D]", ""));
                ns.push(val);
            } else if(inp.equals("top")){
                System.out.println(ns.top());
            } else if(inp.equals("pop")){
                //int val = Integer.parseInt(inp.replaceAll("[\\D]", ""));
                System.out.println(ns.pop());
            } else if(inp.equals("size")){
                System.out.println(ns.size());
            } else if(inp.toLowerCase().equals("exit")){
                break;
            } else {
                System.out.println("Wrong input");
            }
        }
    }
}
