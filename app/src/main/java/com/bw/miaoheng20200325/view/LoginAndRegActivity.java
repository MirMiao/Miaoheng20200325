package com.bw.miaoheng20200325.view;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bw.miaoheng20200325.R;
import com.bw.miaoheng20200325.base.BaseActivity;
import com.bw.miaoheng20200325.contract.IContract;
import com.bw.miaoheng20200325.entity.LoginEntity;
import com.bw.miaoheng20200325.entity.RegEntity;
import com.bw.miaoheng20200325.presenter.Presenter;
import com.bw.miaoheng20200325.util.ProgressDialogUtil;

public class LoginAndRegActivity extends BaseActivity<Presenter> implements IContract.IView {


    private EditText et_phone;
    private EditText et_pwd;
    private Button bt_login;
    private Button bt_reg;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        et_phone = findViewById(R.id.et_phone);
        et_pwd = findViewById(R.id.et_pwd);
        bt_login = findViewById(R.id.bt_login);
        bt_reg = findViewById(R.id.bt_reg);

        bt_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                  //获取输入的内容
                String phone = et_phone.getText().toString();
                if(TextUtils.isEmpty(phone)){
                    Toast.makeText(LoginAndRegActivity.this, "手机号不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                String pwd = et_pwd.getText().toString();
                if(TextUtils.isEmpty(pwd)){
                    Toast.makeText(LoginAndRegActivity.this, "密码不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                presenter.reg(phone,pwd);
            }
        });
         bt_login.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {

                 ProgressDialogUtil.showProgressDialog(LoginAndRegActivity.this);
                 //获取输入的内容
                 String phone = et_phone.getText().toString();
                 if(TextUtils.isEmpty(phone)){
                     Toast.makeText(LoginAndRegActivity.this, "手机号不能为空", Toast.LENGTH_SHORT).show();
                     return;
                 }
                 String pwd = et_pwd.getText().toString();
                 if(TextUtils.isEmpty(pwd)){
                     Toast.makeText(LoginAndRegActivity.this, "密码不能为空", Toast.LENGTH_SHORT).show();
                     return;
                 }
                 presenter.login(phone,pwd);
             }
         });
    }

    @Override
    protected Presenter initPresenter() {
        return new Presenter();
    }

    @Override
    protected int bindLayoutid() {
        return R.layout.activity_login_and_reg;
    }

    @Override
    public void seccess(Object object) {
          if(object instanceof RegEntity){
              Toast.makeText(this, ""+((RegEntity) object).getMessage(), Toast.LENGTH_SHORT).show();
          }
        if (object instanceof LoginEntity) {
            Toast.makeText(this, ""+((LoginEntity) object).getMessage(), Toast.LENGTH_SHORT).show();
            if("0000".equals(((LoginEntity) object).getStatus())){

                Intent intent = new Intent(LoginAndRegActivity.this,MainActivity.class);
                intent.putExtra("headPic",((LoginEntity) object).getResult().getHeadPic());
                startActivity(intent);
                //隐藏对话框
                ProgressDialogUtil.dismiss();
            }
        }
    }

    @Override
    public void failur(Throwable throwable) {

    }
}
