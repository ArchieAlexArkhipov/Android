package com.learning.sample;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Note {
    private long id;
    private Date date;
    private String text;
    private int drawableRes;

    public Note(final long id, final Date date, final String text, final int drawableRes) {
        this.id = id;
        this.date = date;
        this.text = text;
        this.drawableRes = drawableRes;
    }

    public long getId() {
        return id;
    }

    public String getDate() {
        String pattern = "yyyy/MM/dd";
        DateFormat df = new SimpleDateFormat(pattern);
//        Date today = Calendar.getInstance().getTime();
        String todayAsString = df.format(date);

        return todayAsString;
    }

    public String getText() {
        return text;
    }

    public int getDrawableRes() {
        return drawableRes;
    }
}
