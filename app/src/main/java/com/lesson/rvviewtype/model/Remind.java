package com.lesson.rvviewtype.model;

import java.util.Date;

public class Remind implements IListItem {
    private String title;
    private String text;
    private Date date;

    public Remind(String title, String text, Date date) {
        this.title = title;
        this.text = text;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean isNote() {
        return false;
    }

    @Override
    public boolean isRemind() {
        return true;
    }
}
