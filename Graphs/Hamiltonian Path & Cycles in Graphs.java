import java.util.*;

public class Main{
  public static class Edge{
    int src;
    int nbr;
    int wt;
    
    Edge(int src, int nbr, int wt){
      this.src = src;
      this.nbr = nbr;
      this.wt = wt;
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
      int wt = scn.nextInt();
      
      graph[v1].add(new Edge(v1, v2, wt));
      graph[v2].add(new Edge(v2, v1, wt));
    }
    int src = scn.nextInt();
    
    HashSet<Integer> visited = new HashSet<>();
    hamiltonian(graph, src, visited, src + "", src);
  }
  
  public static void hamiltonian(ArrayList<Edge>[] graph, int src, HashSet<Integer> visited, String psf, int osrc){
    if(visited.size() == graph.length - 1){
      System.out.print(psf);
      
      boolean closingEdgeFound = false;
      for(Edge e: graph[src]){
        if(e.nbr == osrc){
          closingEdgeFound = true;
        }
      }
      
      if(closingEdgeFound){
        System.out.println("*");
      } else {
        System.out.println(".");
      }
      
      return;
    }
    
    visited.add(src);
    for(Edge e: graph[src]){
      if(visited.contains(e.nbr) == false){
        hamiltonian(graph, e.nbr, visited, psf + e.nbr, osrc);
      }
    }
    visited.remove(src);
  }
  
}
