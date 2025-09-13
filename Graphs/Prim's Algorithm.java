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
  
  public static class Pair implements Comparable<Pair>{
    int v;
    int av;
    int wt;
    
    Pair(int v, int av, int wt){
      this.v = v;
      this.av = av;
      this.wt = wt;
    }
    
    public int compareTo(Pair o){
      return this.wt - o.wt;
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
    
    PriorityQueue<Pair> pq = new PriorityQueue<>();
    pq.add(new Pair(0, -1, 0));
    boolean[] visited = new boolean[vtces];
    
    while(pq.size() > 0){
      Pair rem = pq.remove();
      
      if(visited[rem.v] == true){
        continue;
      } else {
        visited[rem.v] = true;
      }
      
      if(rem.av != -1){
        System.out.println("[" + rem.v + '-' + rem.av + "@" + rem.wt + "]");
      }
      
      for(Edge e: graph[rem.v]){
        if(visited[e.nbr] == false){
          pq.add(new Pair(e.nbr, rem.v, e.wt));
        }
      }
    }
  }
}
