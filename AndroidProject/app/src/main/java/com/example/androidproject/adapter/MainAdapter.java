package com.example.androidproject.adapter;

import static androidx.activity.result.ActivityResultCallerKt.registerForActivityResult;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.core.content.PackageManagerCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidproject.DetailActivity;
import com.example.androidproject.MainActivity;
import com.example.androidproject.R;
import com.example.androidproject.databinding.ItemMainBinding;
import com.example.androidproject.db.DBHelper;
import com.example.androidproject.model.Student;
import com.example.androidproject.util.BitmapUtil;
import com.example.androidproject.util.DialogUtil;

import java.util.ArrayList;
import java.util.List;

class MainViewHolder extends RecyclerView.ViewHolder{
    ItemMainBinding binding;
    MainViewHolder(ItemMainBinding binding){
        super(binding.getRoot());
        this.binding = binding;
    }
}

public class MainAdapter extends RecyclerView.Adapter<MainViewHolder>{
    ArrayList<Student> datas; //항목 구성 데이터들... activity가 전달할 것이다..
    Activity context;
    ActivityResultLauncher<Intent> addPhotoLauncher;

    //    public MainAdapter(Activity context, ArrayList<Student> datas){
//        this.datas = datas;
//        this.context = context;
//    }
    public MainAdapter(Activity context, ArrayList<Student> datas, ActivityResultLauncher<Intent> addPhotoLauncher) {
        this.context = context;
        this.datas = datas;
        this.addPhotoLauncher = addPhotoLauncher;
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemMainBinding binding = ItemMainBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false
        );
        return new MainViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        Student student = datas.get(position);
        holder.binding.itemNameView.setText(student.getName());

        holder.binding.itemImageView.setOnClickListener(view ->{
            // 이미지 상세보기로 가정.. 다이얼로그 띄운다...
            DialogUtil.showCustomDialog(context, R.drawable.ic_student_large);

        });

        Bitmap bitmap = BitmapUtil.getGalleryBitmapFromFile(context, student.getPhoto());
        if(bitmap != null)
            holder.binding.itemImageView.setImageBitmap(bitmap);


        holder.binding.itemNameView.setOnClickListener(view -> {
            Intent intent = new Intent(context, DetailActivity.class);
            //넘길 데이터는 있는가???? 있다.. 학생의 식별자 값...
            intent.putExtra("id", student.getId());
            //되돌아 왔을때 사후 처리가 있는가???? - 없다..
            // ***************
            // 사후 처리 있음... 이미지 바꾼거 주소 받아와야함
            // 사후 처리 있으니까 launcher 등록..
            //context.startActivity(intent);
            addPhotoLauncher.launch(intent);
        });

        holder.binding.itemCallView.setOnClickListener(view ->{
            if(ContextCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED){
                callPhone(student.getPhone());
            }else{
                DialogUtil.showToast(context, context.getString(R.string.permission_denied));
            }
        });

    }

    private void callPhone(String phoneNumber){
        if(phoneNumber != null && !phoneNumber.equals("")){
            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phoneNumber));
            context.startActivity(intent);
        }else {
            DialogUtil.showToast(context, context.getString(R.string.main_list_phone_error));
        }
    }

}
