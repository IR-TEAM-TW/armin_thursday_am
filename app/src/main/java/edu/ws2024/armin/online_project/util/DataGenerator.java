package edu.ws2024.armin.online_project.util;

import android.content.Context;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import edu.ws2024.armin.online_project.R;
import edu.ws2024.armin.online_project.adapter.HomeAdapter;
import edu.ws2024.armin.online_project.adapter.ProfileAdapter;
import edu.ws2024.armin.online_project.data.Data;

public class DataGenerator {
    public static void GenerateRandomData(Context context, RecyclerView recyclerView, boolean type1) {
        List<Data> data = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            data.add(new Data("آیتم " + (i + 1), R.drawable.iphone_17));

        if (type1) {
            HomeAdapter adapter = new HomeAdapter(context, data);
            recyclerView.setLayoutManager(new LinearLayoutManager(
                    context, LinearLayoutManager.VERTICAL, false
            ));
            recyclerView.setAdapter(adapter);
        }
        else {
            ProfileAdapter adapter = new ProfileAdapter(context, data);
            recyclerView.setLayoutManager(new LinearLayoutManager(
                    context, LinearLayoutManager.VERTICAL, false
            ));
            recyclerView.setAdapter(adapter);
        }
    }
}
