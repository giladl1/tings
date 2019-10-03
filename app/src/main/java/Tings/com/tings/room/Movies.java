package Tings.com.tings.room;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Created by giladl1 on 5/13/2018.
 */
@Entity
public class Movies {
    @NonNull
    @PrimaryKey
    private String title;
    private String image;
    private String rating;
    private String relaseYear;
//    private Genre[] genres;
//    private String movieId;
//    private String movieName;
//    private String movieTime;
//    private String movieLat;
//    private String movieLong;
//    private String movieSpeed;

    public Movies() {
    }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getImage() { return image; }
    public void setImage (String image) { this.image = image; }

    public String getRating() { return rating; }
    public void setRating(String rating) {
        this.rating = rating;
    }
    public String getRelaseYear() { return relaseYear; }
    public void setRelaseYear(String relaseYear) {
        this.relaseYear = relaseYear;
    }
//    public Genre[] getGenres() { return genres; }
//    public void setGenres(Genre[] genres) {
//        this.genres = genres;
//    }//todo check it

//    public String getMovieSpeed() { return movieSpeed; }
//    public void setMovieSpeed(String movieSpeed) {
//        this.movieSpeed = movieSpeed;
//    }
    public class Genre{
        int genreId;
        String genreTitle;
        public Genre(int genreId,String genreTitle){
            this.genreId=genreId;
            this.genreTitle=genreTitle;
        }


}
}

