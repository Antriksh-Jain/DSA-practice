import java.util.Scanner;
public class Main{
    public static class MinStack{
        int tos;
        int[] data;
        int min=-1;
        public MinStack(){
            data = new int[1];
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
                int[] temp = new int[data.length*2];
                for(int i=0; i<data.length; i++){
                    int t = data[i];
                    temp[i] = t;
                }
                
                data = temp;
                tos++;
                data[tos] = val;
                if(val<min){
                    min = val;
                }
                
            } else {
                tos++;
                data[tos] = val;
                
                if(tos==0 || val<min){
                    min = val;
                }
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
                if(tos==0){
                    min = -1;
                }
                int v = data[tos];
                tos--;
                return v;
            }
        }
        
        int size(){
            return tos+1;
        }
        
        int min(){
            if(tos==-1){
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
            
            
            
            if(inp.equals("display")){
                ns.display();
            } else if(inp.contains("push")){
                int val = Integer.parseInt(inp.replaceAll("[A-Za-z\\]", ""));
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
