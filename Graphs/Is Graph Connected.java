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
        int edge = scn.nextInt();
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[vtces];
        for(int i = 0; i < vtces; i++){
            graph[i] = new ArrayList<>();
        }
        
        scn.nextLine();
        for(int i = 0; i < edge; i++){
            String str = scn.nextLine();
            int v1 = Integer.parseInt(str.split(" ")[0]);
            int v2 = Integer.parseInt(str.split(" ")[1]);
            int wt = Integer.parseInt(str.split(" ")[2]);
            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));
        }
        
        ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
        boolean[] visited = new boolean[vtces];
        for(int v = 0; v < vtces; v++){
            if(visited[v] == false){
                ArrayList<Integer> comp = new ArrayList<>();
                drawTreeAndGenerateComp(graph, v, comp, visited);
                comps.add(comp);
            }
        }
        
        System.out.println(comps.size() == 1);
    }
    
    public static void drawTreeAndGenerateComp(ArrayList<Edge>[] graph, int src, ArrayList<Integer> comp, boolean[] visited){
        visited[src] = true;
        comp.add(src);
        for(Edge e: graph[src]){
            if(visited[e.nbr] == false){
                drawTreeAndGenerateComp(graph, e.nbr, comp, visited);
            }
        }
    }
}
