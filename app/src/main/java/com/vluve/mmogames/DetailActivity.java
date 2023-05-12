package com.vluve.mmogames;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import android.os.Bundle;


public class DetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        int db_id = getIntent().getIntExtra("DB_ID", -1);
        FragmentManager fragmentManager = getSupportFragmentManager();

        // получаем фрагмент по ID
        DetailFragment fragment = (DetailFragment) fragmentManager
                .findFragmentById(R.id.fragment_detail);

        // передаём id модели
        if (fragment != null)
            fragment.setDb_id(db_id);
    }


}