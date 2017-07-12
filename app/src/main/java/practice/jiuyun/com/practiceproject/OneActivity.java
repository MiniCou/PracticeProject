package practice.jiuyun.com.practiceproject;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by XXASUS on 2017/7/10.
 */

public class OneActivity extends AppCompatActivity {
    private ImageView oneA_image;
    MyCountDownTimer mc;
    private TextView oneA_timer;
    private LinearLayout oneA_lin;
    private int count = 4;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.one_activity);
        initView();
        mc = new MyCountDownTimer(4000, 1000);
        mc.start();
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Intent intent = new Intent(OneActivity.this, TwoActivity.class);
//                startActivity(intent);
//            }
//        }, 4000);

    }


    private void initView() {
        oneA_image = (ImageView) findViewById(R.id.oneA_image);
        oneA_timer = (TextView) findViewById(R.id.oneA_timer);
        oneA_lin = (LinearLayout) findViewById(R.id.oneA_lin);
        oneA_lin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OneActivity.this, TwoActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private Handler handler = new Handler();

    /**
     * 继承 CountDownTimer 防范
     * <p>
     * 重写 父类的方法 onTick() 、 onFinish()
     */

    class MyCountDownTimer extends CountDownTimer {

        /**
         * @param millisInFuture    表示以毫秒为单位 倒计时的总数
         *                          <p>
         *                          例如 millisInFuture=1000 表示1秒
         * @param countDownInterval 表示 间隔 多少微秒 调用一次 onTick 方法
         *                          <p>
         *                          例如: countDownInterval =1000 ; 表示每1000毫秒调用一次onTick()
         */
        
        public MyCountDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        public void onFinish() {
            oneA_timer.setText("正在跳转");
        }

        public void onTick(long millisUntilFinished) {
            long l = millisUntilFinished / 1000;
            oneA_timer.setText("跳过(" + l + "s)");
            if (l == 1) {
                Intent intent = new Intent(OneActivity.this, TwoActivity.class);
                startActivity(intent);
                finish();
            }
        }
    }
}
