package com.example.tableeditor;

import javafx.scene.paint.Color;

public class Athlete {
    String FirstName;
    String LastName;
    String Sport;
    Integer Years;
    Boolean Vegetarian;
    Color FavColor;

    public Boolean getVegetarian() {
        return Vegetarian;
    }

    public void setVegetarian(Boolean vegetarian) {
        Vegetarian = vegetarian;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getSport() {
        return Sport;
    }

    public void setSport(String sport) {
        Sport = sport;
    }

    public Integer getYears() {
        return Years;
    }

    public void setYears(Integer years) {
        Years = years;
    }



    public Color getFavColor() {
        return FavColor;
    }

    public void setFavColor(Color favColor) {
        FavColor = favColor;
    }


    public Athlete(String firstName, String lastName, String sport, Integer years, Boolean vegetarian, Color favColor) {
        FirstName = firstName;
        LastName = lastName;
        Sport = sport;
        Years = years;
        Vegetarian = vegetarian;
        FavColor = favColor;
    }
}
