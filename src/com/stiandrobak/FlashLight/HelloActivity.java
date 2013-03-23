package com.stiandrobak.FlashLight;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.*;
import android.widget.LinearLayout;

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
                //float height = v.getHeight();
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
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater =  getMenuInflater();
        inflater.inflate(R.menu.my_menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        LinearLayout layout = (LinearLayout)findViewById(R.id.mainStyle);
        switch(item.getItemId()){
            case R.id.reset:
                layout.setBackgroundColor(Color.WHITE);
                return true;
            case R.id.setBlue:
                layout.setBackgroundColor(Color.BLUE);
                return true;
            case R.id.setRed:
                layout.setBackgroundColor(Color.RED);
                return true;
            case R.id.setGreen:
                layout.setBackgroundColor(Color.GREEN);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        System.exit(0);
    }


}
