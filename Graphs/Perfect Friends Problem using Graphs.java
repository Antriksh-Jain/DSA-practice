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
      graph[v2].add(new Edge(v2, v1));
    }
    
    ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
    boolean[] visited = new boolean[vtces];
    for(int i = 0; i < vtces; i++){
      if(visited[i] == false){
        ArrayList<Integer> comp = new ArrayList<>();
        drawTreeAndCreatComp(graph, i, comp, visited);
        comps.add(comp);
      }
    }
    
    int pairs = 0;
    for(int i = 0; i < comps.size(); i++){
      for(int j = i + 1; j < comps.size(); j++){
        int count = comps.get(i).size() * comps.get(j).size();
        pairs += count;
      }
    }
    
    System.out.println(pairs);
  }
  
  public static void drawTreeAndCreatComp(ArrayList<Edge>[] graph, int src, ArrayList<Integer> comp, boolean[] visited){
    visited[src] = true;
    comp.add(src);
    
    for(Edge e: graph[src]){
      if(visited[e.nbr] == false){
        drawTreeAndCreatComp(graph, e.nbr, comp, visited);
      }
    }
  }
}
