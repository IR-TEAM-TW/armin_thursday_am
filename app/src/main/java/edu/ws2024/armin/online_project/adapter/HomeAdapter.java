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
import edu.ws2024.armin.online_project.data.HomeData;
import edu.ws2024.armin.online_project.databinding.HomeListItemBinding;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {

    private Context context;
    private List<HomeData> allData;

    public HomeAdapter(Context context, List<HomeData> allData) {
        this.context = context;
        this.allData = allData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        HomeListItemBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(context),
                R.layout.home_list_item,
                parent,
                false
        );
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        HomeData data = allData.get(position);
        holder.binding.txtItem.setText(data.getName());
        holder.binding.itemImage.setImageResource(data.getImage());
    }

    @Override
    public int getItemCount() {
        return allData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private HomeListItemBinding binding;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public ViewHolder(@NonNull HomeListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
