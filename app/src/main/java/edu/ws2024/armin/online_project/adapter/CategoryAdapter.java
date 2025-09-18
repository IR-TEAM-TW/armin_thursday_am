package edu.ws2024.armin.online_project.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.ws2024.armin.online_project.R;
import edu.ws2024.armin.online_project.data.Category;
import edu.ws2024.armin.online_project.databinding.CategoryListItemBinding;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    private Context context;
    private List<Category> categories;

    public CategoryAdapter(Context context, List<Category> categories) {
        this.context = context;
        this.categories = categories;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CategoryListItemBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(context),
                R.layout.category_list_item,
                parent,
                false
        );

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Category category = categories.get(position);

        if (category.isSelected()) {
            holder.binding.txtCategory.setBackground(ContextCompat.getDrawable(
                    context,
                    R.drawable.custom_chip_checked
            ));
            holder.binding.txtCategory.setCompoundDrawables(
                    null,
                    null,
                    ContextCompat.getDrawable(context, R.drawable.baseline_check_24),
                    null
            );
            holder.binding.txtCategory.setTextColor(ContextCompat.getColor(context, R.color.green));
        }
        else {
            holder.binding.txtCategory.setBackground(ContextCompat.getDrawable(
                    context,
                    R.drawable.custom_chip
            ));
            holder.binding.txtCategory.setCompoundDrawables(
                    null,
                    null,
                    null,
                    null
            );
            holder.binding.txtCategory.setTextColor(ContextCompat.getColor(context, R.color.gray));
        }

        holder.binding.txtCategory.setText(category.getTitle());
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private CategoryListItemBinding binding;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public ViewHolder(@NonNull CategoryListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
