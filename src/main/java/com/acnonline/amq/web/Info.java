package com.acnonline.amq.web;

import java.util.Date;

public class Info {

    private long time = new Date().getTime();

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
