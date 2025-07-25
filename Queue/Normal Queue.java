import java.util.Scanner;
import java.util.Queue;
import java.util.ArrayDeque;

public class Main{
    
    public static class NormalQueue{
        int[] data;
        int front;
        int size;
        
        NormalQueue(int cap){
            data = new int[cap];
            front = 0;
            size = 0;
        }
        
        void add(int val){
            if(size()==data.length){
                System.out.println("Queue Overflow");
            } else {
                int rear = (front + size)%data.length;
                data[rear] = val;
                size++;
            }
        }
        
        int remove(){
            if(size()==0){
                System.out.println("Queue Underflow");
                return -1;
            } else {
                int v = data[front];
                front = (front+1)%data.length;
                size--;
                return v;
            }
        }
        
        int peek(){
            if(size()==0){
                System.out.println("Queue Underflow");
                return -1;
            } else {
                return data[front];
            }
        }
        
        int size(){
            return size;
        }
        
        void display(){
            for(int i = 0; i<size(); i++){
                int v = (front+i)%data.length;
                System.out.print(data[v] + " ");
            }
            System.out.println();
        }
        int front(){
            return front;
        }
    }
    
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        scn.nextLine();
        
        NormalQueue q = new NormalQueue(n);
        
        String str = scn.nextLine();
        while(str.toLowerCase().equals("exit")==false){
            if(str.startsWith("add")){
                int val = Integer.parseInt(str.split(" ")[1]);
                q.add(val);
            } else if(str.equals("remove")){
                System.out.println(q.remove());
            } else if(str.equals("peek")){
                System.out.println(q.peek());
            } else if(str.equals("size")){
                System.out.println(q.size());
            } else if(str.equals("display")){
                q.display();
            } else if(str.equals("front")){
                System.out.println(q.front());
            }
            
            str = scn.nextLine();
        }
    }
}
