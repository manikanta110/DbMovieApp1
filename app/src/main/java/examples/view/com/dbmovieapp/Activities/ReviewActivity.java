package examples.view.com.dbmovieapp.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import examples.view.com.dbmovieapp.Adapters.ListAdapter;
import examples.view.com.dbmovieapp.Api.Client;
import examples.view.com.dbmovieapp.Api.Service;
import examples.view.com.dbmovieapp.Feed.Feed;
import examples.view.com.dbmovieapp.Feed.Result;
import examples.view.com.dbmovieapp.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReviewActivity extends AppCompatActivity {
    ListView list;
    List<Result> datalist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);
        list = (ListView)findViewById(R.id.lisyview);
        getdata();


    }

    private void getdata() {
        Service service = Client.getRetrofit().create(Service.class);
        Call<Feed> call = service.getResults();
        call.enqueue(new Callback<Feed>() {
            @Override
            public void onResponse(Call<Feed> call, Response<Feed> response) {
                try{
                 List<Result>   datalist = response.body().getResults();
                    list.setAdapter(new ListAdapter(getApplicationContext(),datalist));
                }catch (NullPointerException e){
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<Feed> call, Throwable t) {
                Toast.makeText(ReviewActivity.this,"Error Occured",Toast.LENGTH_LONG).show();

            }
        });

    }
}
