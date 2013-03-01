package com.stiandrobak.FlashLight;

import android.app.Activity;
import android.hardware.Camera;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.view.Window;
import android.view.WindowManager;

public class HelloActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    private static Camera camera;

    static {
        camera = Camera.open();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        LinearLayout x = (LinearLayout)findViewById(R.id.mainStyle);
        Window mWindow = getWindow();
        WindowManager.LayoutParams lp = mWindow.getAttributes();
        lp.screenBrightness = 1;
        mWindow.setAttributes(lp);
    }

    public static void toggleValue(){
        Camera.Parameters p = camera.getParameters();
        if(!p.getFlashMode().equals(Camera.Parameters.FLASH_MODE_TORCH)){
            p.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
            camera.setParameters(p);
            camera.startPreview();
        }else{
            p.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
            camera.setParameters(p);
            camera.stopPreview();
        }
    }
}
