import java.util.*;

public class Main{
    public static class GenericTree implements Iterable<Integer>{
        Node root;
        
        GenericTree(Node root){
            this.root = root;
        }
        
        public Iterator<Integer> iterator(){
            Iterator<Integer> obj = new GTPreOrderIterator(root);
            return obj;
        }
    }
    
    public static class GTPreOrderIterator implements Iterator<Integer>{
        Integer nval;
        Stack<Pair> st;
        
        GTPreOrderIterator(Node root){
            st = new Stack<>();
            st.push(new Pair(root, -1));
            next();
        }
        
        public boolean hasNext(){
            if(nval == null){
                return false;
            } else {
                return true;
            }
        }
        
        public Integer next(){
            Integer fr = nval;
            nval = null;
            
            while(st.size() > 0){
                Pair top = st.peek();
                if(top.state == -1){
                    nval = top.node.data;
                    top.state++;
                    break;
                } else if(top.state == top.node.children.size()){
                    st.pop();
                } else {
                    Pair cp = new Pair(top.node.children.get(top.state), -1);
                    st.push(cp);
                    top.state++;
                }
            }
            
            return fr;
        }
    }
    
    public static class Pair{
        Node node;
        int state;
        
        Pair(Node node, int state){
            this.node = node;
            this.state = state;
        }
    }
    
    private static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }
    
    public static void display(Node node){
        String str = node.data + " -> ";
        for(Node child: node.children){
            str += child.data + ", ";
        }
        str += ".";
        System.out.println(str);
        
        for(Node child: node.children){
            display(child);
        }
    }
    
    public static Node construct(int[] arr){
        Node root = null;
        
        Stack<Node> st = new Stack<>();
        
        for(int i = 0; i<arr.length; i++){
            if(arr[i] == -1){
                st.pop();
            } else {
                Node t = new Node();
                t.data = arr[i];
                
                if(st.size() > 0){
                    st.peek().children.add(t);
                } else {
                    root = t;
                }
                
                st.push(t);
            }
        }
        
        return root;
    }
    
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        scn.nextLine();
        int[] arr = new int[n];
        String str = scn.nextLine();
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(str.split(" ")[i]);
        }
        
        Node root = construct(arr);
        
        GenericTree GT = new GenericTree(root);
        
        for(int val: GT){
            System.out.println(val);
        }
        
        Iterator<Integer> gti = GT.iterator();
        while(gti.hasNext()){
            System.out.println(gti.next());
        }
    }
}
