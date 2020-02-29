package leetcodeProblems.medium;

import java.util.Arrays;

public class RedundantConnectionInGraph684 {
    public static void main(String[] args) {

//        int[][] edges = {{1,2}, {1,3}, {2,3}};
        int[][] edges = {{1,2}, {2,3}, {3,4}, {1,4}, {1,5}};
//        int[][] edges = {{1, 4}, {3, 4}, {1, 3}, {1, 2}, {4, 5}};
        RedundantConnectionInGraph684 ob = new RedundantConnectionInGraph684();
        int[] redundantEdge = ob.findRedundantConnection(edges);
        System.out.println(Arrays.toString(redundantEdge));
    }


//    public int[] findRedundantConnection(int[][] edges) {
//
//        ArrayList<Integer> seen = new ArrayList<>();
//
//        // represent the graph
//        ArrayList<Integer>[] graph = new ArrayList[edges.length + 1];
//
//        for (int i = 0; i <= edges.length; i++){
//            graph[i] = new ArrayList<>();
//        }
//
//        // for each of edges trigger DFS
//        for (int[] edge : edges) {
//
//            // clear previous stored seen vertices before triggering DFS on new src and dest
//            seen.clear();
//
//            if (!graph[edge[0]].isEmpty() && !graph[edge[1]].isEmpty()
//                    && dfs(graph, edge[0], edge[1], seen)) {
//                return edge;
//            }
//
//            // create undirectional graph along the way
//            graph[edge[0]].add(edge[1]);
//            graph[edge[1]].add(edge[0]);
//        }
//        return null;
//    }
//
//    private boolean dfs(ArrayList<Integer>[] graph, int source, int target, ArrayList<Integer> seen) {
//
//        if (!seen.contains(source)) {
//            seen.add(source);
//            if (source == target)
//                return true;
//
//            for (int dest : graph[source]) {
//                if (dfs(graph, dest, target, seen)) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }


    int[] rank;
    int[] parent;

    //Disjoint Set Implementation
    public int[] findRedundantConnection(int[][] edges) {

        int v = edges.length + 1;
        rank = new int[v];    // ignore 0's index
        parent = new int[v];    // ignore 0's index

        for (int i = 1; i < rank.length; i++) {
            rank[i] = 0;
            parent[i] = i;
        }

        for (int[] edge : edges){

            int parentOfx = find(edge[0]);
            int parentOfy = find(edge[1]);

            if(parentOfx == parentOfy){
                return edge; // this is first edge that creates cycle in graph
            }

            union(edge[0], edge[1]);
        }
        return null;
    }


    // applying union by rank
    public void union(int x, int y) {

        int parentOfx = find(x);
        int parentOfy = find(y);

        if(rank[parentOfx] < rank[parentOfy]){
            parent[parentOfx] = parentOfy;
        }
        else if(rank[parentOfx] > rank[parentOfy]){
            parent[parentOfy] = parentOfx;
        }
        else{
            parent[parentOfx] = parentOfy;
            rank[parentOfy]++;
        }
    }

    // applying path compression
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);    // compression happens here
        }

        return parent[x];
    }
}
