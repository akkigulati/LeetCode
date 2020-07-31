/*Given a directed, acyclic graph of N nodes.  Find all possible paths from node 0 to node N-1, and return them in any order.

The graph is given as follows:  the nodes are 0, 1, ..., graph.length - 1.  graph[i] is a list of all nodes j for which the edge (i, j) exists.

Example:
Input: [[1,2], [3], [3], []] 
Output: [[0,1,3],[0,2,3]] 
Explanation: The graph looks like this:
0--->1
|    |
v    v
2--->3
There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
Note:

The number of nodes in the graph will be in the range [2, 15].
You can print different paths in any order, but you should keep the order of nodes inside one path.
*/
class Solution {
    class Edge{
        int src;
        int nbr;
        Edge(int s,int n){
            src=s;
            nbr=n;
        }
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
         ArrayList<Edge>[] Graph = new ArrayList[graph.length];
          for (int i = 0; i < graph.length; i++) {
                Graph[i] = new ArrayList<>();
             }
        for(int v1=0;v1<graph.length;v1++){
            for(int v2=0;v2<graph[v1].length;v2++){
                Graph[v1].add(new Edge(v1, graph[v1][v2]));
            }
            
        }
       List<List<Integer>> ans=new ArrayList<>();
        allPaths(Graph,0,graph.length-1,new boolean[graph.length],new ArrayList<>(),ans);
      return ans;
        
        
    }
    public static void allPaths(ArrayList<Edge>[] graph,int src,int dest,boolean visited[],List<Integer> asf,List<List<Integer>> ans){
       
       if(src==dest){
           asf.add(src);
           ans.add(new ArrayList<>(asf));
           asf.remove(new Integer(src));
           
           return;
       }
       visited[src]=true;
       for(Edge e:graph[src]){
           if(visited[e.nbr]==false){
               asf.add(src);
               allPaths(graph,e.nbr,dest,visited,asf,ans);
               asf.remove(new Integer(src));
           }
       }
    
       visited[src]=false;
       
       return;
   }
}
