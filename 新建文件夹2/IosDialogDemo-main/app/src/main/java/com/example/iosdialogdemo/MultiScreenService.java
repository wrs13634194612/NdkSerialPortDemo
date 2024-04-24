package com.example.iosdialogdemo;


import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.hardware.display.DisplayManager;
import android.os.Binder;
import android.os.IBinder;
import android.view.Display;
import android.view.WindowManager;

import com.example.iosdialogdemo.presentation.SecondScreenPresentation;

public class MultiScreenService extends Service {
    private DisplayManager mDisplayManager;
    private Display[] displays;
    private SecondScreenPresentation presentation;

    @Override
    public IBinder onBind(Intent intent) {
        return new MultiScreenBinder();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initPresentation();
    }

    private void initPresentation() {
        if (null == presentation) {
            mDisplayManager = (DisplayManager) this.getSystemService(Context.DISPLAY_SERVICE);
            displays = mDisplayManager.getDisplays();
            if (displays.length > 1) {
                // displays[1]是副屏
                presentation = new SecondScreenPresentation(this, displays[1]);
                presentation.getWindow().setType(WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY - 1);

            }
        }
    }

    public void showSearchPresentation() {
        presentation.show();
    }

    public class MultiScreenBinder extends Binder {
        public MultiScreenService getService() {
            return MultiScreenService.this;
        }
    }
}
