package edu.ws2024.armin.online_project.view.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.ws2024.armin.online_project.R;
import edu.ws2024.armin.online_project.databinding.FragmentHomeBinding;
import edu.ws2024.armin.online_project.util.DataGenerator;
import edu.ws2024.armin.online_project.view.SearchActivity;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        DataGenerator.GenerateRandomData(getContext(), binding.itemsRecycler, true);
        binding.txtSearch.setOnClickListener(v ->
                startActivity(new Intent(getActivity(), SearchActivity.class))
        );
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        return binding.getRoot();
    }
}