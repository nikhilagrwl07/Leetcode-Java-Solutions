package practice;

import java.sql.Timestamp;
import java.util.*;

public class RenamePhotosInAlbum {
    public static void main(String[] args) {
        RenamePhotosInAlbum ob = new RenamePhotosInAlbum();
        String s1 = "photo.jpg, Warsaw, 2013-09-05 14:08:15\n" +
                "john.png, London, 2015-06-20 15:13:22\n" +
                "myFriends.png, Warsaw, 2013-09-05 14:07:13\n" +
                "Eiffel.jpg, Paris, 2015-07-23 08:03:02\n" +
                "pisatower.jpg, Paris, 2015-07-22 23:59:59\n" +
                "BOB.jpg, London, 2015-08-05 00:02:03\n" +
                "notredame.png, Paris, 2015-09-01 12:00:00\n" +
                "me.jpg, Warsaw, 2013-09-06 15:40:22\n" +
                "a.png, Warsaw, 2016-02-13 13:33:50\n" +
                "b.jpg, Warsaw, 2016-01-02 15:12:22\n" +
                "c.jpg, Warsaw, 2016-01-02 14:34:30\n" +
                "d.jpg, Warsaw, 2016-01-02 15:15:01\n" +
                "e.png, Warsaw, 2016-01-02 09:49:09\n" +
                "f.png, Warsaw, 2016-01-02 10:55:32\n" +
                "g.jpg, Warsaw, 2016-02-29 22:13:11";

        String s2 = "john.png, London, 2015-06-20 15:13:22\n" +
                "photo.jpg, Warsaw, 2013-09-05 14:08:15\n" +
                "g.jpg, Warsaw, 2016-02-29 22:13:11";

        System.out.println(ob.solution(s1));
        System.out.println("-------");
        System.out.println(ob.solution(s2));
    }

    public String solution(String input) {
        Map<String, List<EachLine>> inputGroupByLocation = new LinkedHashMap<>();
        StringBuilder sb = new StringBuilder();
        List<EachLine> orderedList = new LinkedList<>();
        Map<EachLine, String> eachLineStringMap = new HashMap<>();

        String[] splitString = input.split("\\r?\\n");
        for (String line : splitString) {
            String[] split = line.split("\\s*,\\s*");
            EachLine eachLine = new EachLine(split[0].split("\\.")[1], split[1], Timestamp.valueOf(split[2]));
            orderedList.add(eachLine);

            List<EachLine> defaultList = inputGroupByLocation.getOrDefault(eachLine.getLocation(), new ArrayList<>());
            defaultList.add(eachLine);
            inputGroupByLocation.put(eachLine.getLocation(), defaultList);
        }

        for (Map.Entry<String, List<EachLine>> e : inputGroupByLocation.entrySet()) {
            List<EachLine> lines = e.getValue();
            lines.sort(Comparator.comparing(EachLine::getTimestamp));
            int count = getDigitCountInNumber(lines);
            String format = "%0" + count + "d";
            int t = 1;
            for (EachLine eachLine : lines) {
                eachLineStringMap.put(eachLine, eachLine.getLocation() + (String.format(format, t++)) + "." + (eachLine.getExtension()));
            }
        }

        for (EachLine eachLine : orderedList) {
            sb.append(eachLineStringMap.get(eachLine)).append("\n");
        }

        return sb.toString().substring(0, sb.length() - 1);
    }

    private int getDigitCountInNumber(List<EachLine> lines) {
        int num = lines.size();
        int count = 0;
        while (num != 0) {
            num = num / 10;
            count++;
        }
        return count;
    }

    class EachLine {
        private String extension;
        private String location;
        private Timestamp timestamp;

        public EachLine(String extension, String location, Timestamp timestamp) {
            this.extension = extension;
            this.location = location;
            this.timestamp = timestamp;
        }

        public String getExtension() {
            return extension;
        }

        public String getLocation() {
            return location;
        }

        public Timestamp getTimestamp() {
            return timestamp;
        }
    }


}
