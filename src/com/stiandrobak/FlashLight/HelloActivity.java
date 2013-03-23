package com.stiandrobak.FlashLight;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.view.Window;
import android.view.WindowManager;

public class HelloActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        LinearLayout x = (LinearLayout)findViewById(R.id.mainStyle);
        x.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int x = (int)event.getX();
                int y = (int) event.getY();
                float width = v.getWidth();
                float height = v.getHeight();
                if(x < (width * (1.0/3) )){
                    v.setBackgroundColor(Color.rgb(x,y,255));
                }else if(x < (width * (2.0 / 3))){
                    v.setBackgroundColor(Color.rgb(255,x,y));
                }else{
                    v.setBackgroundColor(Color.rgb(y,255,x));
                }

                return true;

                //return false;  //To change body of implemented methods use File | Settings | File Templates.
            }
        });
        Window mWindow = getWindow();
        WindowManager.LayoutParams lp = mWindow.getAttributes();
        lp.screenBrightness = 1;
        mWindow.setAttributes(lp);
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        System.exit(0);
    }


}
