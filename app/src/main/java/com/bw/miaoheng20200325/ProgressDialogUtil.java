package com.bw.miaoheng20200325;

import android.app.AlertDialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

/**
 * 时间 :2020/3/26  13:50
 * 作者 :苗恒
 * 功能 :
 */
public class ProgressDialogUtil {
    private static AlertDialog mAlertDialog;
    //弹出对话框
    public static void showProgressDialog(Context context){
        if(mAlertDialog==null){
            mAlertDialog=new AlertDialog.Builder(context,R.style.CustomProgressDialog).create();
        }
        View loadView= LayoutInflater.from(context).inflate(R.layout.custom_progress_dialog_view,null);
        mAlertDialog.setView(loadView,0,0,0,0);
        mAlertDialog.setCanceledOnTouchOutside(false);
        TextView tvTip = loadView.findViewById(R.id.tvTip);
        tvTip.setText("加载中");
        mAlertDialog.show();
    }
    public static void showProgressDialog(Context context,String tip){
        if(TextUtils.isEmpty(tip)){
            tip="加载中...";
        }
        if(mAlertDialog==null){
            mAlertDialog=new AlertDialog.Builder(context,R.style.CustomProgressDialog).create();
        }
        View loadView= LayoutInflater.from(context).inflate(R.layout.custom_progress_dialog_view,null);
        mAlertDialog.setView(loadView,0,0,0,0);
        mAlertDialog.setCanceledOnTouchOutside(false);
        TextView tvTip = loadView.findViewById(R.id.tvTip);
        tvTip.setText(tip);
        mAlertDialog.show();
    }
    //隐藏对话框
     public static void dismiss(){
        if(mAlertDialog !=null&&mAlertDialog.isShowing()){
            mAlertDialog.dismiss();
        }
     }
}
