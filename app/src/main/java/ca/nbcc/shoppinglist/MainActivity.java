package ca.nbcc.shoppinglist;

/*
    File:  MainActivity.java

    Author: Justin Lange
    This assignment represents my own work and is in accordance with the College Academic Policy

    Copyright(c) 2019 All Right Reserved by Justin Lange

    Date: 10-02-19
*/

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

    public static final int TEXT_REQUEST = 1;
    private ShoppingList list = new ShoppingList();

    //Get the list if it has been saved and restore it
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            list = (ShoppingList)savedInstanceState.getSerializable("list");
        }

        showList(list);
    }

    //Save the current list if the activity is halted
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("list", list);
    }

    //Get the item from the second activity and add it to the current list
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == TEXT_REQUEST) {
            String addedItem = data.getStringExtra(ShoppingItems.EXTRA_REPLY);

            if (addedItem != null) {
                list.addItemToList(addedItem);
            }
        }

        showList(list);
    }

    //Restore the current list
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        //Restore the list, if there is one, if the activity is restored
        if (savedInstanceState != null) {
            list = (ShoppingList)savedInstanceState.getSerializable("list");
        }

        showList(list);
    }

    //Launch the select item activity
    public void launchItemsList(View view) {
        Intent intent = new Intent(this, ShoppingItems.class);
        startActivityForResult(intent, TEXT_REQUEST);
    }

    private void showList(ShoppingList list) {
        //Get the list as a String, Integer pair
        Map<String, Integer> currentList = list.getShoppingList();

        //The current item textview being worked with in the next for loop
        int currentItem = 1;

        //Loop over all entries in the current shopping list and display them
        for (Map.Entry<String, Integer> entry : currentList.entrySet()) {
            //The id of the current item textview
            String currentItemId = "txtItem" + currentItem;

            //Get the key and value of the current Map entry
            String key = entry.getKey();
            int value = entry.getValue();

            //Find the textview for the item
            TextView currentItemText = findViewById(getResources().getIdentifier(currentItemId, "id", getPackageName()));

            //If a textview is found, display the item's name and quantity
            if (currentItemText != null) {
                currentItemText.setVisibility(View.VISIBLE);
                currentItemText.setText(key + " - " + Integer.toString(value));
            }

            currentItem++;
        }
    }
}
