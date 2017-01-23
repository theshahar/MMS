package com.example.shaharraz.mms.models;


/**
 * Created by ShaharRaz on 20/01/2017.
 */
public class MovieResponse {


    /**
     * unit : 84
     * show_id : 60032563
     * show_title : Kill Bill: Vol. 2
     * release_year : 2004
     * rating : 3.8
     * category : Action & Adventure
     * show_cast : Uma Thurman, David Carradine, Michael Madsen, Daryl Hannah, Gordon Liu, Michael Parks, Perla Haney-Jardine, Helen Kim, Claire Smithies, Clark Middleton
     * director : Quentin Tarantino
     * summary : The Bride has three left on her rampage list: Budd, Elle Driver and Bill himself. But when she arrives at Bill's house, she's in for a surprise.
     * poster : http://netflixroulette.net/api/posters/60032563.jpg
     * mediatype : 0
     * runtime : 137 min
     */

    private int unit;
    private int show_id;
    private String show_title;
    private String release_year;
    private String rating;
    private String category;
    private String show_cast;
    private String director;
    private String summary;
    private String poster;
    private int mediatype;
    private String runtime;

    public int getUnit() {
        return unit;
    }

    public int getShow_id() {
        return show_id;
    }


    public String getShow_title() {
        return show_title;
    }


    public String getRelease_year() {
        return release_year;
    }

    public String getRating() {
        return rating;
    }

    public String getCategory() {
        return category;
    }

    public String getShow_cast() {
        return show_cast;
    }

    public String getDirector() {
        return director;
    }

    public String getSummary() {
        return summary;
    }

    public String getPoster() {
        return poster;
    }

    public int getMediatype() {
        return mediatype;
    }

    public String getRuntime() {
        return runtime;
    }

}
