package com.example.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by GoFundMe on 1/11/17.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class TemplateRealmObject extends RealmObject {

    @PrimaryKey
    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
