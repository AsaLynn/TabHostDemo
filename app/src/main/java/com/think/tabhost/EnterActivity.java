package com.think.tabhost;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class EnterActivity extends AppCompatActivity implements View.OnClickListener {

    protected Button btn1;
    protected Button btn2;
    protected Button btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_enter);
        initView();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn1) {
            startActivity(new Intent(this, MainActivity.class));
        } else if (view.getId() == R.id.btn2) {
            startActivity(new Intent(this, Main1Activity.class));
        } else if (view.getId() == R.id.btn3) {
            startActivity(new Intent(this, Main2Activity.class));
        }
    }

    private void initView() {
        btn1 = (Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(EnterActivity.this);
        btn2 = (Button) findViewById(R.id.btn2);
        btn2.setOnClickListener(EnterActivity.this);
        btn3 = (Button) findViewById(R.id.btn3);
        btn3.setOnClickListener(EnterActivity.this);
    }
}
