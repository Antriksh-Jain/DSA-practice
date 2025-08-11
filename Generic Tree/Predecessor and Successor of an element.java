import java.util.*;

public class Main{
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
    
    static Node predecessor;
    static Node successor;
    static int state;
    
    public static void predecessorAndSuccessor(Node node, int data){
        if(state == 0){
            if(node.data == data){
                state = 1;
            } else {
                predecessor = node;
            }
        } else if(state == 1){
            successor = node;
            state = 2;
        }
        for(Node child: node.children){
            predecessorAndSuccessor(child, data);
        }
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
        
        int data = scn.nextInt();
        
        Node root = construct(arr);
        
        predecessor = null;
        successor = null;
        state = 0;
        
        predecessorAndSuccessor(root, data);
        
        if(predecessor == null){
            System.out.println("Predecessor not Found");
        } else {
            System.out.println("Predecessor: " + predecessor.data);
        }
        
        if(successor == null){
            System.out.println("Successor not Found");
        } else {
            System.out.println("Successor: " + successor.data);
        }
    
    }
}
