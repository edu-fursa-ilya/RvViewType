package com.lesson.rvviewtype.model;

public class Note implements IListItem {
    private String title;
    private String text;

    public Note(String title, String text) {
        this.title = title;
        this.text = text;
    }

    //возвращаем true
    @Override
    public boolean isNote() {
        return true;
    }

    @Override
    public boolean isRemind() {
        return false;
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
}
