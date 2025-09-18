package edu.ws2024.armin.online_project.view.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import edu.ws2024.armin.online_project.R;
import edu.ws2024.armin.online_project.adapter.HomeAdapter;
import edu.ws2024.armin.online_project.data.HomeData;
import edu.ws2024.armin.online_project.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<HomeData> data = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            data.add(new HomeData("آیتم " + (i + 1), R.drawable.iphone_17));

        HomeAdapter adapter = new HomeAdapter(getContext(), data);
        binding.itemsRecycler.setLayoutManager(new LinearLayoutManager(
                getContext(), LinearLayoutManager.VERTICAL, false
        ));
        binding.itemsRecycler.setAdapter(adapter);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        return binding.getRoot();
    }
}