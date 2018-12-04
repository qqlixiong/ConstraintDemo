package zr.com.constraintdemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class OtherActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBarrierButton;
    private Button mCircularPositioningButton;
    private Button mGroupButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        initView();
    }

    private void initView() {
        mBarrierButton = (Button) findViewById(R.id.button_barrier);
        mBarrierButton.setOnClickListener(this);
        mCircularPositioningButton = (Button) findViewById(R.id.button_circular_positioning);
        mCircularPositioningButton.setOnClickListener(this);
        mGroupButton = (Button) findViewById(R.id.button_group);
        mGroupButton.setOnClickListener(this);
    }

    public static void launch(Context context) {
        Intent intent = new Intent();
        intent.setClass(context, OtherActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_barrier:
                BarrierActivity.launch(this);
                break;
            case R.id.button_circular_positioning:// TODO 18/11/12
                CircularPositioningActivity.launch(this);
                break;
            case R.id.button_group:// TODO 18/11/12
                GroupActivity.launch(this);
                break;
            default:
                break;
        }
    }
}
