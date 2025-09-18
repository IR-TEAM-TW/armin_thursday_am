package edu.ws2024.armin.online_project.view;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.List;

import edu.ws2024.armin.online_project.R;
import edu.ws2024.armin.online_project.adapter.CategoryAdapter;
import edu.ws2024.armin.online_project.data.Category;
import edu.ws2024.armin.online_project.databinding.ActivitySearchBinding;
import edu.ws2024.armin.online_project.util.DataGenerator;

public class SearchActivity extends AppCompatActivity {

    private ActivitySearchBinding binding;
    private List<Category> categories = DataGenerator.GetRandomCategories();
    private CategoryAdapter categoriesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_search);
        ViewCompat.setOnApplyWindowInsetsListener(binding.getRoot(), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setup();
    }

    private void setup() {
        setupCategories();
    }

    private void setupCategories() {
        categoriesAdapter = new CategoryAdapter(this, categories);
        binding.categoriesRecycler.setLayoutManager(new LinearLayoutManager(
                this,
                LinearLayoutManager.HORIZONTAL,
                true
        ));
        binding.categoriesRecycler.setAdapter(categoriesAdapter);
    }
}