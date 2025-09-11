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
  
  public static class Pair{
    int v;
    String psf;
    
    Pair(int v, String psf){
      this.v = v;
      this.psf = psf;
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
    
    boolean[] visited = new boolean[vtces];
    for(int i = 0; i < vtces; i++){
      if(visited[i] == false){
        boolean cycle = IsCyclic(graph, i, visited);
        if(cycle){
          System.out.println(true);
          return;
        }
      }
    }
    
    System.out.println(false);
  }
  
  public static boolean IsCyclic(ArrayList<Edge>[] graph, int src, boolean[] visited){
    Queue<Pair> queue = new ArrayDeque<>();
    queue.add(new Pair(src, src + ""));
    
    while(queue.size() > 0){
      Pair rem = queue.remove();
      
      if(visited[rem.v]){
        return true;
      } else {
        visited[rem.v] = true;
      }
      
      for(Edge e: graph[rem.v]){
        if(visited[e.nbr] == false){
          queue.add(new Pair(e.nbr, rem.psf + e.nbr));
        }
      }
    }
    
    return false;
  }
}
