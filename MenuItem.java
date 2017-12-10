package com.two.project.computer.recipe4meals;


public class MenuItem {
    public String MealName;
    public String MealInfo;
    public double Rating;
    public int VoteNum;
    public String NameOfImage;

    public MenuItem (String name, String info, double rate, int vote, String Image){
        this.MealName = name;
        this.MealInfo = info;
        this.Rating = rate;
        this.VoteNum = vote;
        this.NameOfImage = Image;
    }
}
