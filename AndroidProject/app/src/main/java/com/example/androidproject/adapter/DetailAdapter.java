package com.example.androidproject.adapter;
import android.app.Activity;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidproject.DetailActivity;
import com.example.androidproject.databinding.ItemDetailBinding;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;

import android.app.Activity;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidproject.DetailActivity;
import com.example.androidproject.databinding.ItemDetailBinding;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;

// 항목 구성에 필요한 뷰 객체 가짐
class DetailViewHolder extends RecyclerView.ViewHolder{
    ItemDetailBinding binding;
    DetailViewHolder(ItemDetailBinding binding){
        super(binding.getRoot());
        this.binding = binding;
    }
}

// 항목을 구성
public class DetailAdapter extends RecyclerView.Adapter<DetailViewHolder> {
    ArrayList<Map<String, String>> datas;
    Activity context;
    public DetailAdapter(Activity context, ArrayList<Map<String, String>> datas){
        this.context = context;
        this.datas = datas;
    }
    @Override
    public int getItemCount() {
        return datas.size();
    }

    @NonNull
    @Override
    public DetailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemDetailBinding binding = ItemDetailBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new DetailViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailViewHolder holder, int position) {
        // Map 하나가 시험 하나
        Map<String, String> score = datas.get(position);
        holder.binding.detailItemScore.setText(score.get("score"));
        holder.binding.detailItemDate.setText(score.get("date"));
    }

}
