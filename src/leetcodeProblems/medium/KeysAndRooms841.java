package leetcodeProblems.medium;

import java.util.*;

public class KeysAndRooms841 {
    public static void main(String[] args) {
        KeysAndRooms841 ob = new KeysAndRooms841();
        List<List<Integer>> keys = new ArrayList<>();
//        keys.add(Arrays.asList(1));
//        keys.add(Arrays.asList(2));
//        keys.add(Arrays.asList(3));
//        keys.add(Arrays.asList());

        keys.add(Arrays.asList(1,3));
        keys.add(Arrays.asList(3,0,1));
        keys.add(Arrays.asList(2));
        keys.add(Arrays.asList(0));

        boolean canVisitAllRooms = ob.canVisitAllRooms(keys);
        System.out.println(canVisitAllRooms);

    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        Queue<Integer> q = new LinkedList<>();
        boolean[] isVisited = new boolean[rooms.size()];
        int visitedRooms = 0;
        isVisited[0] = true;
        q.offer(0);

        while (!q.isEmpty()) {
            Integer currentRoom = q.poll();
            visitedRooms++;

            if (visitedRooms == rooms.size()) {
                return true;
            }

            for (Integer keysForNextRooms : rooms.get(currentRoom)) {
                if (!isVisited[keysForNextRooms]) {
                    q.offer(keysForNextRooms);
                    isVisited[keysForNextRooms] = true;
                }
            }
        }
        return false;

    }
}
