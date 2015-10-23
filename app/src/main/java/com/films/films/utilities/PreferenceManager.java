package com.films.films.utilities;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by mauriziofolcini on 03/10/2015.
 */
public final class PreferenceManager {

    public static ArrayList<String> getSearchHistory(Context context)  {
        SharedPreferences prefs = context.getSharedPreferences("history", Context.MODE_PRIVATE);
        String value = prefs.getString("list", null);
        ArrayList<String> list;
        try {
            if (value != null) {
                ObjectMapper mapper = new ObjectMapper();
                list = mapper.readValue(value, ArrayList.class);
                return list;
            } else {
                return new ArrayList<>();
            }
        } catch (Exception e) {
            return new ArrayList<>();
        }

    }

    public static void setSearchHistory(Context context, String query) {
        ArrayList<String> history = getSearchHistory(context);

        if (!history.contains(query)) {
            history.add(query);
            ObjectMapper mapper = new ObjectMapper();
            try {
                String value = mapper.writeValueAsString(history);
                SharedPreferences prefs = context.getSharedPreferences("history", Context.MODE_PRIVATE);
                SharedPreferences.Editor e = prefs.edit();
                e.putString("list", value);
                e.commit();
            } catch (IOException e) {
                Log.e("IOException", e.toString());
            }
        }

    }
}
