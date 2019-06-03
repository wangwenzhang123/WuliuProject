package com.tongdada.base.crash;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

/**
 * description：
 * <p>
 * author： DS.Hu
 * <p>
 * time： 2018/8/23 12:42
 * <p>
 */
public class ExceptionActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new AlertDialog.Builder(this)
                .setMessage(getIntent().getStringExtra("message"))
                .setCancelable(false)
                .create()
                .show();
    }
}