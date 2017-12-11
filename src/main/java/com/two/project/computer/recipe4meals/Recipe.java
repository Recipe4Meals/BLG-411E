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

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public void setMeal_time(int meal_time) {
        this.meal_time = meal_time;
    }

    public void setCook_time(int cook_time) {
        this.cook_time = cook_time;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public int getRecipe_id() {
        return recipe_id;
    }

    public String getRecipe_name() {
        return recipe_name;
    }

    public String getCuisine() {
        return cuisine;
    }

    public int getMeal_time() {
        return meal_time;
    }

    public int getCook_time() {
        return cook_time;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public double getRating() {
        return rating;
    }

    public int getVotes() {
        return votes;
    }

    public Ingredients[] getIngredient() {
        return ingredient;
    }

    public int getIngredients_num() {
        return ingredients_num;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setRecipe_id(int recipe_id) {
        this.recipe_id = recipe_id;
    }

    public void setRecipe_name(String recipe_name) {
        this.recipe_name = recipe_name;
    }

    public void setIngredient(Ingredients[] ingredient) {
        this.ingredient = ingredient;
    }

    public void setIngredients_num(int ingredients_num) {
        this.ingredients_num = ingredients_num;
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
