package java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LambdaMovieExample {
    public static void main(String[] args) {
        Movie m1 = new Movie("m2", 100L);
        Movie m2 = new Movie("m1", 200L);
        List<Movie> movies = new ArrayList<>();
        movies.add(m1);
        movies.add(m2);

        System.out.println("Before sorting --> " + movies);
        Collections.sort(movies, (o1, o2) -> o1.getName().compareTo(o2.getName()));
        System.out.println("After sorting --> " + movies);
    }
}

class Movie {
    String name;
    long duration;

    public Movie(String name, long duration) {
        this.name = name;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public long getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", duration=" + duration +
                '}';
    }
}
