import java.util.*;

public class Main{
    public static class Pair implements Comparable<Pair>{
        int li;
        int di;
        int val;
        
        Pair(int li, int di, int val){
            this.li = li;
            this.di = di;
            this.val = val;
        }
        
        public int compareTo(Pair o){
            return this.val - o.val;
        }
    }
    
    public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> list){
        ArrayList<Integer> rv = new ArrayList<>();
        
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int i = 0; i<list.size(); i++){
            Pair p = new Pair(i, 0, list.get(i).get(0));
            pq.add(p);
        }
        
        while(pq.size() > 0){
            Pair p = pq.remove();
            rv.add(p.val);
            p.di++;
            
            if(p.di < list.get(p.li).size()){
                p.val = list.get(p.li).get(p.di);
                pq.add(p);
            }
        }
        
        return rv;
    }
    
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int n = scn.nextInt();
        for(int i = 0; i<n; i++){
            ArrayList<Integer> data = new ArrayList<>();
            int k = scn.nextInt();
            scn.nextLine();
            String str = scn.nextLine();
            for(int j = 0; j<k; j++){
                int val = Integer.parseInt(str.split(" ")[j]);
                data.add(val);
            }
            
            list.add(data);
        }
        
        ArrayList<Integer> val = mergeKSortedLists(list);
        for(int i: val){
            System.out.println(i);
        }
    }
}
