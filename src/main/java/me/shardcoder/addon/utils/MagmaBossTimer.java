package me.shardcoder.addon.utils;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import org.apache.commons.io.IOUtils;

public class MagmaBossTimer {

    private URL apiUrl;

    private int curTimeMillis;
    private int estTimeMillis;
    private int remTimeMillis;
    private int remTimeSecs;
    private String remTimeReadable;

    private void getAPIData() {
        try {
            apiUrl = new URL("https://hypixel-api.inventivetalent.org/api/skyblock/bosstimer/magma/estimatedSpawn");
            JsonParser parser = new JsonParser(); //from gson
            JsonElement element = parser.parse(new InputStreamReader((InputStream) IOUtils.toInputStream(apiUrl.toString())));
            JsonObject object = element.getAsJsonObject();
            int curTime = object.get("time").getAsInt();
            int estTime = object.get("estimate").getAsInt();
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.remTimeMillis = this.estTimeMillis - this.curTimeMillis;
        this.remTimeSecs = this.remTimeMillis / 1000;

        this.remTimeReadable = "";

        if (this.remTimeSecs / 3600 != 0) {
            this.remTimeReadable = this.remTimeReadable.concat(
                String.valueOf((this.remTimeSecs / 3600)
                - ((this.remTimeSecs / 86400) * 24))).concat("h ");
        }

        if (this.remTimeSecs / 60 != 0) {
            this.remTimeReadable = this.remTimeReadable.concat(
                String.valueOf((this.remTimeSecs / 60)
                - ((this.remTimeSecs / 3600) * 60))).concat("m ");
        }

        if (this.remTimeSecs != 0) {
            this.remTimeReadable = this.remTimeReadable.concat(
                String.valueOf((this.remTimeSecs)
                - ((this.remTimeSecs / 60) * 60))).concat("s ");
        }
    }

    public String getRemTimeReadable() {
        this.getAPIData();
        return this.remTimeReadable;
    }
}
