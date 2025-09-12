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
    int time;
    
    Pair(int v, int time){
      this.v = v;
      this.time = time;
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
    
    int src = scn.nextInt();
    int t = scn.nextInt();
    
    Queue<Pair> queue = new ArrayDeque<>();
    queue.add(new Pair(src, 1));
    int[] visited = new int[vtces];
    int count = 0;
    
    while(queue.size() > 0){
      Pair rem = queue.remove();
      
      if(visited[rem.v] > 0){
        continue;
      } else {
        visited[rem.v] = rem.time;
      }
      
      if(rem.time > t){
        break;
      }
      
      count++;
      for(Edge e: graph[rem.v]){
        if(visited[e.nbr] == 0){
          queue.add(new Pair(e.nbr, rem.time + 1));
        }
      }
    }
    
    System.out.println(count);
  }
  
  
}
