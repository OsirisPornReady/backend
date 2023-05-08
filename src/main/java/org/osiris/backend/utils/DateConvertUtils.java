package org.osiris.backend.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateConvertUtils {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");;

    public static String date2string(Date source) {
        if (source != null) {
            return sdf.format(source);
        } else {
            return null;
        }
    }

    public static Date string2date(String source) {
        if (source != null) {
            try {
                return sdf.parse(source);
            } catch (ParseException e) {
                e.printStackTrace();
                return null;
            }
        } else {
            return null;
        }
    }
}
