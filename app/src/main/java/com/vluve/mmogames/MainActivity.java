package com.vluve.mmogames;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] courses = { "Программирование", "СД", "Матлогика",
                "Мат. анализ", "Алгебра", "Дискретная математика", "ТВП",
                "ТЯП", "ООП", "ФЛП", "Криптография", "Экономика",
                "Культурология", "ТРПО", "СППР", "Сети ЭВМ", "ОС",
                "Параллельное программирование", "Компьютерная графика" };
        CoursesAdapter adapter = new CoursesAdapter(courses);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}