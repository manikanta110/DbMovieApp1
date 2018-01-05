package examples.view.com.dbmovieapp.Activities;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

import examples.view.com.dbmovieapp.Adapters.TopRatedMovieAdapter;
import examples.view.com.dbmovieapp.Api.Client;
import examples.view.com.dbmovieapp.Api.Service;
import examples.view.com.dbmovieapp.R;
import examples.view.com.dbmovieapp.TopRatedMovies.Result;
import examples.view.com.dbmovieapp.TopRatedMovies.TopMovie;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TopRatedActivity extends AppCompatActivity {
    RecyclerView recyclerView;
      List<Result> movielist;
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_rated);
        recyclerView =(RecyclerView)findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        initviews();
    }

    private void initviews() {
        pd = new ProgressDialog(this);
        pd.setMessage("Fetching data..........");
        pd.setCancelable(false);
        pd.show();


        loadJsondata();
    }

    private void loadJsondata() {
        Service  service = Client.getRetrofit().create(Service.class);

        Call<TopMovie> call = service.getmovies("81c4047a8486904dd6cf0787b4b47dc9");
        call.enqueue(new Callback<TopMovie>() {
            @Override
            public void onResponse(Call<TopMovie> call, Response<TopMovie> response) {
                pd.hide();
              List<Result> movies =response.body().getResults();
                recyclerView.setAdapter(new TopRatedMovieAdapter(getApplicationContext(),movies));
                recyclerView.smoothScrollToPosition(0);
                pd.dismiss();

            }

            @Override
            public void onFailure(Call<TopMovie> call, Throwable t) {
                pd.hide();
                Toast.makeText(TopRatedActivity.this,"Error Occured",Toast.LENGTH_LONG).show();
                pd.dismiss();

            }
        });
    }
}
