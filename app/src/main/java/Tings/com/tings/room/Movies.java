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
    private Double rating;
    private Integer relaseYear;
//    private Genre[] genres;
//    private String movieId;
//    private String movieName;
//    private String movieTime;
//    private String movieLat;
//    private String movieLong;
//    private String movieSpeed;

    public Movies() {
        title=null;
        image=null;
        rating=null;
        relaseYear=null;

    }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getImage() { return image; }
    public void setImage (String image) { this.image = image; }

    public Double getRating() { return rating; }
    public void setRating(Double rating) {
        this.rating = rating;
    }
    public Integer getRelaseYear() { return relaseYear; }
    public void setRelaseYear(Integer relaseYear) {
        this.relaseYear = relaseYear;
    }
//    public Genre[] getGenres() { return genres; }
//    public void setGenres(Genre[] genres) {
//        this.genres = genres;
    }//todo check it

//    public String getMovieSpeed() { return movieSpeed; }
//    public void setMovieSpeed(String movieSpeed) {
//        this.movieSpeed = movieSpeed;
//    }
    class Genre{
//        int genreId;
        String genreTitle;
        public Genre(String genreTitle){
//            this.genreId=genreId;
            this.genreTitle=genreTitle;
        }


}
//}

