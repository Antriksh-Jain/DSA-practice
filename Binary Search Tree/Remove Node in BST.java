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
    
    public static int max(Node node){
        if(node.right != null){
            return max(node.right);
        } else {
            return node.data;
        }
    }
    
    public static Node remove(Node node, int data){
        if(node == null){
            return null;
        }
        
        if(node.data > data){
            node.left = remove(node.left, data);
        } else if(node.data < data){
            node.right = remove(node.right, data);
        } else {
            if(node.left != null && node.right != null){
                int lmax = max(node.left);
                node.data = lmax;
                node.left = remove(node.left, lmax);
                return node;
            } else if(node.left != null){
                return node.left;
            } else if(node.right != null){
                return node.right;
            } else {
                return null;
            }
        }
        
        return node;
    }
    
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        
        int[] arr = new int[str.split(" ").length];
        
        for(int i = 0; i<arr.length; i++){
            arr[i] = Integer.parseInt(str.split(" ")[i]);
        }
        int data = scn.nextInt();
        
        Node root = construct(arr, 0, arr.length-1);
        root = remove(root, data);
        display(root);
    }
}
