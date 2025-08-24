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
    }
    
    public static Node construct(int[] arr, int l, int h){
        if(l > h){
            return null;
        }
        
        int mid = (l+h)/2;
        int data = arr[mid];
        
        Node lc = construct(arr, l, mid - 1);
        Node rc = construct(arr, mid + 1, h);
        
        Node node = new Node(data, lc, rc);
        
        return node;
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
    
    public static int lowestCommonAncestor(Node node, int d1, int d2){
        if(d1 < node.data && d2 < node.data){
            return lowestCommonAncestor(node.left, d1, d2);
        } else if(d1 > node.data && d2 > node.data){
            return lowestCommonAncestor(node.right, d1, d2);
        } else {
            return node.data;
        }
    }
    
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        
        int[] arr = new int[str.split(" ").length];
        
        for(int i = 0; i<arr.length; i++){
            arr[i] = Integer.parseInt(str.split(" ")[i]);
        }
        
        int d1 = scn.nextInt();
        int d2 = scn.nextInt();
        
        Node root = construct(arr, 0, arr.length-1);
        
        System.out.println(lowestCommonAncestor(root, d1, d2));
    }
}
