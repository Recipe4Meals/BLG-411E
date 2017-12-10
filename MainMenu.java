package com.two.project.computer.recipe4meals;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainMenu extends AppCompatActivity {

    MenuItem[] menuItems = new MenuItem[]{
            new MenuItem("Köfte", "Etli yemek.", 4.6, 12, "kofte"),
            new MenuItem("Makarna", "Kolay yemek.", 3.7, 23, "makarna"),
            new MenuItem("Karnıyarık", "Patlıcanlı yemek.", 3.9, 4, "karniyarik"),
    };


    private ListView listView;
    private ArrayAdapter menuItemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.List);
        menuItemAdapter = new MenuItemAdapter(getApplicationContext(),R.layout.menu, menuItems);

        if(listView != null)
            listView.setAdapter(menuItemAdapter);

        /*listView.setOnClickListener((adapterView, view, i, l) -> {
            Log.v("PLACE", menuItems[i].MealName);
        });*/

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.v("MENUITEM", menuItems[i].MealName);
            }
        });
    }

}
