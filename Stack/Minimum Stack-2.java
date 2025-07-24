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
                data.push(val);
                min = val;
            } else if(val>=min){
                data.push(val);
            } else {
                data.push(val+val-min);
                min = val;
            }
        }
        
        int top(){
            if(size()==0){
                System.out.println("Stack Underflow");
                return -1;
            } else {
                if(data.peek() >= min){
                    return data.peek();
                } else {
                    return min;
                }
            }
        }
        
        int pop(){
            if(size()==0){
                System.out.println("Stack Underflow");
                return -1;
            } else {
                if(data.peek() >= min){
                    return data.pop();
                } else {
                    int ov = min;
                    min = 2 * min - data.pop();
                    return ov;
                }
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
