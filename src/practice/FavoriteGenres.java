package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FavoriteGenres {
    public static void main(String[] args) {

    }

    public Map<String, List<String>> favoriteGenre(Map<String, List<String>> userSongs,
                                                   Map<String, List<String>> songGenres) {

        if (userSongs.isEmpty() || songGenres.isEmpty())
            return new HashMap<>();


        Map<String, String> songToGenreMap = new HashMap<>();

        for (Map.Entry<String, List<String>> e : songGenres.entrySet()) {
            for (String song : e.getValue()) {
                songToGenreMap.put(song, e.getKey());
            }
        }

        Map<String, Integer> genreFreq = new HashMap<>();
        Map<String, List<String>> result = new HashMap<>();

        for (Map.Entry<String, List<String>> e : userSongs.entrySet()) {

            int max = Integer.MIN_VALUE;
            for (String song : e.getValue()) {

                if (songToGenreMap.containsKey(song)) {
                    genreFreq.put(song, genreFreq.get(song) + 1);
                } else {
                    genreFreq.put(song, 1);
                }
                max = Math.max(max, genreFreq.get(song));
            }

            List<String> genres = new ArrayList<>();
            for (Map.Entry<String, Integer> e1 : genreFreq.entrySet()) {
                if (e1.getValue() == max) {
                    genres.add(e1.getKey());
                }
            }
            result.put(e.getKey(), genres);
        }

        return result;
    }
}
