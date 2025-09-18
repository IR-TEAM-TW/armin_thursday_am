package edu.ws2024.armin.online_project.view;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentTransaction;

import edu.ws2024.armin.online_project.R;
import edu.ws2024.armin.online_project.databinding.ActivityMainBinding;
import edu.ws2024.armin.online_project.view.fragments.HomeFragment;
import edu.ws2024.armin.online_project.view.fragments.ProfileFragment;
import edu.ws2024.armin.online_project.view.fragments.UsersFragment;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private LinearLayout[] navs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(binding.getRoot(), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setup();
    }

    private void setup() {
        setupNavigation();
    }

    private void setupNavigation() {
        navs = new LinearLayout[] {
                binding.navHome,
                binding.navGroups,
                binding.navProfile
        };

        for (LinearLayout nav : navs) {
            nav.setOnClickListener(v -> {
                navigate(nav.getId());
            });
        }

        navigate(binding.navHome.getId());
    }

    private void navigate(int id) {
        for (int i = 0; i < navs.length; i++) {
            LinearLayout nav = navs[i];
            ImageView image = (ImageView) nav.getChildAt(0);
            TextView text = (TextView) nav.getChildAt(1);
            if (navs[i].getId() == id) {
                image.setImageTintList(ContextCompat.getColorStateList(this, R.color.light_green));
                text.setTextColor(ContextCompat.getColor(this, R.color.light_green));
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

                if (id == binding.navHome.getId()) {
                    transaction.replace(binding.frame.getId(), new HomeFragment()).commit();
                }
                else if (id == binding.navProfile.getId()) {
                    transaction.replace(binding.frame.getId(), new ProfileFragment()).commit();
                }
                else {
                    transaction.replace(binding.frame.getId(), new UsersFragment()).commit();
                }
            }
            else {
                image.setImageTintList(ContextCompat.getColorStateList(this, R.color.gray));
                text.setTextColor(ContextCompat.getColor(this, R.color.gray));
            }
        }
    }
}