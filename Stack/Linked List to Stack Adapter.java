import java.util.*;

public class Main{
    public static class LLToStackAdapter{
        LinkedList<Integer> list;
        
        LLToStackAdapter(){
            list = new LinkedList<>();
        }
        
        int size(){
            return list.size();
        }
        
        void push(int val){
            list.addFirst(val);
        }
        
        int pop(){
            if(size()==0){
                System.out.println("Stack underflow");
                return -1;
            } else {
                return list.removeFirst();
            }
        }
        
        int top(){
            if(size()==0){
                System.out.println("Stack underflow");
                return -1;
            } else {
                return list.getFirst();
            }
        }
    }
    
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        LLToStackAdapter st = new LLToStackAdapter();
        
        String str = scn.nextLine();
        while(str.equals("exit") == false){
            if(str.equals("size")){
                System.out.println(st.size());
            } else if(str.equals("pop")){
                System.out.println(st.pop());
            } else if(str.startsWith("push")){
                int val = Integer.parseInt(str.split(" ")[1]);
                st.push(val);
            } else if(str.equals("top")){
                System.out.println(st.top());
            }
            str = scn.nextLine();
        }
    }
}
