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
    int lvl;
    
    Pair(int v, String psf, int lvl){
      this.v = v;
      this.psf = psf;
      this.lvl = lvl;
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
    
    int[] visited = new int[vtces];
    Arrays.fill(visited, -1);
    
    for(int v = 0; v < vtces; v++){
      if(visited[v] == -1){
        boolean isCompBipartite = BipartitenessOfComp(graph, v, visited);
        if(isCompBipartite == false){
          System.out.println(false);
          return;
        }
      }
    }
    
    System.out.println(true);
  }
  
  public static boolean BipartitenessOfComp(ArrayList<Edge>[] graph, int src, int[] visited){
    Queue<Pair> queue = new ArrayDeque<>();
    queue.add(new Pair(src, src + "", 0));
    
    while(queue.size() > 0){
      Pair rem = queue.remove();
      
      if(visited[rem.v] != -1){
        if(rem.lvl != visited[rem.v]){
          return false;
        }
      } else {
        visited[rem.v] = rem.lvl;
      }
      
      for(Edge e: graph[rem.v]){
        if(visited[e.nbr] == -1){
          queue.add(new Pair(e.nbr, rem.psf + e.nbr, rem.lvl + 1));
        }
      }
    }
    
    return true;
  }
}
