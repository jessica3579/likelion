package com.example.androidproject;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.DialogTitle;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.androidproject.databinding.ActivityAddStudentBinding;
import com.example.androidproject.db.DBHelper;
import com.example.androidproject.util.DialogUtil;

public class AddStudentActivity extends AppCompatActivity {

    ActivityAddStudentBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityAddStudentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setSupportActionBar(binding.toolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // 메뉴 파일명
        getMenuInflater().inflate(R.menu.menu_add, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // 메뉴 파일명의 아이디값
        if(item.getItemId() == R.id.menu_add_save){
            // db에 저장하는 코드가 길어서 함수로 만듦
            save();
        }
        return super.onOptionsItemSelected(item);
    }

    private void save(){
        // 유저 입력 데이터 획득...
        String name = binding.addName.getText().toString();
        String email = binding.addEmail.getText().toString();
        String phone = binding.addPhone.getText().toString();
        String memo = binding.addMemo.getText().toString();

        // 유효성 검증... 유저 입력 데이터가 우리가 원하는 데이터인지 판단...
        if(name == null || name.equals("")){
            DialogUtil.showToast(this, getString(R.string.add_name_null));
        }else{
            // db 저장...
            DBHelper helper = new DBHelper(this);
            SQLiteDatabase db = helper.getWritableDatabase();

            // 저장 데이터...
            ContentValues values = new ContentValues();
            values.put("name", name);
            values.put("email", email);
            values.put("phone", phone);
            values.put("memo", memo);

            // execSql() 함수로도 insert 실행 가능..
            // 하지만 execSql이 insert 전문이 아니라.. 다른 select제외하고
            // 나머지 sql 실행이다보니.. return 데이터가 없다..
            // insert 후에.. insert된 그 row의 식별자값을 얻고 싶다.. 그 데이터가 Main쪽에 필요하기 때문...
            long newRowId = db.insert("tb_student", null, values);
            db.close();

            // 화면은...?
            // MainActivity로 화면 전환... 데이터 포함시켜서... (Extra 데이터)
            Intent intent = getIntent();
            setResult(RESULT_OK, intent);
            intent.putExtra("id", newRowId);
            intent.putExtra("name", name);
            intent.putExtra("email", email);
            intent.putExtra("phone", phone);
            intent.putExtra("memo", memo);
            finish();

        }
    }
}