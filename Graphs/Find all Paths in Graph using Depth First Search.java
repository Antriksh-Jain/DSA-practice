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
        
        int edge = scn.nextInt();
        int vtces = scn.nextInt();
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[vtces];
        for(int i = 0; i < vtces; i++){
            graph[i] = new ArrayList<>();
        }
        
        scn.nextLine();
        for(int i = 0; i < vtces; i++){
            String str = scn.nextLine();
            int v1 = Integer.parseInt(str.split(" ")[0]);
            int v2 = Integer.parseInt(str.split(" ")[1]);
            int wt = Integer.parseInt(str.split(" ")[2]);
            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));
        }
        
        int src = scn.nextInt();
        int dest = scn.nextInt();
        
        boolean[] visited = new boolean[vtces];
        findAllPaths(graph, src, dest, visited, src + "");
    }
    
    public static void findAllPaths(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited, String psf){
        if(src == dest){
            System.out.println(psf);
            return;
        }
        
        visited[src] = true;
        for(Edge edge: graph[src]){
            if(visited[edge.nbr] == false){
                findAllPaths(graph, edge.nbr, dest, visited, psf + edge.nbr);
            }
        }
        visited[src] = false;
    }
}
