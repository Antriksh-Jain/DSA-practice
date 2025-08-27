import java.util.*;

public class Main{
    public static class PriorityQueue<T>{
        ArrayList<T> data;
        Comparator comp;
        
        PriorityQueue(){
            data = new ArrayList<>();
            comp = null;
        }
        
        PriorityQueue(Comparator comp){
            data = new ArrayList<>();
            this.comp = comp;
        }
        
        public void add(T val){
            data.add(val);
            upheafiy(data.size() - 1);
        }
        
        public boolean isSmaller(int i, int j){
            if(comp == null){
                Comparable ith = (Comparable) data.get(i);
                Comparable jth = (Comparable) data.get(j);
                
                if(ith.compareTo(jth) < 0){
                    return true;
                } else {
                    return false;
                }
            } else {
                T ith = data.get(i);
                T jth = data.get(j);
                
                if(comp.compare(ith, jth) < 0){
                    return true;
                } else {
                    return false;
                }
            }
        }
        
        private void upheafiy(int i){
            if(i == 0){
                return;
            }
            
            int pi = (i - 1 ) / 2;
            if(isSmaller(i, pi)){
                swap(i, pi);
                upheafiy(pi);
            }
        }
        
        private void swap(int i, int j){
            T ith = data.get(i);
            T jth = data.get(j);
            data.set(j, ith);
            data.set(i, jth);
        }
        
        public T remove(){
            if(this.size() == 0){
                System.out.println("Underflow");
                return null;
            } else {
                swap(0, data.size() - 1);
                T val = data.remove(data.size() - 1);
                downheapify(0);
                return val;
            }
        }
        
        private void downheapify(int pi){
            int mini = pi;
            int li = pi * 2 + 1;
            if(li < data.size() && isSmaller(li, mini)){
                mini = li;
            }
            
            int ri = pi * 2 + 2;
            if(ri < data.size() && isSmaller(ri, mini)){
                mini = ri;
            }
            
            if(mini != pi){
                swap(pi, mini);
                downheapify(mini);
            }
        }
        
        public T peek(){
            if(this.size() == 0){
                System.out.println("Underflow");
                return null;
            } else {
                return data.get(0);
            }
        }
        
        public int size(){
            return data.size();
        }
    }
    
    static class Student implements Comparable<Student>{
        int rno;
        int ht;
        int wt;
        
        Student(int rno, int ht, int wt){
            this.rno = rno;
            this.ht = ht;
            this.wt = wt;
        }
        
        public int compareTo(Student o){
            return this.rno - o.rno;
        }
        
        public String toString(){
            return "Rno: " + rno + ", Ht: " + ht + ", Wt: " + wt;
        }
    }
    
    static class StudentHtComparator implements Comparator<Student>{
        public int compare(Student s1, Student s2){
            return s1.ht - s2.ht;
        }
    }
    
    static class StudentWtComparator implements Comparator<Student>{
        public int compare(Student s1, Student s2){
            return s1.wt - s2.wt;
        }
    }
    
    public static void main(String[] args){
        PriorityQueue<Student> pqr = new PriorityQueue<>();
        PriorityQueue<Student> pqh = new PriorityQueue<>(new StudentHtComparator());
        PriorityQueue<Student> pqw = new PriorityQueue<>(new StudentWtComparator());
        
        pqr.add(new Student(8, 182, 65));
        pqr.add(new Student(3, 180, 68));
        pqr.add(new Student(1, 173, 60));
        pqr.add(new Student(11, 164, 57));
        pqr.add(new Student(19, 177, 73));
        
        while(pqr.size() > 0){
            System.out.println(pqr.remove());
        }
        
        pqh.add(new Student(8, 182, 65));
        pqh.add(new Student(3, 180, 68));
        pqh.add(new Student(1, 173, 60));
        pqh.add(new Student(11, 164, 57));
        pqh.add(new Student(19, 177, 73));
        
        while(pqh.size() > 0){
            System.out.println(pqh.remove());
        }
        
        pqw.add(new Student(8, 182, 65));
        pqw.add(new Student(3, 180, 68));
        pqw.add(new Student(1, 173, 60));
        pqw.add(new Student(11, 164, 57));
        pqw.add(new Student(19, 177, 73));
        
        while(pqw.size() > 0){
            System.out.println(pqw.remove());
        }
    }
}
