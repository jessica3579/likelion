package com.example.androidproject;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.androidproject.databinding.ActivityChartBinding;
import com.example.androidproject.db.DBHelper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ChartActivity extends AppCompatActivity {
    ArrayList<Map<String, String>> scoreList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        ActivityChartBinding binding = ActivityChartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        int id = intent.getIntExtra("id", 0);

        // id로 데이터베이스에서 점수 목록 가져오기
        // 점수 목록이니까... 그냥 리스트.. 근데 몇개인지 모르니까 array list???
        // date도 가져와야할까...
        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor c = db.rawQuery("select score, date from tb_score where student_id = ? order by date", new String[]{String.valueOf(id)});
        scoreList = new ArrayList<>();
        while(c.moveToNext()){
            HashMap<String, String> map = new HashMap<>();
            map.put("score", c.getString(0));
            Date d = new Date(Long.parseLong(c.getString(1)));
            SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
            map.put("date", sd.format(d));
            scoreList.add(map);
        }
        db.close();

        Gson gson = new GsonBuilder().create();
        String jsonData = gson.toJson(scoreList);

        binding.charStudentName.setText(name);

        WebSettings settings = binding.chartWebView.getSettings();
        settings.setJavaScriptEnabled(true);

        binding.chartWebView.loadUrl("file:///android_asset/test.html");

        binding.chartWebView.addJavascriptInterface(new JavaScriptTest(jsonData), "android");
    }

    class JavaScriptTest{
        private final String jsonData;

        JavaScriptTest(String jsonData){
            this.jsonData = jsonData;
        }

        @JavascriptInterface
        public String getChartData(){
            return jsonData;
        }
    }
}