package org.TestVagrantTechnologies.utils.datareader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataMap {

    /**
     * Instantiates a new Data map.
     *
     * @param filename the filename
     */
    public DataMap(String filename) {
        ob = preRequisites(filename);
    }

    /**
     * The constant ob.
     */
    public static JSONObject ob;

    /**
     * Pre requisites json object.
     *
     * @param filename the filename
     * @return the json object
     */
    public JSONObject preRequisites(String filename) {
        JSONParser parser = new JSONParser();
        Object obj = null;
        try {
            obj = parser.parse(new FileReader("./testdata/" + filename + ".json"));
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        ob = (JSONObject) obj;
        return ob;
    }

    /**
     * Gets string.
     *
     * @param str the str
     * @return the string
     */
    public String getString(String str) {
        return readJson(str, ob);
    }

    /**
     * Gets int.
     *
     * @param str the str
     * @return the int
     */
    public int getInt(String str) {
        String s = readJson(str, ob);
        if (s == null)
            return 0;
        else
            return Integer.parseInt(s);
    }

    /**
     * Gets long.
     *
     * @param str the str
     * @return the long
     */
    public long getLong(String str) {
        String s = readJson(str, ob);
        if (s == null)
            return 0;
        else
            return Long.parseLong(s);
    }

    /**
     * Gets boolean.
     *
     * @param str the str
     * @return the boolean
     */
    public boolean getBoolean(String str) {
        String s = readJson(str, ob);
        if (s == null)
            return false;
        else
            return Boolean.parseBoolean(s);
    }

    /**
     * Gets float.
     *
     * @param str the str
     * @return the float
     */
    public float getFloat(String str) {
        String s = readJson(str, ob);
        if (s == null)
            return 0;
        else
            return Float.parseFloat(s);
    }

    /**
     * Gets double.
     *
     * @param str the str
     * @return the double
     */
    public double getDouble(String str) {
        String s = readJson(str, ob);
        if (s == null)
            return 0.0;
        else
            return Double.parseDouble(s);
    }

    /**
     * Read json string.
     *
     * @param keys the keys
     * @param obj  the obj
     * @return the string
     */
    public static String readJson(String keys, JSONObject obj) {
        try {
            String[] listKeys = keys.split("\\.");
            List<String> keyList = new ArrayList<String>(Arrays.asList(listKeys));
            if (keyList.size() > 1) {
                String val = keyList.get(0);
                JSONObject tempObj = (JSONObject) obj.get(val);
                keyList.remove(0);
                String tempKeys = String.join(".", keyList);
                return readJson(tempKeys, tempObj);
            } else {
                return (String) obj.get(keys);
            }
        } catch (Exception e) {
            return null;
        }
    }
}
