package com.learning.sample;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

public class NoteRepository {
    private static final Map<Long, Note> NOTE_LIST = new HashMap<>();
    private static final int[] images  = {
            R.mipmap.ic_cat_1,
            R.mipmap.ic_cat_2,
            R.mipmap.ic_cat_3,
            R.mipmap.ic_cat_4,
            R.mipmap.ic_cat_5,
            R.mipmap.ic_cat_6,
            R.mipmap.ic_cat_7,
    };

    public static void initialize(final Context context) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(context.getAssets().open("notes.txt")))) {
            String row = reader.readLine();
            long id = 0;

            while (!TextUtils.isEmpty(row)) {

                String[] words = row.split("__");
                if(words.length > 1) {

                    String string = words[0];
                    DateFormat format = new SimpleDateFormat("yyyy.m.d", Locale.ENGLISH);
                    Date date = format.parse(string);

                    String text = words[1];
                    Random random = new Random();
                    int drawableRes = images[ random.nextInt(images.length) ];

                    NOTE_LIST.put(id, new Note(id, date, text, drawableRes));
                    ++id;
                }



                row = reader.readLine();
            }

        } catch (IOException | ParseException e) {
            System.out.println("ERROR!!!");
        }
    }



    public static List<Note> getNotes() {
        return new ArrayList<>(NOTE_LIST.values());
    }

    public static Note getNoteWithId(final long id) {
        return NOTE_LIST.get(id);
    }
}
