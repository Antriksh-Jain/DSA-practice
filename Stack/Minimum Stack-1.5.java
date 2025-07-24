import java.util.Scanner;
import java.util.Stack;
public class Main{
    public static class MinStack{
        Stack<Integer> data;
        int min;
        public MinStack(){
            data = new Stack<>();
        }
        
        
        void push(int val){
            if(data.size()==0){
                min = val;
            }
            data.push(val);
            
            if(min>data.peek()){
                min = data.peek();
            }
        }
        
        int top(){
            if(size()==0){
                System.out.println("Stack Underflow");
                return -1;
            } else {
                return data.peek();
            }
        }
        
        int pop(){
            if(size()==0){
                System.out.println("Stack Underflow");
                return -1;
            } else {
                int val = data.pop();
                if(val==min && size()!=0){
                    min = data.peek();
                }
                return val;
            }
        }
        
        int size(){
            return data.size();
        }
        
        int min(){
            if(size()==0){
                System.out.println("Stack Underflow");
                return -1;
            } else {
                return min;
            }
        }
    }
    
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        //int n = scn.nextInt();
        //scn.nextLine();
        
        MinStack ns = new MinStack();
        while(true){
            
            String inp = scn.nextLine();
            
            
            
            if(inp.contains("push")){
                int val = Integer.parseInt(inp.replaceAll("[A-Za-z\\s]", ""));
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
            }else if(inp.equals("min")){
                System.out.println(ns.min());
            } else {
                System.out.println("Wrong input");
            }
        }
    }
}
