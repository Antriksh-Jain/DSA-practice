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
    
    public static int size(Node node){
        int s = 0;
        for(Node child: node.children){
            int cs = size(child);
            s += cs;
        }
        
        s += 1;
        return s;
    }
    
    public static int max(Node node){
        int max = Integer.MIN_VALUE;
        for(Node child: node.children){
            int cm = child.data;
            max = Math.max(max, cm);
        }
        
        max = Math.max(max, node.data);
        return max;
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
        System.out.println(max(root));
    }
}
