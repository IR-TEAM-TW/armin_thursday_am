package edu.ws2024.armin.online_project.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.ws2024.armin.online_project.R;
import edu.ws2024.armin.online_project.data.Data;
import edu.ws2024.armin.online_project.databinding.ProfileListItemBinding;

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ViewHolder> {

    private Context context;
    private List<Data> allData;

    public ProfileAdapter(Context context, List<Data> allData) {
        this.context = context;
        this.allData = allData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ProfileListItemBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(context),
                R.layout.profile_list_item,
                parent,
                false
        );

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Data data = allData.get(position);
        holder.binding.txtItem.setText(data.getName());

    }

    @Override
    public int getItemCount() {
        return allData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ProfileListItemBinding binding;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public ViewHolder(@NonNull ProfileListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
