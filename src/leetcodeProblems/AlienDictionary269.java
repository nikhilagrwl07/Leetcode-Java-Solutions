/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package leetcodeProblems;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class AlienDictionary269 {
    public static void main(String[] args) {
//        String[] dict = {
//                "wrt",
//                "wrf",
//                "er",
//                "ett",
//                "rftt"
//        };

//        String[] dict = {
//                "z",
//                "z"};

                String[] dict = {
                "z",
                "x"};

        AlienDictionary269 ob = new AlienDictionary269();
        String order = ob.alienOrder(dict);
        System.out.println(order);
    }


    Map<Character, Character> adjList;
    private boolean isPossible;
    Map<Character, String> nodeToStatus;
    Stack<Character> topoloigcalOrder;
    StringBuilder result = new StringBuilder();
    Character lastChar = null;

    public String alienOrder(String[] words) {
        initialize(words);

        for (Character e : nodeToStatus.keySet()) {
            if (nodeToStatus.get(e).equals("UNPROCESSED")) {
                dfs(e);
            }
        }


        if (isPossible) {
            while (!topoloigcalOrder.isEmpty()) {
                result.append(topoloigcalOrder.pop());
            }
        }


        if (lastChar != null) {
            result.append(lastChar);
        }
        return result.toString();
    }


    private void dfs(char vertex) {

        if (!isPossible) {
            return;
        }
        nodeToStatus.put(vertex, "IN_PROGRESS");

        Character destination = adjList.get(vertex);

        if (destination == '\0') {
            nodeToStatus.put(vertex, "COMPLETED");
            lastChar = vertex;
            return;
        }

        String destinationStatus = nodeToStatus.get(destination);

        if (destinationStatus.equals("UNPROCESSED")) {
            dfs(destination);
        } else if (destinationStatus.equals("IN_PROGRESS")) {

            if (destination != vertex) {
                isPossible = false;
                return;
            }
        }

        nodeToStatus.put(vertex, "COMPLETED");
        topoloigcalOrder.push(vertex);
    }

    private char getChar(int index) {
        return (char) (index + 97);
    }

    private void initialize(String[] words) {

        adjList = new HashMap<>(26);

        for (int i = 0; i <= words.length - 2; i++) {

            Pair<Character, Character> order = compareTwoString(words[i], words[i + 1]);

            if (order != null) {

                if (order.getKey() == order.getValue()) {
                    adjList.put(order.getKey(), '\0');
                } else {
                    adjList.put(order.getKey(), order.getValue());
                }


                adjList.putIfAbsent(order.getValue(), '\0');

            }
        }

        isPossible = true;
        nodeToStatus = new HashMap<>();

        for (Character e : adjList.keySet()) {
            nodeToStatus.put(e, "UNPROCESSED");
        }

        topoloigcalOrder = new Stack<>();
    }

    private Pair<Character, Character> compareTwoString(String s1, String s2) {

        if (s1.equals(s2)) {
            return new Pair<>(s1.charAt(s1.length()-1), s1.charAt(s1.length()-1));
        }
        int minLength = Math.min(s1.length(), s2.length());

        for (int i = 0; i < minLength; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return new Pair<>(s1.charAt(i), s2.charAt(i));
            }
        }
        return null;
    }
}
