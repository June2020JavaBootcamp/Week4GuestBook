package com.example.demo;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class GuestPost {
    public String name;
    public String date;
    public String wishes;
    public int postNumber;

    public GuestPost() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWishes() {
        return wishes;
    }

    public void setWishes(String wishes) {
        this.wishes = wishes;
    }

    public int getPostNumber() {
        return postNumber;
    }

    public void setPostNumber(int postNumber) {
        this.postNumber = postNumber;
    }
}
