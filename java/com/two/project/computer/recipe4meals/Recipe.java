package com.two.project.computer.recipe4meals;

public class Recipe {
    private int recipe_id;
    private String recipe_name;
    private String cuisine;
    private int meal_time;
    private int cook_time;
    private String difficulty;
    private double rating;
    private int votes;
    private Ingredients[] ingredient;
    private int ingredients_num;
    private String instructions;

    public void add_recipe(int ID, String name, String Cuisine, int Mtime, int Ctime, String Diff, double rate, int voteNum, String instr) {
        this.recipe_id = ID;
        this.recipe_name = name;
        this.cuisine = Cuisine;
        this.meal_time = Mtime;
        this.cook_time = Ctime;
        this.difficulty = Diff;
        this.rating = rate;
        this.votes = voteNum;
        this.instructions = instr;
        this.ingredient = new Ingredients[]{};
        this.ingredients_num = 0;
    }

    public void set_ingredients(Ingredients I){
        ingredient[ingredients_num] = I;
        ingredients_num++;
    }

    public void add_rating(double rate){
        double oldPoint = this.rating * votes;
        this.votes++;
        this.rating = (oldPoint + rate)/this.votes;
    }

    public int get_recipe_id(){
        return recipe_id;
    }


    public String get_recipe_name(){
        return recipe_name;
    }


    public String get_cuisine(){
        return cuisine;
    }


    public int get_meal_time(){
        return meal_time;
    }


    public int get_cook_time(){
        return cook_time;
    }


    public String get_difficulty(){
        return difficulty;
    }


    public double get_rating(){
        return rating;
    }

    public int get_votes(){
        return votes;
    }


    public String get_instructions(){
        return instructions;
    }

}
