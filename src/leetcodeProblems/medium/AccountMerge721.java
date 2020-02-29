package leetcodeProblems.medium;

import java.util.*;


public class AccountMerge721 {
    public static void main(String[] args) {
        AccountMerge721 ob = new AccountMerge721();
        List<List<String>> accounts = new ArrayList<List<String>>();
//        accounts.add(Arrays.asList("David", "David0@m.co", "David4@m.co", "David3@m.co"));
//        accounts.add(Arrays.asList("David", "David5@m.co", "David5@m.co", "David0@m.co"));
//        accounts.add(Arrays.asList("David", "David1@m.co", "David4@m.co", "David0@m.co"));
//        accounts.add(Arrays.asList("David", "David0@m.co", "David1@m.co", "David3@m.co"));
//        accounts.add(Arrays.asList("David", "David4@m.co", "David1@m.co", "David3@m.co"));


//        accounts.add(Arrays.asList("David", "David0@m.co", "David1@m.co"));
//        accounts.add(Arrays.asList("David", "David3@m.co", "David4@m.co"));
//        accounts.add(Arrays.asList("David", "David4@m.co", "David5@m.co"));
//        accounts.add(Arrays.asList("David", "David2@m.co", "David3@m.co"));
//        accounts.add(Arrays.asList("David", "David1@m.co", "David2@m.co"));

        accounts.add(Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"));
        accounts.add(Arrays.asList("John", "johnnybravo@mail.com"));
        accounts.add(Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"));
        accounts.add(Arrays.asList("Mary", "mary@mail.com"));

        List<List<String>> result = ob.accountsMerge(accounts);
        System.out.println(result);

    }

    // using dfs approach
    // Time Complexity - O(Summation(A[i].length * log(A[i].length))) for all i
    // Space Complexity - O(Summation(A[i].length)  for all i
    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        Map<String, List<String>> graph = new HashMap<>(); // undirected graph
        Map<String, String> emailToName = new HashMap<>();

        for (List<String> account : accounts) {

            String name = account.get(0);
            String parentEmail = account.get(1);
            emailToName.put(parentEmail, name);
            if (account.size() > 2) {

                for (String child : account.subList(2, account.size())) {
                    graph.computeIfAbsent(parentEmail, s -> new ArrayList<>()).add(child);
                    graph.computeIfAbsent(child, s -> new ArrayList<>()).add(parentEmail); // making it undirected graph
                    emailToName.put(child, name);
                }
            } else {
                graph.computeIfAbsent(parentEmail, s -> new ArrayList<>()).add(parentEmail);
            }
        }

        List<String> visited = new ArrayList<>();
        Map<String, List<String>> result = new HashMap<>();
        Map<String, Boolean> isVisited = new HashMap<>();

        for (Map.Entry<String, List<String>> e : graph.entrySet()) {

            if (isVisited.get(e.getKey()) != null) {
                continue;
            }

            dfs(graph, e.getKey(), isVisited, visited);

            isVisited.putIfAbsent(e.getKey(), true);

            Collections.sort(visited);

            visited.add(0, emailToName.get(e.getKey()));

            result.put(e.getKey(), new ArrayList<>(visited));
            visited.clear();
        }

        return new ArrayList<>(result.values());
    }

    private void dfs(Map<String, List<String>> graph, String key, Map<String, Boolean> isVisited, List<String> visited) {

        if (graph.get(key) != null) {
            for (String neighbour : graph.get(key)) {
                if (isVisited.get(neighbour) == null) {
                    isVisited.put(neighbour, true);
                    visited.add(neighbour);
                    dfs(graph, neighbour, isVisited, visited);
                }
            }
        }
    }
}
