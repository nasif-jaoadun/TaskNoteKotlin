package com.jnasif.java.tasknote.utilities;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Utility {

    public static Date getDate(int diff){
        GregorianCalendar cal = new GregorianCalendar();
        cal.add(Calendar.MILLISECOND, diff);
        return cal.getTime();
    }

}
