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
    
    static ArrayList<Node> path;
    public static boolean nodeToRootPath(Node node, int data){
        if(node == null){
            return false;
        }
        
        if(node.data == data){
            path.add(node);
            return true;
        }
        
        boolean filc = nodeToRootPath(node.left, data);
        if(filc){
            path.add(node);
            return true;
        }
        
        boolean firc = nodeToRootPath(node.right, data);
        if(firc){
            path.add(node);
            return true;
        }
        
        return false;
    }
    
    public static void printKLevelDown(Node node, int k, Node blocker){
        if(node == null || k<0 || node == blocker){
            return;
        }
        if(k == 0){
            System.out.println(node.data);
        }
        
        printKLevelDown(node.left, k-1, blocker);
        printKLevelDown(node.right, k-1, blocker);
    }
    
    public static void printKNodesFar(Node node, int data, int k){
        path = new ArrayList<>();
        nodeToRootPath(node, data);
        for(int i = 0; i<path.size(); i++){
            printKLevelDown(path.get(i), k - i, i==0? null: path.get(i-1));
        }
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
        int data = scn.nextInt();
        int k = scn.nextInt();
        
        Node root = construct(arr);
        
        printKNodesFar(root, data, k);
    }
}
