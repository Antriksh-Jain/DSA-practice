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
        
        private static Node midNode(Node head, Node tail){
            Node f = head;
            Node s = head;
            
            while(f!=tail && f.next!=tail){
                f = f.next.next;
                s = s.next;
            }
            
            return s;
        }
        
        public static LinkedList mergeSort(Node head, Node tail){
            if(head == tail){
                LinkedList br = new LinkedList();
                br.addLast(head.data);
                return br;
            }
            
            Node mid = midNode(head, tail);
            LinkedList fsh = mergeSort(head, mid);
            LinkedList ssh = mergeSort(mid.next, tail);
            LinkedList cl = LinkedList.mergeTwoSortedLists(fsh, ssh);
            
            return cl;
        }
        
        void removeDuplicates(){
            LinkedList res = new LinkedList();
            while(this.size!=0){
                int val = this.getFirst();
                this.removeFirst();
                
                if(res.size() == 0 || res.tail.data != val){
                    res.addLast(val);
                }
            }
            
            this.size = res.size;
            this.head = res.head;
            this.tail = res.tail;
        }
        
        void oddEven(){
            LinkedList odd = new LinkedList();
            LinkedList even = new LinkedList();
            
            while(this.size>0){
                int val = this.getFirst();
                this.removeFirst();
                
                if(val%2==0){
                    even.addLast(val);
                } else {
                    odd.addLast(val);
                }
            }
            
            if(odd.size>0 && even.size>0){
                odd.tail.next = even.head;
                this.head = odd.head;
                this.tail = even.tail;
                this.size = odd.size + even.size;
            } else if(odd.size>0){
                this.head = odd.head;
                this.tail = odd.tail;
                this.size = odd.size;
            } else if(even.size>0){
                this.head = even.head;
                this.tail = even.tail;
                this.size = even.size;
            }
        }
        
        void kReverse(int k){
            LinkedList p = new LinkedList();
            LinkedList c = new LinkedList();
            
            while(this.size>0){
                if(k<=this.size && p.size==0){
                    for(int i = 0; i<k; i++){
                        int val = this.getFirst();
                        this.removeFirst();
                        
                        c.addFirst(val);
                    }
                    
                    p = c;
                    c = new LinkedList();
                } else if(k<=this.size){
                    for(int i = 0; i<k; i++){
                        int val = this.getFirst();
                        this.removeFirst();
                        
                        c.addFirst(val);
                    }
                    
                    p.tail.next = c.head;
                    p.tail = c.tail;
                    p.size = p.size + c.size;
                    c = new LinkedList();
                } else {
                    int val = this.getFirst();
                    this.removeFirst();
                    
                    p.addLast(val);
                }
            }
            
            this.head = p.head;
            this.tail = p.tail;
            this.size = p.size;
        }
        
        private void displayReverseHelper(Node node){
            if(node == null){
                return;
            }
            displayReverseHelper(node.next);
            System.out.print(node.data + " ");
        }
        
        void displayReverse(){
            displayReverseHelper(head);
            System.out.println();
        }
        
        private void reversePRHelper(Node node){
            if(node == null){
                return;
            }
            
            reversePRHelper(node.next);
            
            if(node!=tail){
                node.next.next = node;
            }
        }
        
        void reversePR(){
            reversePRHelper(head);
            head.next = null;
            Node temp = head;
            head = tail;
            tail = temp;
        }
        
        private boolean isPalindromeHelper(Node right, int floor){
            if(right == null){
                return true;
            }
            
            boolean rres = isPalindromeHelper(right.next, floor + 1);
            if(floor >= size/2){
                if(rres == false){
                    return false;
                } else if(right.data != pleft.data){
                    return false;
                } else {
                    pleft = pleft.next;
                    return true;
                }
            }
            return rres;
        }
        
        Node pleft;
        boolean isPalindrome(){
            pleft = head;
            return isPalindromeHelper(head, 0);
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
        
        l1.display();
        System.out.println(l1.isPalindrome());
    }
}
