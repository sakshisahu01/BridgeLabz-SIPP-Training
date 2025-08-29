package JavaStreamApi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Top5TrendingMovies {

    static class Movie {
        String title;
        double rating;
        int releaseYear;

        public Movie(String title, double rating, int releaseYear) {
            this.title = title;
            this.rating = rating;
            this.releaseYear = releaseYear;
        }

        public String getTitle() {
            return title;
        }

        public double getRating() {
            return rating;
        }

        public int getReleaseYear() {
            return releaseYear;
        }

        @Override
        public String toString() {
            return "Movie{title='" + title + "', rating=" + rating + ", releaseYear=" + releaseYear + "}";
        }
    }

    public static void main(String[] args) {
        List<Movie> movies = Arrays.asList(
                new Movie("Movie A", 8.5, 2022),
                new Movie("Movie B", 9.1, 2023),
                new Movie("Movie C", 8.8, 2022),
                new Movie("Movie D", 7.9, 2021),
                new Movie("Movie E", 9.5, 2023),
                new Movie("Movie F", 8.2, 2022),
                new Movie("Movie G", 9.0, 2023)
        );

        // Find the top 5 movies based on rating (descending) and then release year (descending)
        List<Movie> top5Movies = movies.stream()
                .sorted(Comparator.comparing(Movie::getRating).reversed()
                        .thenComparing(Movie::getReleaseYear).reversed())
                .limit(5)
                .collect(Collectors.toList());

        System.out.println("Top 5 Trending Movies:");
        top5Movies.forEach(System.out::println);
    }
}