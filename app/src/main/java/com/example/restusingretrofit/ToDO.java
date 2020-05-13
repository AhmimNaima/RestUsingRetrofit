package com.example.restusingretrofit;

public class ToDO {
private String title;
private String completed;
    public ToDO(String title, String comp) {
        this.title = title;
        this.completed = comp;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompleted() {
        return completed;
    }

    public void setCompleted(String numero) {
        this.completed = completed;
    }


}
