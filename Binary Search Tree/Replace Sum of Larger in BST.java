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
    
    static int sum = 0;
    public static void replaceWithSumOfLarger(Node node){
        if(node == null){
            return;
        }
        
        replaceWithSumOfLarger(node.right);
        
        int od = node.data;
        node.data = sum;
        sum += od;
        
        replaceWithSumOfLarger(node.left);
    }
    
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        
        int[] arr = new int[str.split(" ").length];
        
        for(int i = 0; i<arr.length; i++){
            arr[i] = Integer.parseInt(str.split(" ")[i]);
        }
        
        Node root = construct(arr, 0, arr.length-1);
        
        replaceWithSumOfLarger(root);
        display(root);
    }
}
