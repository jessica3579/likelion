package com.example.androidproject;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.androidproject.adapter.DetailAdapter;
import com.example.androidproject.databinding.ActivityDetailBinding;
import com.example.androidproject.db.DBHelper;
import com.example.androidproject.model.Student;
import com.example.androidproject.util.BitmapUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DetailActivity extends AppCompatActivity {

    ActivityDetailBinding binding;
    Student student;
    DetailAdapter adapter;
    // 시험 점수.. 목록 데이터.. db select해서 준비.. adapter에게 전달..
    ArrayList<Map<String, String>> scoreList;

    ActivityResultLauncher<Intent> requestGalleryLauncher;
    private String filePath;
    private String name;
    private String photoFilePath;
    CircleScoreView circleScoreView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        circleScoreView = findViewById(R.id.circleScore);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //actionbar -> toolbar
        setSupportActionBar(binding.toolbar);

        //background 이미지로 지정한 stroke color 가 적용이 안되어서..
        //button 이 기본으로 primary color 를 적용하고 있어서..
        //못하게 막은 것이다.
        binding.detailAddScoreBtn.setBackgroundTintList(null);
        binding.detailScoreChartBtn.setBackgroundTintList(null);
        binding.detailMemoBtn.setBackgroundTintList(null);

        //자신을 실행시키면서 전달한 데이터를 추출....
        int id = getIntent().getIntExtra("id", 0);

        //초기 데이터 화면에서 출력.. db select 해서...
        setInitStudentData(id);

        // 초기 이 액티비티가 실행되면서.. db select해서.. 시험 점수를 목록으로 출력..
        setInitScoreData(id);

        // ScoreAddActivity를 실행시킬 때.. 되돌아 왔을때 사후처리가 필요한가? 해당 점수를 띄워야하므로 필요함
        ActivityResultLauncher<Intent> addScoreLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                // score add activity에서 점수 입력하고 되돌아 왔을때 call back..
                result -> {
                    //  recycler view로 목록으로 띄워야함
                    Intent intent = result.getData();
                    // 점수, date 받아옴
                    String score = intent.getStringExtra("score");
                    long date = intent.getLongExtra("date", 0);

                    HashMap<String, String> map = new HashMap<>();
                    map.put("score", score);
                    // 데이터를 유저에게 뿌리리 문자열 포멧으로 변형해서...
                    Date d = new Date(date);
                    SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
                    map.put("date", sd.format(d));

                    circleScoreView.setProgress(Integer.parseInt(score));
                    scoreList.add(map);
                    // 새로운 항목 데이터가 추가된 것이다..
                    // adapter가 이미 항목을 만들어 놓았을 것이다.. 변경사항이 있다고 알려준다..
                    adapter.notifyDataSetChanged();

                }
        );

        binding.detailAddScoreBtn.setOnClickListener(view -> {
            Intent intent = new Intent(this, ScoreAddActivity.class);
            intent.putExtra("id", id);
            addScoreLauncher.launch(intent);
        });

        binding.detailScoreChartBtn.setOnClickListener(view -> {
            Intent intent = new Intent(this, ChartActivity.class);
            // 사후처리 필요한가... 필요 없음
            // 값 넘겨줘야하는가... Yes!! (이름, 성적)
            intent.putExtra("name", name);
            intent.putExtra("id", id);
            startActivity(intent);

        });

        // gallery 목록 화면 띄우는 launcher.... (사후 처리해야하니까 launcher)
        requestGalleryLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    try {
                        // gallery app 목록에서 사진 선택후 되돌아 온 것이다..
                        // 유저가 선택한 사진을 식별할 수 있는 식별자 값을 Uri 객체로 넘겨준다..
                        Uri uri = result.getData().getData();
                        // uri로 식별되는 사진의 경로를 획득한다.. db에 저장했다가 나중에 이용하기 위해...
                        String[] proj = new String[]{MediaStore.Images.Media.DATA}; // 사진 경로는 지칭하는 상수..
                        Cursor galleryCursor = getContentResolver().query(uri, proj, null, null, null);
                        if (galleryCursor != null) {
                            if (galleryCursor.moveToFirst()) {
                                // 사진 경로 얻고...
                                filePath = galleryCursor.getString(0);
                                Log.d("Lee", "id = " + student.getId());
                                Log.d("Lee", "filePath = " + filePath);
                                // 나중을 위해서 tb_student 테이블에 데이터 저장... column update..
                                DBHelper helper = new DBHelper(this);
                                SQLiteDatabase db = helper.getWritableDatabase();
                                db.execSQL("update tb_student set photo=? where _id=?", new String[]{filePath, String.valueOf(id)});
                                db.close();


                            }
                        }

                        new Thread(() -> {
                            // 되돌아 오자마자... 화면에 출력...
                            Bitmap bitmap = BitmapUtil.getGalleryBitmapFromStream(this, uri);
                            if (bitmap != null) {
                                runOnUiThread(()->binding.detailImage.setImageBitmap(bitmap));
                            }
                        }).start();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
        );


    }

    @Override
    public void onBackPressed() {
        if (filePath != null) {
            // 사진 고른 경우에만 결과 넘김
            Intent intent = new Intent();
            intent.putExtra("imagePath", filePath);
            intent.putExtra("id", student.getId());
            setResult(RESULT_OK, intent);
        } else {
            // 사진을 고르지 않았어도 RESULT_CANCELED로 명확히 반환
            setResult(RESULT_CANCELED);
        }
        super.onBackPressed(); // 화면 종료
    }

    private void setInitStudentData(int id) {
        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from tb_student where _id=?",
                new String[]{String.valueOf(id)});

        //이전에.. 유저가 프로필사진 지정을 했다면.. 어느 사진인지.. 사진 파일 경로가 db 에 저장..
        photoFilePath = null;

        if (cursor.moveToFirst()) {
            //db data...
            name = cursor.getString(1);
            String email = cursor.getString(2);
            String phone = cursor.getString(3);
            //화면 출력..
            binding.detailName.setText(name);
            binding.detailEmail.setText(email);
            binding.detailPhone.setText(phone);

            photoFilePath = cursor.getString(4);

            student = new Student(cursor.getInt(0), name, email, phone,
                    cursor.getString(5), photoFilePath);
        }

        db.close();

        new Thread(() -> {
            // db에 저장된 photo filepath로 화면 출력
            Bitmap bitmap = BitmapUtil.getGalleryBitmapFromFile(this, photoFilePath);
            if (bitmap != null)
                runOnUiThread(()-> binding.detailImage.setImageBitmap(bitmap));

        }).start();

        binding.detailImage.setOnClickListener(view -> {
            // intent로 gallery 목록 화면 실행...
            // 단, 외부 앱이므로 암시적 intent
            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            intent.setType("image/*");
            requestGalleryLauncher.launch(intent);
        });


    }

    private void setInitScoreData(int id) {
        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db = helper.getReadableDatabase();
        // tb_score 테이블에서.. 이 유저(DetailActivity에 출력된 학생)의 시험 점수만.. 조건(where)
        Cursor c = db.rawQuery("select score, date from tb_score where student_id = ? order by date", new String[]{String.valueOf(id)});
        scoreList = new ArrayList<>();
        while (c.moveToNext()) {
            HashMap<String, String> map = new HashMap<>();
            map.put("score", c.getString(0));
            Date d = new Date(Long.parseLong(c.getString(1)));
            SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
            map.put("date", sd.format(d));
            scoreList.add(map);
            if(c.isLast()) circleScoreView.setProgress(c.getInt(0));
        }
        db.close();

        adapter = new DetailAdapter(this, scoreList);
        binding.detailRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.detailRecyclerView.setAdapter(adapter);
        binding.detailRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));


    }


}