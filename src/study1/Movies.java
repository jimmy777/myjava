package study1;

import libs.DVDCollection;

public class Movies {
    // 例子：8.3B Movies
    public static void main(String[] args) {
        // DVD 集合对象；
        DVDCollection movies = new DVDCollection();

        movies.addDVD("The Godfather", "Francis Ford Coppola", 1972, 24.95, true);
        movies.addDVD("District 9", "Neill Blomkamp", 2009, 19.95, false);

        System.out.println(movies);
    }
}
