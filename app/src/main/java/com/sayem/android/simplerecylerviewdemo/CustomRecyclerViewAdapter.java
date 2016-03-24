package com.sayem.android.simplerecylerviewdemo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sayem on 3/24/2016.
 */
public class CustomRecyclerViewAdapter extends RecyclerView.Adapter<CustomRecyclerViewAdapter.ItemViewHolder> {

    private List<ItemModel> itemModels;

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        holder.bindItem(getItemModels().get(position));
    }

    @Override
    public int getItemCount() {
        return getItemModels() != null ? getItemModels().size() : 0;
    }

    public List<ItemModel> getItemModels() {
        return itemModels;
    }

    public void setItemModels(List<ItemModel> itemModels) {
        this.itemModels = itemModels;
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final TextView titleTextView;
        private final TextView descriptionTextView;

        public ItemViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            titleTextView = (TextView) itemView.findViewById(R.id.textViewTitle);
            descriptionTextView = (TextView) itemView.findViewById(R.id.textViewDescription);
        }

        public void bindItem(ItemModel itemModel) {
            titleTextView.setText(itemModel.getTitle());
            descriptionTextView.setText(itemModel.getDescription());
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(v.getContext(), "position clicked " + getAdapterPosition(), Toast.LENGTH_SHORT).show();
        }
    }
}
