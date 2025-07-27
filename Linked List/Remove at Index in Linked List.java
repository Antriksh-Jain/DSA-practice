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
    }
    
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        LinkedList list = new LinkedList();
        
        String str = scn.nextLine();
        while(str.equals("exit") == false){
            if(str.startsWith("addLast")){
                int val = Integer.parseInt(str.split(" ")[1]);
                list.addLast(val);
            } else if(str.equals("size")){
                System.out.println(list.size());
            } else if(str.equals("display")){
                list.display();
            } else if(str.equals("removeFirst")){
                list.removeFirst();
            } else if(str.equals("getFirst")){
                System.out.println(list.getFirst());
            } else if(str.equals("getLast")){
                System.out.println(list.getLast());
            } else if(str.startsWith("getAt")){
                int val = Integer.parseInt(str.split(" ")[1]);
                System.out.println(list.getAt(val));
            } else if(str.startsWith("addFirst")){
                int val = Integer.parseInt(str.split(" ")[1]);
                list.addFirst(val);
            } else if(str.startsWith("addAt")){
                int idx = Integer.parseInt(str.split(" ")[1]);
                int val = Integer.parseInt(str.split(" ")[2]);
                list.addAt(idx, val);
            } else if(str.equals("removeLast")){
                list.removeLast();
            } else if(str.startsWith("removeAt")){
                int idx = Integer.parseInt(str.split(" ")[1]);
                list.removeAt(idx);
            }
            str = scn.nextLine();
        }
    }
}
