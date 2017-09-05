package com.example.data;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by phundal2091 on 9/4/17.
 */

public class CustomData extends RealmObject {
    @PrimaryKey
    private int id;
    private String title;
    private String description;
    private String url;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return description;
    }

    public void setDesc(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
