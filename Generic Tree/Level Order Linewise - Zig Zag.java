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
            int cm = max(child);
            max = Math.max(max, cm);
        }
        
        max = Math.max(max, node.data);
        return max;
    }
    
    public static int height(Node node){
        int height = -1;
        for(Node child: node.children){
            int ch = height(child);
            height = Math.max(height, ch);
        }
        
        height++;
        return height;
    }

    public static void traversals(Node node){
        System.out.println("Node Pre " + node.data);
        
        for(Node child: node.children){
            System.out.println("Edge Pre " + node.data + "--" + child.data);
            traversals(child);
            System.out.println("Edge Post " + node.data + "--" + child.data);
        }
        
        System.out.println("Node Post " + node.data);
    }
    
    public static void levelOrder(Node node){
        Queue<Node> q = new ArrayDeque<>();
        q.add(node);
        
        while(q.size() > 0){
            node = q.remove();
            System.out.print(node.data + " ");
            
            for(Node child: node.children){
                q.add(child);
            }
        }
        
        System.out.print(".");
    }
    
    public static void levelOrderLinewise(Node node){
        Queue<Node> mq = new ArrayDeque<>();
        mq.add(node);
        
        Queue<Node> cq = new ArrayDeque<>();
        while(mq.size() > 0){
            node = mq.remove();
            System.out.print(node.data + " ");
            
            for(Node child: node.children){
                cq.add(child);
            }
            
            if(mq.size() == 0){
                mq = cq;
                cq = new ArrayDeque<>();
                System.out.println();
            }
        }
    }
    
    public static void levelOrderLinewiseZZ(Node node){
        Stack<Node> ms = new Stack<>();
        ms.push(node);
        
        Stack<Node> cs = new Stack<>();
        int level = 1;
        while(ms.size() > 0){
            node = ms.pop();
            System.out.print(node.data + " ");
            
            if(level % 2 == 1){
                for(int i = 0; i<node.children.size(); i++){
                    Node child = node.children.get(i);
                    cs.push(child);
                }
            } else {
                for(int i = node.children.size() - 1; i >= 0; i--){
                    Node child = node.children.get(i);
                    cs.push(child);
                }
            }
            
            if(ms.size() == 0){
                ms = cs;
                cs = new Stack<>();
                level++;
                System.out.println();
            }
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
        
        Node root = construct(arr);
        levelOrderLinewiseZZ(root);
    }
}
