import java.util.*;

public class Main{
    public static class Node{
        int data;
        Node next;
    }
    
    public static class LinkedList{
        Node head;
        Node tail;
        int size;
        
        void addLast(int val){
            Node temp = new Node();
            temp.data = val;
            temp.next = null;
            
            if(size==0){
                head=tail=temp;
            } else {
                tail.next = temp;
                tail = temp;
            }
            size++;
        }
        
        int size(){
            return size;
        }
        
        void display(){
            Node temp = head;
            while(temp!=null){
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }
        
        void removeFirst(){
            if(size()==0){
                System.out.println("List is empty");
            } else if(size()==1){
                head = null;
                tail = null;
                size = 0;
            } else {
                head = head.next;
                size--;
            }
        }
        
        int getFirst(){
            if(size()==0){
                System.out.println("List is empty");
                return -1;
            } else {
                return head.data;
            }
        }
        
        int getLast(){
            if(size()==0){
                System.out.println("List is empty");
                return -1;
            } else {
                return tail.data;
            }
        }
        
        int getAt(int idx){
            if(size()==0){
                System.out.println("List is empty");
                return -1;
            } else if(idx>=size() || idx<0){
                System.out.println("Invalid Argument");
                return -1;
            } else {
                Node rv = head;
                for(int i = 0; i<idx; i++){
                    rv = rv.next;
                }
                return rv.data;
            }
        }
        
        void addFirst(int val){
            Node temp = new Node();
            temp.data = val;
            temp.next = head;
            head = temp;
            
            if(size()==0){
                tail = temp;
            }
        
            size++;
        }
        
        void addAt(int idx, int val){
            if(idx<0 || idx>size){
                System.out.println("Invalid Argument");
            } else if(idx == 0){
                addFirst(val);
            } else if(idx == size){
                addLast(val);
            } else {
                Node node = new Node();
                node.data = val;
                
                Node temp = head;
                for(int i = 0; i<idx-1; i++){
                    temp = temp.next;
                }
                
                node.next = temp.next;
                temp.next = node;
                
                size++;
            }
        }
        
        void removeLast(){
            if(size==0){
                System.out.println("List is empty");
            } else if(size == 1){
                head = null;
                tail = null;
                size = 0;
            } else {
                Node temp = head;
                for(int i = 0; i<size-2; i++){
                    temp = temp.next;
                }
                
                temp.next = null;
                tail = temp;
                
                size--;
            }
        }
        
        void removeAt(int idx){
            if(size == 0){
                System.out.println("List is empty");
            } else if(idx<0 || idx>=size){
                System.out.println("Invalid Argument");
            } else if(idx == size-1){
                removeLast();
            } else if(idx==0){
                removeFirst();
            } else {
                Node temp = head;
                for(int i = 0; i<idx-1; i++){
                    temp = temp.next;
                }
                Node t = temp.next;
                
                temp.next = t.next;
                size--;
            }
        }
        
        private Node getNodeAt(int idx){
            Node temp = head;
            for(int i = 0; i<idx; i++){
                temp = temp.next;
            }
            return temp;
        }
        
        void reverseDI(){
            int li = 0;
            int ri = size-1;
            
            while(li<ri){
                Node left = getNodeAt(li);
                Node right = getNodeAt(ri);
                
                int temp = left.data;
                left.data = right.data;
                right.data = temp;
                
                li++;
                ri--;
            }
        }
        
        void reversePI(){
            Node prev = null;
            Node curr = head;
            while(curr!=null){
                Node next = curr.next;
                curr.next = prev;
                
                prev = curr;
                curr = next;
            }
            
            Node temp = head;
            head = tail;
            tail = temp;
        }
        
        int kthFromLast(int k){
            Node s = head;
            Node f = head;
            
            for(int i = 0; i<k; i++){
                f = f.next;
            }
            
            while(f != tail){
                s=s.next;
                f=f.next;
            }
            
            return s.data;
        }
        
        int mid(){
            Node s = head;
            Node f = head;
            
            while(f.next!=null && f.next.next !=null){
                s = s.next;
                f = f.next.next;
            }
            
            return s.data;
        }
        
        public static LinkedList mergeTwoSortedLists(LinkedList l1, LinkedList l2){
            Node one = l1.head;
            Node two = l2.head;
            
            LinkedList res = new LinkedList();
            while(one!=null && two!=null){
                if(one.data<two.data){
                    res.addLast(one.data);
                    one = one.next;
                } else {
                    res.addLast(two.data);
                    two = two.next;
                }
            }
            
            while(one!=null){
                res.addLast(one.data);
                one = one.next;
                
            }
            
            while(two!=null){
                res.addLast(two.data);
                two = two.next;
                
            }
            
            return res;
        }
    }
    
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        
        int n1 = scn.nextInt();
        scn.nextLine();
        
        LinkedList l1 = new LinkedList();
        String val1 = scn.nextLine();
        for(int i=0; i<n1; i++){
            int d1 = Integer.parseInt(val1.split(" ")[i]);
            l1.addLast(d1);
        }
        
        
        int n2 = scn.nextInt();
        scn.nextLine();
        
        LinkedList l2 = new LinkedList();
        String val2 = scn.nextLine();
        for(int i=0; i<n2; i++){
            int d2 = Integer.parseInt(val2.split(" ")[i]);
            l2.addLast(d2);
        }
        
        LinkedList merged = LinkedList.mergeTwoSortedLists(l1, l2);
        merged.display();
        l1.display();
        l2.display();
    }
}
