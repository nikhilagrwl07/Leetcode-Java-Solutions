package leetcodeProblems;

import javafx.util.Pair;

import java.util.*;

public class FindTopthreeVisitedWesbite1152 {
    public static void main(String[] args) {

        FindTopthreeVisitedWesbite1152 ob = new FindTopthreeVisitedWesbite1152();
//        String[] username = {"joe", "joe", "joe", "james", "james", "james", "james", "mary", "mary", "mary"};
//        int[] timestamp = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//        String[] website = {"home", "about", "career", "home", "cart", "maps", "home", "home", "about", "career"};


//        String[] username = {"dowg", "dowg", "dowg"};
//        int[] timestamp =  {158931262, 562600350, 148438945};
//        String[] website = {"y", "loedo", "y"};

        String[] username = {"u1", "u1", "u1", "u2", "u2", "u2"};
        int[] timestamp = {1, 2, 3, 4, 5, 6};
        String[] website = {"a", "b", "c", "a", "b", "a"};

//        String[] username = {"h", "eiy", "cq", "h", "cq", "txldsscx", "cq", "txldsscx", "h", "cq", "cq"};
//        int[] timestamp = {527896567, 334462937, 517687281, 134127993, 859112386, 159548699, 51100299, 444082139, 926837079, 317455832, 411747930};
//        String[] website = {"hibympufi", "hibympufi", "hibympufi", "hibympufi", "hibympufi", "hibympufi", "hibympufi", "hibympufi", "yljmntrclw", "hibympufi", "yljmntrclw"};
//

        List<String> mostVisitedWebsite = ob.mostVisitedPattern(username, timestamp, website);
        System.out.println(mostVisitedWebsite);

    }

    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {

        Map<String, TreeMap<Integer, String>> session = new TreeMap<>();

        for (int i = 0; i < username.length; i++) {
            TreeMap<Integer, String> tmpMap = session.getOrDefault(username[i], new TreeMap<>());
            tmpMap.put(timestamp[i], website[i]);
            session.put(username[i], tmpMap);
        }

        Map<Integer, List<String>> hashcodeToSequence = new HashMap<>();
        Map<Integer, List<String>> hashCodeToUser = new HashMap<>();

        Queue<Integer> pq = new PriorityQueue<Integer>((o1, o2) -> {
            int diff = hashCodeToUser.getOrDefault(o2, new ArrayList<>()).size() -
                    hashCodeToUser.getOrDefault(o1, new ArrayList<>()).size();

            if (diff != 0)
                return diff;

            List<String> s1 = hashcodeToSequence.get(o1);
            List<String> s2 = hashcodeToSequence.get(o2);
            for (int i = 0; i < 3; i++) {
                int diff2 = s1.get(i).compareTo(s2.get(i));
                if (diff2 != 0)
                    return diff2;
            }
            return -1;
        });

        for (Map.Entry<String, TreeMap<Integer, String>> e : session.entrySet()) {
            String userName = e.getKey();
            TreeMap<Integer, String> timeToWebsite = e.getValue();

            if (timeToWebsite.size() >= 3) {
                List<List<String>> sequences = threeVisitSubSequence(new ArrayList<String>(timeToWebsite.values()));
                for (List<String> sq : sequences) {
                    int hashcode = sq.hashCode();
                    List<String> tmp = hashCodeToUser.getOrDefault(hashcode, new ArrayList<>());
                    if (!tmp.contains(userName)) {
                        tmp.add(userName);
                        hashCodeToUser.put(hashcode, tmp);
                        hashcodeToSequence.put(hashcode, sq);
                        pq.offer(hashcode);
                    }
                }
            }
        }
        return hashcodeToSequence.get(pq.poll());
    }

    public List<List<String>> threeVisitSubSequence(List<String> websites) {
        List<List<String>> result = new ArrayList<>();
        String[] sub = new String[3];
        threeVisitSubSequenceUtil(websites, 0, sub, 0, result);
        return result;
    }

    private void threeVisitSubSequenceUtil(List<String> websites, int indexOfWebsite,
                                           String[] sub, int indexForSub,
                                           List<List<String>> result) {

        if (indexForSub > 2 || indexOfWebsite >= websites.size()) {
            return;
        }

        // not taken
        threeVisitSubSequenceUtil(websites, indexOfWebsite + 1, sub, indexForSub, result);


        // taken
        sub[indexForSub] = websites.get(indexOfWebsite);
        threeVisitSubSequenceUtil(websites, indexOfWebsite + 1, sub, indexForSub + 1, result);


        if (indexForSub == 2) {
            List<String> tmp = new ArrayList<>();
            for (int i = 0; i <= 2; i++) {
                tmp.add(sub[i]);
            }
            result.add(tmp);
        }

    }
}
