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
            }
            str = scn.nextLine();
        }
    }
}
