package com.example.android3lesson2.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.android3lesson2.databinding.ItemHolderBinding;
import com.example.android3lesson2.network.model.Hits;

import java.util.ArrayList;
import java.util.List;

public class AdapterWords extends RecyclerView.Adapter<AdapterWords.HomeAdapter> {
    List<Hits> list = new ArrayList<>();

    @NonNull
    @Override
    public HomeAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HomeAdapter(ItemHolderBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull HomeAdapter holder, int position) {
        holder.onBind(list.get(position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setList(List<Hits> list) {
        this.list = list;
    }

    public class HomeAdapter extends RecyclerView.ViewHolder {
        private final ItemHolderBinding binding;

        public HomeAdapter(@NonNull ItemHolderBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void onBind(Hits model) {
            Glide.with(binding.ivImage).load(model.getLargeImageURL()).into(binding.ivImage);

        }
    }
}
