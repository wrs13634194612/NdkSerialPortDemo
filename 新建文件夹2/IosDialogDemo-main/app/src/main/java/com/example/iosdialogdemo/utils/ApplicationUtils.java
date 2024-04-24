package com.example.iosdialogdemo.utils;

import android.app.Application;
import android.content.Context;

import com.example.iosdialogdemo.MainActivity;

class ApplicationUtils {

    public static Application getApplicition(Context context) {

        return (Application) ((MainActivity) context).getApplication();
    }
}
