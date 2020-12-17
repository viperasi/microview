package com.xu81.microview.web.main.dto;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;

public class MicroView implements Serializable {
    private String entry;
    private String name;
    private String container;
    private String activeRule;
    private String icon;
    private String title;

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEntry() {
        return entry;
    }

    public void setEntry(String entry) {
        this.entry = entry;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContainer() {
        return container;
    }

    public void setContainer(String container) {
        this.container = container;
    }

    public String getActiveRule() {
        return activeRule;
    }

    public void setActiveRule(String activeRule) {
        this.activeRule = activeRule;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
