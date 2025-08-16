import java.util.*;

public class Main{
    public static class Node{
        int data;
        Node left;
        Node right;
        
        Node(int data, Node left, Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
        
        Node(int data){
            this(data, null, null);
        }
    }
    
    public static Node construct(Integer[] arr){
        Node root = new Node(arr[0]);
        Pair rootP = new Pair(root, 1);
        
        Stack<Pair> st = new Stack<>();
        st.push(rootP);
        
        int idx = 0;
        while(st.size() > 0){
            Pair top = st.peek();
            if(top.state == 1){
                idx++;
                if(arr[idx] != null){
                    top.node.left = new Node(arr[idx]);
                    
                    Pair leftP = new Pair(top.node.left, 1);
                    st.push(leftP);
                } else {
                    top.node.left = null;
                }
                
                top.state++;
            } else if(top.state == 2){
                idx++;
                if(arr[idx] != null){
                    top.node.right = new Node(arr[idx]);
                    
                    Pair rightP = new Pair(top.node.right, 1);
                    st.push(rightP);
                } else {
                    top.node.right = null;
                }
                
                top.state++;
            } else {
                st.pop();
            }
        }
        
        return root;
    }
    
    public static class Pair{
        Node node;
        int state;
        
        Pair(Node node, int state){
            this.node = node;
            this.state = state;
        }
    }
    
    public static void display(Node node){
        if(node == null){
            return;
        } else {
            String str = "";
            str += node.left == null? "." : node.left.data + "";
            str += " <- " + node.data + " -> ";
            str += node.right == null? "." : node.right.data + "";
            System.out.println(str);
            
            display(node.left);
            display(node.right);
        }
    }
    
    public static int size(Node node){
        if(node == null){
            return 0;
        }
        int ls = size(node.left);
        int rs = size(node.right);
        int ts = ls + rs + 1;
        return ts;
    }
    
    public static int sum(Node node){
        if(node == null){
            return 0;
        }
        int ls = sum(node.left);
        int rs = sum(node.right);
        int ts = ls + rs + node.data;
        return ts;
    }
    
    public static int max(Node node){
        if(node == null){
            return Integer.MIN_VALUE;
        }
        int lm = max(node.left);
        int rm = max(node.right);
        int tm = Math.max(node.data, Math.max(lm, rm));
        return tm;
    }
    
    public static int height(Node node){
        if(node == null){
            return -1; //-1 in case of edges, 0 for nodes
        }
        int lh = height(node.left);
        int rh = height(node.right);
        int th = Math.max(lh, rh) + 1;
        return th;
    }
    
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        
        Integer[] arr = new Integer[str.split(" ").length];
        
        for(int i = 0; i<arr.length; i++){
            if(str.split(" ")[i].equals("n")){
                arr[i] = null;
            } else {
                arr[i] = Integer.parseInt(str.split(" ")[i]);
            }
        }
        
        Node root = construct(arr);
        
        System.out.println(size(root));
        System.out.println(sum(root));
        System.out.println(max(root));
        System.out.println(height(root));
    }
}
