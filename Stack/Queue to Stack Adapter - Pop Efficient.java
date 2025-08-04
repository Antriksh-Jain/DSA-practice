import java.util.Scanner;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main{
    public static class QueueToStackAdapter{
        Queue<Integer> mainQueue;
        Queue<Integer> helperQueue;
        
        QueueToStackAdapter(){
            mainQueue = new ArrayDeque<>();
            helperQueue = new ArrayDeque<>();
        }
        
        int size(){
            return mainQueue.size();
        }
        
        void push(int val){
            while(mainQueue.size() > 0){
                helperQueue.add(mainQueue.remove());
            }
            mainQueue.add(val);
            while(helperQueue.size() > 0){
                mainQueue.add(helperQueue.remove());
            }
        }
        
        int pop(){
            if(size() == 0){
                System.out.println("Stack Underflow");
                return -1;
            } else {
                return mainQueue.remove();
            }
        }
        
        int top(){
            if(size() == 0){
                System.out.println("Stack Underflow");
                return -1;
            } else {
                return mainQueue.peek();
            }
        }
    }
    
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        
        QueueToStackAdapter queue = new QueueToStackAdapter();
        String str = scn.nextLine();
        while(str.equals("exit")==false){
            if(str.equals("size")){
                System.out.println(queue.size());
            } else if(str.startsWith("push")){
                int val = Integer.parseInt(str.split(" ")[1]);
                queue.push(val);
            } else if(str.equals("pop")){
                System.out.println(queue.pop());
            } else if(str.equals("top")){
                System.out.println(queue.top());
            }
            
            str = scn.nextLine();
        }
    }
}
