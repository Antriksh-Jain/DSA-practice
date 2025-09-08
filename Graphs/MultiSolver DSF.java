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
        String psf;
        int wsf;
        
        Pair(String psf, int wsf){
            this.psf = psf;
            this.wsf = wsf;
        }
        
        public int compareTo(Pair o){
          return this.wsf - o.wsf;
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
        
        int criteria = scn.nextInt();
        int k = scn.nextInt();
        
        boolean[] visited = new boolean[vtces];
        multisolver(graph, src, dest, visited, src + "", 0, criteria, k);
        
        System.out.println("Smallest Path: " + spath + "@" + spathwt);
        System.out.println("Largest Path: " + lpath + "@" + lpathwt);
        System.out.println("Just Larger Path than " + criteria + ": " + cpath + "@" + cpathwt);
        System.out.println("Just Smaller Path than " + criteria + ": " + fpath + "@" + fpathwt);
        System.out.println(k + " largest element: " + pq.peek().psf + "@" + pq.peek().wsf);
    }
    
    
    static String spath;
    static int spathwt = Integer.MAX_VALUE;
    static String lpath;
    static int lpathwt = Integer.MIN_VALUE;
    static String cpath;
    static int cpathwt = Integer.MAX_VALUE;
    static String fpath;
    static int fpathwt = Integer.MIN_VALUE;
    static PriorityQueue<Pair> pq = new PriorityQueue<>();
    public static void multisolver(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited, String psf, int wsf, int criteria, int k){
        if(src == dest){
            if(wsf < spathwt){
                spath = psf;
                spathwt = wsf;
            }
            
            if(wsf > lpathwt){
                lpath = psf;
                lpathwt = wsf;
            }
            
            if(wsf > criteria && wsf < cpathwt){
                cpath = psf;
                cpathwt = wsf;
            }
            
            if(wsf < criteria && wsf > fpathwt){
                fpath = psf;
                fpathwt = wsf;
            }
            
            if(pq.size() < k){
                pq.add(new Pair(psf, wsf));
            } else {
                if (wsf > pq.peek().wsf){
                    pq.remove();
                    pq.add(new Pair(psf, wsf));
                }
            }
            
            return;
        }
        
        visited[src] = true;
        for(Edge edge: graph[src]){
            if(visited[edge.nbr] == false){
                multisolver(graph, edge.nbr, dest, visited, psf + edge.nbr, wsf + edge.wt, criteria, k);
            }
        }
        visited[src] = false;
    }
}
