import java.util.*;

public class Main{
    public static class LLToQueueAdapter{
        LinkedList<Integer> list;
        
        LLToQueueAdapter(){
            list = new LinkedList<>();
        }
        
        int size(){
            return list.size();
        }
        
        void add(int val){
            list.addLast(val);
        }
        
        int remove(){
            if(size()==0){
                System.out.println("Queue underflow");
                return -1;
            } else {
                return list.removeFirst();
            }
        }
        
        int peek(){
            if(size()==0){
                System.out.println("Queue underflow");
                return -1;
            } else {
                return list.getFirst();
            }
        }
    }
    
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        LLToQueueAdapter st = new LLToQueueAdapter();
        
        String str = scn.nextLine();
        while(str.equals("exit") == false){
            if(str.equals("size")){
                System.out.println(st.size());
            } else if(str.equals("remove")){
                System.out.println(st.remove());
            } else if(str.startsWith("add")){
                int val = Integer.parseInt(str.split(" ")[1]);
                st.add(val);
            } else if(str.equals("peek")){
                System.out.println(st.peek());
            }
            str = scn.nextLine();
        }
    }
}
