package com.example.androidproject;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.androidproject.adapter.MainAdapter;
import com.example.androidproject.callback.DialogCallback;
import com.example.androidproject.databinding.ActivityMainBinding;
import com.example.androidproject.db.DBHelper;
import com.example.androidproject.model.Student;
import com.example.androidproject.util.DialogUtil;
import com.example.androidproject.util.PermissionUtil;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    // AddStudentActivity 실행시키고.. 되돌아 올떄 callback 실행...
    // (신규 사람 등록하는 화면으로 갔다가 다시 돌아와서 화면에 띄워야하므로 사후처리 필요함
    // 따라서 startActicity(intent)가 아니라 ActivityResultLauncher사용 )
    ActivityResultLauncher<Intent> addStudentLauncher;
    public ActivityResultLauncher<Intent> addPhotoLauncher;
    ArrayList<Student> datas = new ArrayList<>();
    MainAdapter adapter;
    long initTime = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Toolbar는 ActionBar를 대체
        // 자동으로.. actionbar에 나올 내용(title, navigation icon, menu)이 toolbar에 나오지는 않는다..
        // 코드에서 한줄 명령은 내려야한다.. toolbar가 개발자 뷰이므로.. 어느 뷰에 actionbar 내용이 나오면 된다고..
        setSupportActionBar(binding.toolbar);

        addStudentLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result ->{
                    if(result.getResultCode() == RESULT_OK && (result.getData() != null)){
                        // intent의 extra 데이터로 넘어온 결과 데이터 추출...
                        Intent intent = result.getData();
                        int id = (int)intent.getLongExtra("id", 0);
                        String name = intent.getStringExtra("name");
                        String email = intent.getStringExtra("email");
                        String phone = intent.getStringExtra("phone");
                        String memo = intent.getStringExtra("memo");
                        String photo = intent.getStringExtra("photo");

                        Student student = new Student(id, name, email, phone, memo, photo);
                        // 새로운 Student객체가 만들어졌다... 이 데이터로 항목이 하나 추가되게 하면 된다...
                        // adpater에 넘긴 항목 구성 데이터에 추가한 후에...
                        // 변경사항 반영해... 명령내리면 된다...
                        datas.add(student);
                        adapter.notifyDataSetChanged();
                    }
                }
        );

        // ********************
        addPhotoLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result ->{
                    if(result.getResultCode() == RESULT_OK && (result.getData() != null)){
                        Intent intent = result.getData();
                        // *******사진 주소 받음
                        String imagePath = intent.getStringExtra("imagePath");
                        int id = intent.getIntExtra("id", 0);
                        // 사진 띄움,, 어떻게 띄우지...?
                        // 위에서는 student객체를 만들어서 띄움..
                        // Recycler View라 어댑터에 데이터를 넘겨줘야함...
                        // student객체에 photo값만 넣어서 보내기

                        for(Student s : datas){
                            if(s.getId() == id) {
                                s.setPhoto(imagePath);
                                break;
                            }
                        }
                        adapter.notifyDataSetChanged();
                    }

                }
        );

        PermissionUtil.checkAllPermission(this, isAllGranted ->{
            if(isAllGranted){
                makeRecyclerView();
            } else{
                showDialog();
            }
        });

        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                if(System.currentTimeMillis() - initTime > 3000){
                    Toast.makeText(MainActivity.this, "종료하려면 한번 더 누르세요", Toast.LENGTH_SHORT).show();
                    initTime = System.currentTimeMillis();
                }else finish();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.menuMainAdd){
            // 화면 전환.. 되돌아 올때... 사후처리
            // 외부에 공개하지 않을거니까 명시적으로...
            Intent intent = new Intent(this, AddStudentActivity.class);
            addStudentLauncher.launch(intent);
        }else if(item.getItemId() == R.id.menuMainSearch){
            SearchView searchView = (SearchView) item.getActionView();
            // 검색한 학생만 recycler view에 출력...
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener(){
                @Override
                public boolean onQueryTextChange(String s) {
                    // s가 포함되는 학생만...
                    return false;
                }

                @Override
                public boolean onQueryTextSubmit(String s) {
                    return false;
                }
            });
        }
        return super.onOptionsItemSelected(item);
    }

    // db data select...
    private void getListData(){
        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db = helper.getReadableDatabase();

        Cursor cursor = db.rawQuery("select * from tb_student order by name", null);

        Log.d("DB_DEBUG", "Cursor count: " + cursor.getCount());

        while(cursor.moveToNext()){
            Student student = new Student();
            student.setId(cursor.getInt(0));
            student.setName(cursor.getString(1));
            student.setEmail(cursor.getString(2));
            student.setPhone(cursor.getString(3));
            student.setPhoto(cursor.getString(4));
            student.setMemo(cursor.getString(5));

            datas.add(student);
        }
    }


    private void makeRecyclerView(){
        getListData();
        //adapter = new MainAdapter(this, datas);
        adapter =  new MainAdapter(this, datas, addPhotoLauncher);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }


    private void showDialog(){
        DialogUtil.showMessageDialog(this, getString(R.string.permission_denied), "확인", null, new DialogCallback() {
            @Override
            public void onPositiveCallback() {

            }

            @Override
            public void onNegativeCallback() {

            }
        });
    }
}