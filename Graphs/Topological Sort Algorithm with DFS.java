import java.util.*;

public class Main{
  public static class Edge{
    int src;
    int nbr;
    
    Edge(int src, int nbr){
      this.src = src;
      this.nbr = nbr;
    }
  }
  
  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    
    int vtces = scn.nextInt();
    int edges = scn.nextInt();
    
    @SuppressWarnings("unchecked")
    ArrayList<Edge>[] graph = new ArrayList[vtces];
    
    for(int v = 0; v < vtces; v++){
      graph[v] = new ArrayList<>();
    }
    
    for(int e = 0; e < edges; e++){
      int v1 = scn.nextInt();
      int v2 = scn.nextInt();
      
      graph[v1].add(new Edge(v1, v2));
    }
    
    Stack<Integer> st = new Stack<>();
    boolean[] visited = new boolean[vtces];
    for(int v = 0; v < vtces; v++){
      if(visited[v] == false){
        topologicalSort(graph, v, visited, st);
      }
    }
    
    while(st.size() > 0){
      System.out.println(st.pop());
    }
  }
  
  public static void topologicalSort(ArrayList<Edge>[] graph, int src, boolean[] visited, Stack<Integer> st){
    visited[src] = true;
    
    for(Edge e: graph[src]){
      if(visited[e.nbr] == false){
        topologicalSort(graph, e.nbr, visited, st);
      }
    }
    
    st.push(src);
  }
}
