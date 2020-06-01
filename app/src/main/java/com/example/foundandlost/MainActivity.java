package com.example.foundandlost;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.foundandlost.base.BaseActivity;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.rengwuxian.materialedittext.MaterialEditText;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private Button btnRegist;
    private FloatingActionButton btnFloatLogin;

    private MaterialEditText etName;
    private MaterialEditText etPassword;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
    }


    void initview(){
        etPassword=findViewById(R.id.et_password);
        etName=findViewById(R.id.et_name);

        btnFloatLogin=findViewById(R.id.btn_float_login);
        btnFloatLogin.setClickable(true);
        btnFloatLogin.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_float_login:
                if (etName.getText().length()<4){
                    Toast.makeText(this,"账号长度不得小于4位",Toast.LENGTH_SHORT).show();
                }else if(etPassword.getText().length()<6){
                    Toast.makeText(this,"密码长度不得小于6位数",Toast.LENGTH_SHORT).show();
                }else{
                    startActivity(LostActivity.class);
                    Toast.makeText(this,"登陆成功！欢迎使用！",Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
