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
    
    static int ceil;
    static int floor;
    public static void ceilAndFloor(Node node, int data){
        if(node.data > data){
            if(node.data < ceil){
                ceil = node.data;
            }
        }
        
        if(node.data < data){
            if(node.data > floor){
                floor = node.data;
            }
        }
        
        for(Node child: node.children){
            ceilAndFloor(child, data);
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
        
        ceil = Integer.MAX_VALUE;
        floor = Integer.MIN_VALUE;
        
        ceilAndFloor(root, data);
        
        System.out.println("Ceil: " + ceil);
        System.out.println("Floor: " + floor);
    
    }
}
