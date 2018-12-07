package zr.com.constraintdemo;

import android.os.MessageQueue;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener ,MessageQueue.IdleHandler{

    private Button mNormalButton, mConstraintSetButton, mGuidelineButton, mCustomViewButton,mOtherViewButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void initView() {
        mNormalButton = (Button) findViewById(R.id.btn_normal);
        mConstraintSetButton = (Button) findViewById(R.id.btn_constraintset);
        mGuidelineButton = (Button) findViewById(R.id.btn_guideline);
        mCustomViewButton = (Button) findViewById(R.id.btn_custom_view);
        mOtherViewButton = (Button) findViewById(R.id.btn_other_view);
    }

    private void setListener() {
        mNormalButton.setOnClickListener(this);
        mConstraintSetButton.setOnClickListener(this);
        mGuidelineButton.setOnClickListener(this);
        mCustomViewButton.setOnClickListener(this);
        mOtherViewButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_normal:
                NormalActivity.launch(this);
                break;

            case R.id.btn_constraintset:
                ConstraintSetActivity.launch(this);
                break;

            case R.id.btn_guideline:
                GuidelineActivity.launch(this);
                break;

            case R.id.btn_custom_view:
                CustomActivity.launch(this);
                break;

            case R.id.btn_other_view:
                OtherActivity.launch(this);
                break;
        }
    }

    @Override
    public boolean queueIdle() {  //是在onResume()之后执行，优化了启动时间
        initView();
        setListener();
        return false;
    }
}
