package com.acnonline.amq.web;

import java.util.Date;

public class Info {

    private long time = new Date().getTime();
    private long loadTime =-1;

    public Info(long loadTime) {
        this.loadTime = loadTime;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public long getLoadTime() {
        return loadTime;
    }

    public void setLoadTime(long loadTime) {
        this.loadTime = loadTime;
    }
}
