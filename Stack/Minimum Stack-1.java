import java.util.Scanner;
import java.util.Stack;
public class Main{
    public static class MinStack{
        Stack<Integer> allData;
        Stack<Integer> minData;
        public MinStack(){
            allData = new Stack<>();
            minData = new Stack<>();
        }
        
        
        void push(int val){
            allData.push(val);
            
            if(minData.size()==0 || val<=minData.peek()){
                minData.push(val);
            }
        }
        
        int top(){
            if(size()==0){
                System.out.println("Stack Underflow");
                return -1;
            } else {
                return allData.peek();
            }
        }
        
        int pop(){
            if(size()==0){
                System.out.println("Stack Underflow");
                return -1;
            } else {
                int val = allData.pop();
                if(val==minData.peek()){
                    minData.pop();
                }
                return val;
            }
        }
        
        int size(){
            return allData.size();
        }
        
        int min(){
            if(size()==0){
                System.out.println("Stack Underflow");
                return -1;
            } else {
                return minData.peek();
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
            }else if(inp.equals("min")){
                System.out.println(ns.min());
            } else {
                System.out.println("Wrong input");
            }
        }
    }
}
