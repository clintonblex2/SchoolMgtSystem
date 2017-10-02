package com.example.root.schoolmgtsystem;

public class HomeModel {

    //Member variable declarations
    private String title;
    private int imageResource;

    //Constructor for Home data model
    public HomeModel(String titles, int imageResources){
        this.title = titles;
        this.imageResource = imageResources;
    }

    public String getTitle(){
        return title;
    }

    public int getImageResource(){
        return imageResource;
    }
}
