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
            mainStack.push(val);
        }
        
        int remove(){
            if(size() == 0){
                System.out.println("Queue underflow");
                return -1;
            } else {
                while(mainStack.size() > 1){
                    helperStack.push(mainStack.pop());
                }
                int rv = mainStack.pop();
                while(helperStack.size() > 0){
                    mainStack.push(helperStack.pop());
                }
                return rv;
            }
        }
        
        int peek(){
            if(size() == 0){
                System.out.println("Queue underflow");
                return -1;
            } else {
                while(mainStack.size() > 1){
                    helperStack.push(mainStack.pop());
                }
                int rv = mainStack.pop();
                helperStack.push(rv);
                while(helperStack.size() > 0){
                    mainStack.push(helperStack.pop());
                }
                return rv;
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
