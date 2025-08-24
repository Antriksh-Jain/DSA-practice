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
    
    public static class ITPair{
        Node node;
        int state;
        
        ITPair(Node node, int state){
            this.node = node;
            this.state = state;
        }
    }
    
    public static void targetSumPair(Node node, int tar){
        Stack<ITPair> ls = new Stack<>();
        Stack<ITPair> rs = new Stack<>();
        
        ls.push(new ITPair(node, 0));
        rs.push(new ITPair(node, 0));
        
        Node left = getNextFromNormalInOrder(ls);
        Node right = getNextFromReverseInOrder(rs);
        
        while(left.data < right.data){
            if(left.data + right.data < tar){
                left = getNextFromNormalInOrder(ls);
            } else if(left.data + right.data > tar){
                right = getNextFromReverseInOrder(rs);
            } else {
                System.out.println(left.data + " " + right.data);
                left = getNextFromNormalInOrder(ls);
                right = getNextFromReverseInOrder(rs);
            }
        }
    }
    
    public static Node getNextFromNormalInOrder(Stack<ITPair> st){
        while(st.size() > 0){
            ITPair top = st.peek();
            if(top.state == 0){
                if(top.node.left != null){
                    st.push(new ITPair(top.node.left, 0));
                }
                top.state++;
            } else if(top.state == 1){
                if(top.node.right != null){
                    st.push(new ITPair(top.node.right, 0));
                }
                top.state++;
                return top.node;
            } else {
                st.pop();
            }
        }
        
        return null;
    }
    
    public static Node getNextFromReverseInOrder(Stack<ITPair> st){
        while(st.size() > 0){
            ITPair top = st.peek();
            if(top.state == 0){
                if(top.node.right != null){
                    st.push(new ITPair(top.node.right, 0));
                }
                top.state++;
            } else if(top.state == 1){
                if(top.node.left != null){
                    st.push(new ITPair(top.node.left, 0));
                }
                top.state++;
                return top.node;
            } else {
                st.pop();
            }
        }
        
        return null;
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
        
        targetSumPair(root, data);
    }
}
