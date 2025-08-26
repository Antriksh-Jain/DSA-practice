import java.util.*;

public class Main{
    public static class PriorityQueue{
        ArrayList<Integer> data;
        
        PriorityQueue(){
            data = new ArrayList<>();
        }
        
        public void add(int val){
            data.add(val);
            upheafiy(data.size() - 1);
        }
        
        private void upheafiy(int i){
            int pi = (i - 1 ) / 2;
            if(data.get(i) < data.get(pi)){
                swap(i, pi);
            }
        }
        
        private void swap(int i, int j){
            int ith = data.get(i);
            int jth = data.get(j);
            data.set(j, ith);
            data.set(i, jth);
        }
        
        public int remove(){
            if(this.size() == 0){
                System.out.println("Underflow");
                return -1;
            } else {
                swap(0, data.size() - 1);
                int val = data.remove(data.size() - 1);
                downheapify(0);
                return val;
            }
        }
        
        private void downheapify(int pi){
            int mini = pi;
            int li = pi * 2 + 1;
            if(li < data.size() && data.get(mini) > data.get(li)){
                swap(pi, li);
                mini = li;
            }
            
            int ri = pi * 2 + 2;
            if(ri < data.size() && data.get(mini) > data.get(ri)){
                swap(pi, ri);
                mini = ri;
            }
            
            if(mini != pi){
                swap(pi, mini);
                downheapify(mini);
            }
        }
        
        public int peek(){
            if(this.size() == 0){
                System.out.println("Underflow");
                return -1;
            } else {
                return data.get(0);
            }
        }
        
        public int size(){
            return data.size();
        }
    }
    
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        PriorityQueue pq = new PriorityQueue();
        
        String str = scn.nextLine();
        while(str.equals("exit") == false){
            if(str.startsWith("add")){
                int val = Integer.parseInt(str.split(" ")[1]);
                pq.add(val);
            } else if(str.equals("remove")){
                System.out.println(pq.remove());
            } else if(str.equals("peek")){
                System.out.println(pq.peek());
            } else if(str.equals("size")){
                System.out.println(pq.size());
            }
            
            str = scn.nextLine();
        }
    }
}
