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
        Map<String, String> emailToName = new HashMap<>();
        Map<String, List<String>> graph = new HashMap<>();

        for (List<String> account : accounts) {
            String name = account.get(0);
            String parentEmail = account.get(1);
            emailToName.put(parentEmail, name);

            if (account.size() > 2) {
                for (int i = 2; i < account.size(); i++) {
                    String childEmail = account.get(i);
                    graph.computeIfAbsent(parentEmail, k -> new ArrayList<>()).add(childEmail);
                    graph.computeIfAbsent(childEmail, k -> new ArrayList<>()).add(parentEmail);
                    emailToName.put(childEmail, name);
                }
            } else {
                graph.computeIfAbsent(parentEmail, k -> new ArrayList<>()).add(parentEmail);
            }
        }

        List<List<String>> result = new ArrayList<>();
        Map<String, Boolean> isVisited = new LinkedHashMap<>();
        for (Map.Entry<String, List<String>> e : graph.entrySet()) {
            String parentEmail = e.getKey();
            if (isVisited.containsKey(parentEmail))
                continue;

            List<String> connectedEmail = new ArrayList<>();
            dfs(graph, parentEmail, connectedEmail, isVisited);

            Collections.sort(connectedEmail);
            connectedEmail.add(0, emailToName.get(parentEmail));
            result.add(new ArrayList<>(connectedEmail));
            connectedEmail.clear();
        }
        return result;
    }

    private void dfs(Map<String, List<String>> graph, String parentEmail, List<String> connectedEmail, Map<String, Boolean> isVisited) {
        if (!isVisited.containsKey(parentEmail)) {
            isVisited.put(parentEmail, true);
            connectedEmail.add(parentEmail);
            for (String childEmail : graph.get(parentEmail)) {
                dfs(graph, childEmail, connectedEmail, isVisited);
            }
        }
    }
}
