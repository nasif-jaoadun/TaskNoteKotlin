package com.jnasif.java.tasknote.utilities;

import android.util.Log;
import android.widget.Switch;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Utility {
    public static Date getDate(int diff){
        GregorianCalendar cal = new GregorianCalendar();
        cal.add(Calendar.MILLISECOND, diff);
        return cal.getTime();
    }

    public static void showLog(int key, String message){
        if(true){
            switch (key){
                case Log.INFO: Log.i(Constants.TAG, message);
                    break;
                case Log.ERROR: Log.e(Constants.TAG, message);
                    break;
                case Log.DEBUG: Log.d(Constants.TAG, message);
                    break;
                case Log.VERBOSE: Log.v(Constants.TAG, message);
                    break;
                case Log.WARN: Log.w(Constants.TAG, message);
                    break;
                case Log.ASSERT: Log.wtf(Constants.TAG, message);
                    break;
            }
        }
    }

}
