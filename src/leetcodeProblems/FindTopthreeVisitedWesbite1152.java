package leetcodeProblems;

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

//        String[] username = {"u1", "u1", "u1", "u2", "u2", "u2"};
//        int[] timestamp = {1, 2, 3, 4, 5, 6};
//        String[] website = {"a", "b", "c", "a", "b", "a"};

        String[] username = {"h", "eiy", "cq", "h", "cq", "txldsscx", "cq", "txldsscx", "h", "cq", "cq"};
        int[] timestamp = {527896567, 334462937, 517687281, 134127993, 859112386, 159548699, 51100299, 444082139, 926837079, 317455832, 411747930};
        String[] website = {"hibympufi", "hibympufi", "hibympufi", "hibympufi", "hibympufi", "hibympufi", "hibympufi", "hibympufi", "yljmntrclw", "hibympufi", "yljmntrclw"};
//

        List<String> mostVisitedWebsite = ob.mostVisitedPattern(username, timestamp, website);
        System.out.println(mostVisitedWebsite);

    }

    // Time Complexity - O(N^3)
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {

        int n = username.length;
        List<Session> sessions = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            sessions.add(new Session(username[i], timestamp[i], website[i]));
        }

        Collections.sort(sessions, Comparator.comparingInt(o -> o.timeStamp));

        Map<String, List<String>> userToSession = getUserToWebsiteMapping(sessions);

        Map<String, Set<String>> sequenceToUsers = new HashMap<>();

        int maxFreq = Integer.MIN_VALUE;
        String maxFreqSeq = "";
        for (Map.Entry<String, List<String>> e : userToSession.entrySet()) {
            String user = e.getKey();
            List<String> websites = e.getValue();
            Set<String> seqS = generate3Sequence(new ArrayList<>(websites));

            for (String seq : seqS) {
                if (sequenceToUsers.containsKey(seq)) {
                    Set<String> strings = sequenceToUsers.get(seq);
                    strings.add(user);
                    sequenceToUsers.put(seq, strings);
                } else {
                    Set<String> value = new HashSet<>();
                    value.add(user);
                    sequenceToUsers.put(seq, value);
                }

                if (sequenceToUsers.get(seq).size() > maxFreq) {
                    maxFreqSeq = seq;
                    maxFreq = sequenceToUsers.get(seq).size();
                } else if (sequenceToUsers.get(seq).size() == maxFreq && seq.compareTo(maxFreqSeq) < 0) {
                    maxFreqSeq = seq;
                    maxFreq = sequenceToUsers.get(seq).size();
                }
            }
        }
        return Arrays.asList(maxFreqSeq.split(","));
    }

    private Map<String, List<String>> getUserToWebsiteMapping(List<Session> sessions) {

        Map<String, List<String>> userToWebsites = new HashMap<>();

        for (Session session : sessions) {
            if (userToWebsites.containsKey(session.getUser())) {
                List<String> list = userToWebsites.get(session.getUser());
                list.add(session.getWebsite());
                userToWebsites.put(session.getUser(), list);
            } else {
                List<String> list = new ArrayList<>();
                list.add(session.getWebsite());
                userToWebsites.put(session.getUser(), list);
            }
        }
        return userToWebsites;
    }

    private Set<String> generate3Sequence(List<String> sortedList) {

        Set<String> result = new HashSet<>();

        for (int i = 0; i <= sortedList.size() - 3; i++) {
            for (int j = i + 1; j <= sortedList.size() - 2; j++) {
                for (int k = j + 1; k <= sortedList.size() - 1; k++) {
                    String sb = sortedList.get(i) + "," +
                            sortedList.get(j) + "," +
                            sortedList.get(k);
                    result.add(sb);
                }
            }
        }
        return result;
    }

    static class Session {
        String user;
        int timeStamp;
        String website;

        public Session(String website) {
            this.website = website;
        }

        public Session(String user, int timeStamp, String website) {
            this.user = user;
            this.timeStamp = timeStamp;
            this.website = website;
        }

        public String getUser() {
            return user;
        }

        public int getTimeStamp() {
            return timeStamp;
        }

        public String getWebsite() {
            return website;
        }
    }
}
