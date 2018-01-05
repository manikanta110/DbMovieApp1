package examples.view.com.dbmovieapp.Api;


import examples.view.com.dbmovieapp.Feed.Feed;
import examples.view.com.dbmovieapp.TopRatedMovies.TopMovie;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by user on 08-Oct-17.
 */

public interface Service {
    @GET("movie/278/reviews?api_key=81c4047a8486904dd6cf0787b4b47dc9&language=en-US&page=1")
   Call<Feed> getResults();

    @GET("movie/top_rated")
    Call<TopMovie> getmovies(@Query("api_key") String api);

    @GET("movie/popular")
    Call<TopMovie> getpopularmovies(@Query("api_key") String api);

    @GET("movie/upcoming")
    Call<TopMovie> getupcomingmovies(@Query("api_key") String api);
}
