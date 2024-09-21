package com.example.mycv.viewmodel;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mycv.model.Repository;

import java.util.List;

public class ReposAdapter extends RecyclerView.Adapter<ReposAdapter.ViewHolder> {

    private List<Repository> repositoryList;

    public ReposAdapter(List<Repository> reposList) {
        this.repositoryList = reposList;
    }

    public void updateData(List<Repository> newRepos) {
        this.repositoryList = newRepos;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String repoName = repositoryList.get(position).getName();
        holder.repoNameTextView.setText(repoName);
    }

    @Override
    public int getItemCount() {
        return repositoryList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView repoNameTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            repoNameTextView = itemView.findViewById(android.R.id.text1);
        }
    }
}

