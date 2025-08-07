import java.util.*;

public class Main{
    private static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
        
        Node(){
            
        }
        
        Node(int data){
            this.data = data;
        }
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
    
    public static void levelOrderLinewise2(Node node){
        Queue<Node> q = new ArrayDeque<>();
        q.add(node);
        q.add(new Node(-1));
        
        while(q.size() > 0){
            node = q.remove();
            if(node.data != -1){
                System.out.print(node.data + " ");
                for(Node child: node.children){
                    q.add(child);
                }
            } else {
                if(q.size() > 0){
                    q.add(new Node(-1));
                    System.out.println();
                }
            }
        }
        System.out.println();
    }
    
    public static void levelOrderLinewise3(Node node){
        Queue<Node> q = new ArrayDeque<>();
        q.add(node);
        
        while(q.size() > 0){
            int cicl = q.size();
            
            for(int i = 0; i<cicl; i++){
                node = q.remove();
                System.out.print(node.data + " ");
                for(Node child: node.children){
                    q.add(child);
                }
            }
            
            System.out.println();
        }
    }
    
    private static class Pair{
        Node node;
        int level;
        
        Pair(Node node, int level){
            this.node = node;
            this.level = level;
        }
    }
    
    public static void levelOrderLinewise4(Node node){
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(node, 1));
        int level = 1;
        
        while(q.size() > 0){
            Pair p = q.remove();
            
            if(p.level > level){
                System.out.println();
                level = p.level;
            }
            
            System.out.print(p.node.data + " ");
            for(Node child: p.node.children){
                q.add(new Pair(child, p.level + 1));
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
        levelOrderLinewise(root);
        levelOrderLinewise2(root);
        levelOrderLinewise3(root);
        levelOrderLinewise4(root);
    }
}
