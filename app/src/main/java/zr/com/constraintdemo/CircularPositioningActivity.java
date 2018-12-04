package zr.com.constraintdemo;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.transition.TransitionManager;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import java.util.concurrent.TimeUnit;

public class CircularPositioningActivity extends AppCompatActivity {
    private ConstraintSet orbitsConstraint = new ConstraintSet();
    private ConstraintSet detailsConstraint = new ConstraintSet();
    private ConstraintLayout mConstraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circular_positioning);
        mConstraintLayout = (ConstraintLayout) findViewById(R.id.root);
        orbitsConstraint.clone(mConstraintLayout);
        detailsConstraint.clone(this, R.layout.activity_details);

        ImageView sunImage = (ImageView) findViewById(R.id.sun_image);
        ImageView earthImage = (ImageView) findViewById(R.id.earth_image);
        ImageView marsImage = (ImageView) findViewById(R.id.mars_image);
        ImageView saturnImage = (ImageView) findViewById(R.id.saturn_image);

        final ValueAnimator earthAnimator = animatePlanet(earthImage, TimeUnit.SECONDS.toMillis(2));
        final ValueAnimator marsAnimator = animatePlanet(marsImage, TimeUnit.SECONDS.toMillis(6));
        final ValueAnimator saturnAnimator = animatePlanet(saturnImage, TimeUnit.SECONDS.toMillis(12));

        earthAnimator.start();
        marsAnimator.start();
        saturnAnimator.start();

        sunImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                earthAnimator.cancel();
                marsAnimator.cancel();
                saturnAnimator.cancel();
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    TransitionManager.beginDelayedTransition(mConstraintLayout);
                }
                detailsConstraint.applyTo(mConstraintLayout);
            }
        });
    }

    public static void launch(Context context) {
        Intent intent = new Intent();
        intent.setClass(context, CircularPositioningActivity.class);
        context.startActivity(intent);
    }

    private ValueAnimator animatePlanet(final ImageView planet, long orbitDuration) {
        ValueAnimator anim = ValueAnimator.ofInt(0, 359);
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int val = (Integer) animation.getAnimatedValue();
                ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) planet.getLayoutParams();
                layoutParams.circleAngle = val;
                planet.setLayoutParams(layoutParams);
            }
        });
        anim.setDuration(orbitDuration);
        anim.setInterpolator(new LinearInterpolator());
        anim.setRepeatMode(ValueAnimator.RESTART);
        anim.setRepeatCount(ValueAnimator.INFINITE);

        return anim;
    }
}
