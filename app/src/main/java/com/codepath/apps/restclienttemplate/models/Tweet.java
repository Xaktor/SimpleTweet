package com.codepath.apps.restclienttemplate.models;

import android.util.Log;

import com.codepath.apps.restclienttemplate.TimeFormatter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Tweet {
    public String body;
    public String createdAt;
    public long id;
    public User user;


    public static Tweet fromJson(JSONObject jsonObject) throws JSONException {
        Tweet tweet=new Tweet();
        tweet.body=jsonObject.getString("text");
        tweet.createdAt=jsonObject.getString("created_at");
        tweet.user=User.fromJson(jsonObject.getJSONObject("user"));
        tweet.id=jsonObject.getLong("id");
        return tweet;
    }
    public static List<Tweet> fromJsonArray(JSONArray jsonArray) throws JSONException {
        List<Tweet> tweets=new ArrayList<>();
        for(int a=0; a<jsonArray.length();a++){
            tweets.add(fromJson(jsonArray.getJSONObject(a)));
        }
        return tweets;
    }
}
