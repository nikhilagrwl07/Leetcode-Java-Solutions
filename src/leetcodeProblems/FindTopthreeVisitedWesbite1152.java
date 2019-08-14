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

        String[] username = {"h","eiy","cq","h","cq","txldsscx","cq","txldsscx","h","cq","cq"};
        int[] timestamp = {527896567,334462937,517687281,134127993,859112386,159548699,51100299,444082139,926837079,317455832,411747930};
        String[] website = {"hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","yljmntrclw","hibympufi","yljmntrclw"};


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

        Comparator<Session> sortByTimeStamp = (o1, o2) -> {
            return o1.timeStamp - o2.timeStamp;
        };

        sessions.sort(sortByTimeStamp);

        Map<String, List<String>> userToWebsiteMapping = new HashMap<>();

        for (int i = 0; i < n; i++) {
            userToWebsiteMapping.putIfAbsent(sessions.get(i).user, new ArrayList<>());
            userToWebsiteMapping.get(sessions.get(i).user).add(sessions.get(i).website);
        }

        Map<String, Integer> websiteToUserCountMapping = new HashMap<>();
        String maxFrequString = "";
        int maxFreq = 0;

        for (Map.Entry<String, List<String>> e : userToWebsiteMapping.entrySet()) {

            if (userToWebsiteMapping.get(e.getKey()) == null ||
                    userToWebsiteMapping.get(e.getKey()).size() < 3) {
                continue;
            }

            Set<String> websiteSubSequences = generateSubSequenceOfWebsite(e.getValue());

            for (String subseq : websiteSubSequences) {
                websiteToUserCountMapping.put(subseq,
                        websiteToUserCountMapping.getOrDefault(subseq, 0) + 1);

                if (websiteToUserCountMapping.get(subseq) > maxFreq) {
                    maxFreq = websiteToUserCountMapping.get(subseq);
                    maxFrequString = subseq;
                } else if (websiteToUserCountMapping.get(subseq) == maxFreq) {

                    if (subseq.compareTo(maxFrequString) < 0)
                        maxFrequString = subseq;
                }
            }
        }

        return Arrays.asList(maxFrequString.split(","));
    }

    // Time Complexity - O(N^3)
    private Set<String> generateSubSequenceOfWebsite(List<String> website) {

        Set<String> sub = new HashSet<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < website.size(); i++) {
            for (int j = i + 1; j < website.size(); j++) {
                for (int k = j + 1; k < website.size(); k++) {
                    sb.append(website.get(i));
                    sb.append(",");
                    sb.append(website.get(j));
                    sb.append(",");
                    sb.append(website.get(k));
                    sub.add(sb.toString());
                    sb.setLength(0);
                }
            }
        }

        return sub;

    }

    class Session {
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
    }
}
