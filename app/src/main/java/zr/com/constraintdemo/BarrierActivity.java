package zr.com.constraintdemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class BarrierActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barrier);
    }

    public static void launch(Context context) {
        Intent intent = new Intent();
        intent.setClass(context, BarrierActivity.class);
        context.startActivity(intent);
    }
}
