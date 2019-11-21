package com.example.interview;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Mocked data for the test, assume this to be your data repository
 */
public class MockedData {

    /**
     * Synchronously retrieves the "current user" (assume you are logged in somehow)
     * @return A string JSON representation of the current user
     */
    public String getCurrentUser() {
        JSONObject object = new JSONObject();
        try {
            object.put("id", "2");
            object.put("name", "Me");
            object.put("profilePicture", "https://www.google.com/images/branding/googlelogo/2x/googlelogo_color_92x30dp.png");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return object.toString();

    }

    /**
     * Synchronously retrieves a user
     * @param id the ID of the user
     * @return @return A string JSON representation of the user if the user exists,
     * and the currrent user can access the profile, null otherwise
     */
    public String getUser(int id) {
        if (id == 4) {
            return null;
        }
        JSONObject object = new JSONObject();
        try {
            object.put("id", id);
            object.put("name", "Someone else " + id);
            object.put("profilePictures", "https://www.google.com/images/branding/googlelogo/2x/googlelogo_color_92x30dp.png");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return object.toString();
    }

    /**
     * Synchronously retrieves the list of meetings for a specific user if the list of meetings is accessible.
     * Returns an null if it is impossible to fetch the data
     * @param user the user we are trying to retrieve the meetings for.
     * @return A String/JSON representation of the list of meetings
     */
    public String getMeetingsForUser(User user) {
        if (user != null && user.id == 2) {
            JSONArray meetings = new JSONArray();
            JSONObject object = new JSONObject();
            try {
                object.put("name", "meeting for user " + user.id);
                JSONArray participants = new JSONArray();
                participants.put(getUser(2));
                participants.put(getUser(3));
                participants.put(getUser(4));
                object.put("participants", participants);
                meetings.put(object);
                return meetings.toString();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
