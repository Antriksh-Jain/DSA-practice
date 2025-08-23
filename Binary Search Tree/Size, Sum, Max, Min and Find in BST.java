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
    
    public static int size(Node node){
        if(node == null){
            return 0;
        }
        
        int lsize = size(node.left);
        int rsize = size(node.right);
        
        int tsize = lsize + rsize + 1;
        return tsize;
    }
    
    public static int sum(Node node){
        if(node == null){
            return 0;
        }
        
        int lsum = sum(node.left);
        int rsum = sum(node.right);
        
        int tsum = lsum + rsum + node.data;
        return tsum;
    }
    
    public static int max(Node node){
        if(node.left != null){
            return max(node.left);
        } else {
            return node.data;
        }
    }
    
    public static int min(Node node){
        if(node.right != null){
            return min(node.right);
        } else {
            return node.data;
        }
    }
    
    public static boolean find(Node node, int data){
        if(node == null){
            return false;
        }
        
        if(node.data == data){
            return true;
        } else if(node.data < data){
            return find(node.right, data);
        } else {
            return find(node.left, data);
        }
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
        
        System.out.println(size(root));
        System.out.println(sum(root));
        System.out.println(max(root));
        System.out.println(min(root));
        System.out.println(find(root, data));
    }
}
