package examples.view.com.dbmovieapp.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import examples.view.com.dbmovieapp.R;

public class MainActivity extends AppCompatActivity {
    Button reviews,toprated,popular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        reviews = (Button)findViewById(R.id.main_btn_reviews);
        toprated = (Button)findViewById(R.id.main_btn_toprated);
        popular = (Button)findViewById(R.id.main_btn_popular);

        reviews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,ReviewActivity.class));

            }
        });

        toprated.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              startActivity(new Intent(MainActivity.this,TopRatedActivity.class));
            }
        });


        popular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,PopularActivity.class));

            }
        });
    }


}
