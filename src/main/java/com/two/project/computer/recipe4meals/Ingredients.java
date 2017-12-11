package com.two.project.computer.recipe4meals;

public class Ingredients {
    private int ingredient_id;
    private String ingredient_name;
    private double amount;

    public Ingredients(int ID, String name, int Amount){
        this.ingredient_id = ID;
        this.ingredient_name = name;
        this.amount = Amount;
    }

    public void set_ingredient_id(int ID){
        this.ingredient_id = ID;
    }

    public void set_ingredient_name(String name){
        this.ingredient_name = name;
    }

    public void set_amount(double Amount){
        this.amount = Amount;
    }

    public int get_ingredient_id(){
        return ingredient_id;
    }

    public String get_ingredient_name(){
        return ingredient_name;
    }

    public double get_amount(){
        return amount;
    }
}
