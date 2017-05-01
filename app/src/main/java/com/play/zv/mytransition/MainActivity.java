package com.play.zv.mytransition;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;

//
//enter：用于决定第一次打开当前Activity时的动画
//        exit : 用于决定退出当前Activity时的动画
//        reenter: 用于决定如果当前Activity已经打开过，并且再次打开该Activity时的动画
//        shared elements:用于决定在两个Activity之间切换时，指定两个Activity中对应的View的过渡效果
public class MainActivity extends AppCompatActivity {
    private Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //首先在setContentView()之前执行，用于告诉Window页面切换需要使用动画
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);

        setContentView(R.layout.activity_main);
        button1 = (Button) findViewById(R.id.button1);
        Transition explode = TransitionInflater.from(this).inflateTransition(R.transition.explode);
        //退出时使用
        getWindow().setExitTransition(explode);
        //第一次进入时使用
        getWindow().setEnterTransition(explode);
        //再次进入时使用
        getWindow().setReenterTransition(explode);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(MainActivity.this).toBundle());
            }
        });


    }
}
