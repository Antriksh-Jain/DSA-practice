import java.util.*;

public class Main{
    public static class HashMap<K, V>{
        private class HMNode{
            K key;
            V value;
            
            HMNode(K key, V value){
                this.key = key;
                this.value = value;
            }
        }
        
        private int size;
        private LinkedList<HMNode>[] buckets;
        
        public HashMap(){
            initbuckets(4);
            size = 0;
        }
        
        private void initbuckets(int N){
            buckets = new LinkedList[N];
            for(int i = 0; i<buckets.length; i++){
                buckets[i] = new LinkedList<>();
            }
        }
        
        public void put(K key, V value){
            int bi = hashfn(key);
            int di = getIndexWithinBucket(key, bi);
            
            if(di != -1){
                HMNode node = buckets[bi].get(di);
                node.value = value;
            } else {
                HMNode node = new HMNode(key, value);
                buckets[bi].add(node);
                size++;
            }
            
            double lambda = size * 1.0 / buckets.length;
            if(lambda > 2.0){
                rehash();
            }
        }
        
        private void rehash(){
            LinkedList<HMNode>[] oldb = buckets;
            size = 0;
            initbuckets(oldb.length * 2);
            for(int i = 0; i<oldb.length; i++){
                for(HMNode node: oldb[i]){
                    put(node.key, node.value);
                }
            }
        }
        
        private int hashfn(K key){
            int hc = key.hashCode();
            return Math.abs(hc) % buckets.length;
        }
        
        private int getIndexWithinBucket(K key, int bi){
            int di = 0;
            for(HMNode node: buckets[bi]){
                if(node.key.equals(key)){
                    return di;
                }
                di++;
            }
            
            return -1;
        }
        
        public V get(K key){
            int bi = hashfn(key);
            int di = getIndexWithinBucket(key, bi);
            
            if(di != -1){
                HMNode node = buckets[bi].get(di);
                return node.value;
            } else {
                return null;
            }
        }
        
        public boolean containsKey(K key){
            int bi = hashfn(key);
            int di = getIndexWithinBucket(key, bi);
            
            if(di != -1){
                return true;
            } else {
                return false;
            }
        }
        
        public V remove(K key){
            int bi = hashfn(key);
            int di = getIndexWithinBucket(key, bi);
            
            if(di != -1){
                HMNode node = buckets[bi].remove(di);
                size--;
                return node.value;
            } else {
                return null;
            }
        }
        
        public ArrayList<K> keySet(){
            ArrayList<K> keys = new ArrayList<>();
            for(int i = 0; i<buckets.length; i++){
                for(HMNode node: buckets[i]){
                    keys.add(node.key);
                }
            }
            return keys;
        }
        
        public int size(){
            return size;
        }
        
        public void display(){
            double lambda = size * 1.0 / buckets.length;
            System.out.println("Buckets: " + buckets.length + " " + lambda);
            for(int i = 0; i<buckets.length; i++){
                System.out.print("Bucket" + i + ": ");
                for(HMNode node: buckets[i]){
                    System.out.print(node.key + "@" + node.value + " ");
                }
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        HashMap<String, Integer> map = new HashMap<>();
        
        String str = scn.nextLine();
        while(str.equals("exit") == false){
            if(str.startsWith("put")){
                String key = str.split(" ")[1];
                int value = Integer.parseInt(str.split(" ")[2]);
                map.put(key, value);
            } else if(str.startsWith("get")){
                String key = str.split(" ")[1];
                System.out.println(map.get(key));
            } else if(str.startsWith("containsKey")){
                String key = str.split(" ")[1];
                System.out.println(map.containsKey(key));
            } else if(str.startsWith("remove")){
                String key = str.split(" ")[1];
                System.out.println(map.remove(key));
            } else if(str.equals("keySet")){
                ArrayList<String> keys = map.keySet();
                for(String key: keys){
                    System.out.print(key + " ");
                }
                System.out.println();
            } else if(str.equals("size")){
                System.out.println(map.size());
            } else if(str.equals("display")){
                map.display();
            }
            
            str = scn.nextLine();
        }
    }
}
