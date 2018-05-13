package com.lesson.rvviewtype.model;

public class Separator implements IListItem {
    private String title;

    public Separator(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean isNote() {
        return false;
    }

    @Override
    public boolean isRemind() {
        return false;
    }
}
