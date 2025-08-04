import java.util.Scanner;
import java.util.Stack;

public class Main{
    public static class StackToQueueAdapter{
        Stack<Integer> mainStack;
        Stack<Integer> helperStack;
        
        StackToQueueAdapter(){
            mainStack = new Stack<>();
            helperStack = new Stack<>();
        }
        
        int size(){
            return mainStack.size();
        }
        
        void add(int val){
            while(mainStack.size() > 0){
                helperStack.push(mainStack.pop());
            }
            
            mainStack.push(val);
            
            while(helperStack.size() > 0){
                mainStack.push(helperStack.pop());
            }
        }
        
        int remove(){
            if(size()==0){
                System.out.println("Queue Underflow");
                return -1;
            } else {
                return mainStack.pop();
            }
        }
        
        int peek(){
            if(size()==0){
                System.out.println("Queue Underflow");
                return -1;
            } else {
                return mainStack.peek();
            }
        }
    }
    
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        
        StackToQueueAdapter stack = new StackToQueueAdapter();
        String str = scn.nextLine();
        while(str.equals("exit")==false){
            if(str.equals("size")){
                System.out.println(stack.size());
            } else if(str.startsWith("add")){
                int val = Integer.parseInt(str.split(" ")[1]);
                stack.add(val);
            } else if(str.equals("remove")){
                System.out.println(stack.remove());
            } else if(str.equals("peek")){
                System.out.println(stack.peek());
            }
            
            str = scn.nextLine();
        }
    }
}
