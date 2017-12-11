package com.two.project.computer.recipe4meals;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainMenu extends AppCompatActivity {

    MenuItem[] menuItems = new MenuItem[]{
            new MenuItem("Köfte", "Etli yemek.", 4.6, 12, "kofte"),
            new MenuItem("Makarna", "Kolay yemek.", 3.7, 23, "makarna"),
            new MenuItem("Karnıyarık", "Patlıcanlı yemek.", 3.9, 4, "karniyarik"),
    };


    private ListView listView;
    private ArrayAdapter menuItemAdapter;
    private ArrayAdapter recipeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/*
        //getResources().openRawResource(R.raw.Ingredients);
        String filename = "Ingredients";
        String fileData;

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(getResources().openRawResource(R.raw.ingredients)));

            StringBuilder str = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                str.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "File could not open 1", Toast.LENGTH_SHORT).show();
        }

        try {
            //FileInputStream fis = openFileInput(filename);
            InputStream is = (getResources().openRawResource(R.raw.ingredients));
            //is = fis;
            //IngredientsXMLParser IXP = new IngredientsXMLParser();
            //List Parsed = IXP.parse(is);
            for(int i=0;i<Parsed.size();i++){
                Toast.makeText(getApplicationContext(), , Toast.LENGTH_SHORT).show();}
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "File could not open 2", Toast.LENGTH_SHORT).show();
        }

        try {
            FileInputStream fis = openFileInput(filename);
            int size = fis.available();
            byte[] buffer = new byte[size];
            fis.read(buffer);
            fis.close();
            fileData = new String(buffer);
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "File could not open 3", Toast.LENGTH_SHORT).show();
        }
*/
        ArrayList<Recipe> recipesList = parseXML();
        //Recipe[] recipes = new Recipe[recipesList.size()];
        //recipes = recipesList.toArray(recipes);
        Recipe[] recipes = recipesList.toArray(new Recipe[recipesList.size()]);

        listView = (ListView) findViewById(R.id.List);
        menuItemAdapter = new MenuItemAdapter(getApplicationContext(),R.layout.menu, menuItems);
        recipeAdapter = new RecipeAdapter(getApplicationContext(),R.layout.menu, recipes);

        if(listView != null)
            listView.setAdapter(recipeAdapter);
            //listView.setAdapter(menuItemAdapter);

        /*listView.setOnClickListener((adapterView, view, i, l) -> {
            Log.v("PLACE", menuItems[i].MealName);
        });*/

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Log.v("MENUITEM", menuItems[i].MealName);
                Log.v("RECIPE", recipes[i].get_recipe_name());
            }
        });
    }

    private ArrayList<Recipe> parseXML(){

        XmlPullParserFactory parserFactory;
        try{
            parserFactory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = parserFactory.newPullParser();
            InputStream is = (getResources().openRawResource(R.raw.ingredients));
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(is, null);

            return processParsing(parser);
        }catch(XmlPullParserException e){

        }catch (IOException e){

        }
    }

    private ArrayList<Recipe> processParsing(XmlPullParser parser)throws IOException, XmlPullParserException {
        ArrayList<Recipe> recipes = new ArrayList<>();
        int eventType = parser.getEventType();
        Recipe currentRecipe = null;

        while (eventType != XmlPullParser.END_DOCUMENT) {
            String eltName = null;

            switch (eventType) {
                case XmlPullParser.START_TAG ;
                    eltName = parser.getName();

                    if ("recipe".equals(eltName)) {
                        currentRecipe = new Ingredients();
                        recipes.add(currentRecipe);
                    } else if (currentRecipe != null) {
                        if ("recipeID".equals(eltName)) {
                            currentRecipe.setRecipe_id(Integer.parseInt(parser.nextText()));
                        } else if ("name".equals(eltName)) {
                            currentRecipe.setRecipe_name(parser.nextText());
                        } else if ("cuisine".equals(eltName)) {
                            currentRecipe.setCuisine(parser.nextText());
                        } else if ("mealTime".equals(eltName)) {
                            currentRecipe.setMeal_time(Integer.parseInt(parser.nextText()));
                        } else if ("cookingTime ".equals(eltName)) {
                            currentRecipe.setCook_time(Integer.parseInt(parser.nextText()));
                        } else if ("difficulty ".equals(eltName)) {
                            currentRecipe.setDifficulty(parser.nextText());
                        } else if ("rating ".equals(eltName)) {
                            currentRecipe.setRating(Double.parseDouble(parser.nextText()));
                        } else if ("votes ".equals(eltName)) {
                            currentRecipe.setVotes(Integer.parseInt(parser.nextText()));
                    /*}else if("ingredients".equals(eltName)) {

                    }*/
                        }
                        break;
                    }

                    eventType = parser.next();
            }

        }
        return recipes;
    }
}
