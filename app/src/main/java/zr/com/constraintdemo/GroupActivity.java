package zr.com.constraintdemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import zr.com.constraintdemo.normal.ChainActivity;

public class GroupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);
    }

    public static void launch(Context context) {
        Intent intent = new Intent();
        intent.setClass(context, GroupActivity.class);
        context.startActivity(intent);
    }
}
