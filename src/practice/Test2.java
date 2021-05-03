package practice;

import java.util.*;

public class Test2 {
    public static void main(String[] args) {
        Test2 ob = new Test2();
        List<List<String>> input1 = new ArrayList<>();
        input1.add(Arrays.asList("MUC", "LHR"));
        input1.add(Arrays.asList("JFK", "MUC"));
        input1.add(Arrays.asList("SFO", "SJC"));
        input1.add(Arrays.asList("LHR", "SFO"));

        List<List<String>> input2 = new ArrayList<>();
        input2.add(Arrays.asList("JFK", "KUL"));
        input2.add(Arrays.asList("JFK", "NRT"));
        input2.add(Arrays.asList("NRT", "JFK"));


//        System.out.println(ob.findItinerary(input1));
        System.out.println(ob.findItinerary(input2));
    }

    public List<String> findItinerary(List<List<String>> tickets) {

        Map<String, TreeSet<String>> graph = new HashMap<>();
        for (List<String> pair : tickets) {
            String src = pair.get(0);
            String dest = pair.get(1);

            TreeSet<String> destinations = graph.getOrDefault(src, new TreeSet<>());
            destinations.add(dest);
            graph.put(src, destinations);
        }

        List<String> route = new ArrayList<>();
        String start = "JFK";
        Map<String, TreeSet<String>> isVisited = new HashMap<>();

        dfs(graph, isVisited, start, route, new int[]{tickets.size()});
        return route;
    }

    public boolean dfs(Map<String, TreeSet<String>> graph, Map<String, TreeSet<String>> isVisited, String start,
                       List<String> result, int[] ticketCount) {
        // all destinations has been visited which is base condition
        if (isVisited.size() == ticketCount[0] + 1)
            return true;

        result.add(start);

        TreeSet<String> destinations = graph.getOrDefault(start, new TreeSet<>());
        if (destinations.isEmpty())
            return false;

        for (String dest : destinations) {
            if (!isVisited.getOrDefault(start, new TreeSet<>()).contains(dest)) {
                TreeSet<String> v = isVisited.getOrDefault(start, new TreeSet<>());
                v.add(dest);
                isVisited.put(start, v);
                boolean dfsResultWithDestination = dfs(graph, isVisited, dest, result, ticketCount);

                if (dfsResultWithDestination) {
                    return true;
                }
                // reverting back
                v = isVisited.getOrDefault(start, new TreeSet<>());
                v.remove(dest);
                isVisited.put(start, v);
            }
        }

        result.remove(result.size() - 1);
        return false;
    }
}
