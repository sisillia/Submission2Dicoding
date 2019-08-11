package com.example.myapplication;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import de.hdodenhof.circleimageview.CircleImageView;

public class DetailActivity extends AppCompatActivity {

    CircleImageView imgFilm;
    TextView titleFilm, yearOfFilm, descOfFilm;
    public static final String EXTRA_DATA = "extra_data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Film Detail");

        imgFilm = (CircleImageView) findViewById(R.id.img_film);
        titleFilm = (TextView) findViewById(R.id.tv_title_film);
        yearOfFilm = (TextView) findViewById(R.id.tv_year);
        descOfFilm = (TextView) findViewById(R.id.tv_desc_film);

        ListData listData = getIntent().getParcelableExtra(EXTRA_DATA);

        titleFilm.setText(listData.getName());
        yearOfFilm.setText(listData.getYear());
        descOfFilm.setText(listData.getLongDesc());
        Glide.with(this)
                .load(listData.getPhoto())
                .into(imgFilm);
    }
}
