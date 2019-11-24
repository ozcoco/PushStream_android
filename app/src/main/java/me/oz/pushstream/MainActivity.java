package me.oz.pushstream;

import android.os.Bundle;
import android.view.SurfaceView;

import androidx.appcompat.app.AppCompatActivity;

import com.blankj.utilcode.constant.PermissionConstants;
import com.blankj.utilcode.util.PermissionUtils;


public class MainActivity extends AppCompatActivity
{

    public final static String TAG = MainActivity.class.getCanonicalName();

    public final static String url = "rtmp://192.168.0.107:32769/live/vc";


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        final SurfaceView cameraView = findViewById(R.id.cameraView);

        PermissionUtils.permission(PermissionConstants.CAMERA,
                PermissionConstants.STORAGE,
                PermissionConstants.MICROPHONE).callback(new PermissionUtils.SimpleCallback()
        {
            @Override
            public void onGranted()
            {


            }

            @Override
            public void onDenied()
            {

            }
        }).request();

    }


    @Override
    protected void onStop()
    {
        super.onStop();

    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();

    }
}

