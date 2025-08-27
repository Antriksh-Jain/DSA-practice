import java.util.*;

public class Main{
    public static class PriorityQueue{
        ArrayList<Integer> data;
        
        PriorityQueue(int[] arr){
            data = new ArrayList<>();
            
            for(int val: arr){
                data.add(val);
            }
            
            for(int i = data.size() / 2 - 1; i>=0; i--){
                downheapify(i);
            }
        }
        
        public void add(int val){
            data.add(val);
            upheafiy(data.size() - 1);
        }
        
        private void upheafiy(int i){
            if(i == 0){
                return;
            }
            
            int pi = (i - 1 ) / 2;
            if(data.get(i) < data.get(pi)){
                swap(i, pi);
                upheafiy(pi);
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
                mini = li;
            }
            
            int ri = pi * 2 + 2;
            if(ri < data.size() && data.get(mini) > data.get(ri)){
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
        int[] arr = {2, 34, 23, 5, 31, 44, 12, 6, 99, 54, 11, 19};
        PriorityQueue pq = new PriorityQueue(arr);
        
        while(pq.size() > 0){
            System.out.println(pq.remove());
        }
    }
}
