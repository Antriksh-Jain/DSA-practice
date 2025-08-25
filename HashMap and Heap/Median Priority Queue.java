import java.util.*;

public class Main{
    public static class MedianPriorityQueue{
        PriorityQueue<Integer> left;
        PriorityQueue<Integer> right;
        
        MedianPriorityQueue(){
            left = new PriorityQueue<>(Collections.reverseOrder());
            right = new PriorityQueue<>();
        }
        
        public void add(int val){
            if(right.size() > 0 && val > right.peek()){
                right.add(val);
            } else {
                left.add(val);
            }
            
            if(left.size() - right.size() == 2){
                right.add(left.remove());
            } else if(right.size() - left.size() == 2){
                left.add(right.remove());
            }
        }
        
        public int remove(){
            if(this.size() == 0){
                System.out.println("Underflow");
                return -1;
            } else if(left.size() >= right.size()){
                return left.remove();
            } else {
                return right.remove();
            }
        }
        
        public int peek(){
            if(this.size() == 0){
                System.out.println("Underflow");
                return -1;
            } else if(left.size() >= right.size()){
                return left.peek();
            } else {
                return right.peek();
            }
        }
        
        public int size(){
            return left.size() + right.size();
        }
    }
    
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        MedianPriorityQueue mpq = new MedianPriorityQueue();
        
        String str = scn.nextLine();
        while(str.equals("exit") == false){
            if(str.startsWith("add")){
                int val = Integer.parseInt(str.split(" ")[1]);
                mpq.add(val);
            } else if(str.equals("remove")){
                System.out.println(mpq.remove());
            } else if(str.equals("peek")){
                System.out.println(mpq.peek());
            } else if(str.equals("size")){
                System.out.println(mpq.size());
            }
            
            str = scn.nextLine();
        }
    }
}
